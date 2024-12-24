package com.universeofaircraft.Leng.Repository;

import com.universeofaircraft.Leng.Entites.Learn;
import com.universeofaircraft.Leng.Entites.Set;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LearnRepository extends CrudRepository<Learn, Integer> {
    Optional<Learn> findOneBySet(Set learnSet);
}
