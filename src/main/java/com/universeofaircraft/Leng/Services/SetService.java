package com.universeofaircraft.Leng.Services;

import com.universeofaircraft.Leng.Entites.Set;
import com.universeofaircraft.Leng.Entites.User;
import com.universeofaircraft.Leng.Repository.SetRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SetService {
    private final EntityManager em;
    private final TermService termService;
    private final SetRepository setRepository;

    public SetService(EntityManager em, TermService termService, SetRepository setRepository) {
        this.em = em;
        this.termService = termService;
        this.setRepository = setRepository;
    }

    @Transactional
    public Integer addSet(Set set, User user) {
        set.setUser(user);
        em.persist(set);
        em.flush();
        termService.createTerms(set.getTerms(), set);

        return set.getId();
    }

    @Transactional
    public void updateSet(Set set, User user) {
        Set fetchedSet = em.find(Set.class, set.getLastPersistedId());
        termService.deleteTerms(fetchedSet);
        em.remove(fetchedSet);
        em.flush();
        addSet(set, user);
    }

    public List<Set> getAllSets() {
        return em.createQuery("from Set", Set.class).getResultList();
    }

    public Set getSetById(int id) {
        return setRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
