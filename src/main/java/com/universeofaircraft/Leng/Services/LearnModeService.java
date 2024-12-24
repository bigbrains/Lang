package com.universeofaircraft.Leng.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.universeofaircraft.Leng.Entites.Learn;
import com.universeofaircraft.Leng.Entites.Set;
import com.universeofaircraft.Leng.Entites.Term;
import com.universeofaircraft.Leng.Repository.LearnRepository;
import com.universeofaircraft.Leng.Repository.SetRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LearnModeService {

    private final EntityManager em;
    private final SetService setService;
    private final LearnRepository learnRepository;

    public LearnModeService(EntityManager em, SetService setService, LearnRepository learnRepository) {
        this.setService = setService;
        this.em = em;
        this.learnRepository = learnRepository;
    }

    public Learn startLearning(Set set) {
        java.util.Set<Term> terms = set.getTerms();
        Map<Integer, Integer> map = new HashMap<>();
        for (Term term : terms) {
            map.put(term.getId(), 0);
        }
        Learn learn = new Learn();
        learn.setSet(set);
        Gson gson = new GsonBuilder().create();
        String jsonData = gson.toJson(map);
        learn.setData(jsonData);

        return learn;
    }

    @Transactional
    protected int createLearning(int setId) {
        Set set = em.find(Set.class, setId);
        java.util.Set<Term> terms = set.getTerms();
        Map<Integer, Integer> map = new HashMap<>();
        for (Term term : terms) {
            map.put(term.getId(), 0);
        }
        Learn learn = new Learn();
        learn.setSet(set);
        Gson gson = new GsonBuilder().create();
        String jsonData = gson.toJson(map);
        learn.setData(jsonData);

        em.persist(learn);
        em.flush();

        return learn.getId();
    }

    @Transactional
    public int createOrFetchLearnId(int setId) {
        return isLearningExistsWithSet(setId) ? findLearnBySetId(setId).getId() : createLearning(setId);
    }

    public Learn findLearnBySetId(int setId) {
        Set set = setService.getSetById(setId);

        return learnRepository.findOneBySet(set).orElseThrow(IllegalArgumentException::new);
    }

    public Learn getLearn(int id) {
        return em.find(Learn.class, id);
    }

    private boolean isLearningExistsWithSet(int setId) {
        Set set = setService.getSetById(setId);

        return learnRepository.findOneBySet(set).isPresent();
    }

    public void updateLearnData(String jsonData) {}
}
