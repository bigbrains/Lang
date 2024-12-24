package com.universeofaircraft.Leng.Repository;

import com.universeofaircraft.Leng.Entites.Set;
import com.universeofaircraft.Leng.Entites.Term;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TermRepository extends CrudRepository<Term, Integer> {

    List<Term> findBySet(Set lastName);

}