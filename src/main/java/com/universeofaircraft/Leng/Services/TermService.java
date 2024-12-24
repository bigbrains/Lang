package com.universeofaircraft.Leng.Services;

import com.universeofaircraft.Leng.Entites.Set;
import com.universeofaircraft.Leng.Entites.Term;
import com.universeofaircraft.Leng.Repository.TermRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermService
{
    private final EntityManager em;
    private final TermRepository termRepository;

    public TermService(EntityManager em, TermRepository termRepository) {
        this.em = em;
        this.termRepository = termRepository;
    }

    public void createTerms(java.util.Set<Term> terms, Set set) {
        for(Term term : terms) {
            term.setSet(set);
            em.persist(term);
        }
        em.flush();
    }

    public void deleteTerms(Set set) {
        List<Term> terms = termRepository.findBySet(set);
        for (Term term : terms) {
            em.remove(term);
        }
        em.flush();
    }

    public List<Term> getTerms(Set set) {
        return termRepository.findBySet(set);
    }
}
