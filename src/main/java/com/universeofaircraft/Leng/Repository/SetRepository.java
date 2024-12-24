package com.universeofaircraft.Leng.Repository;

import com.universeofaircraft.Leng.Entites.Set;
import com.universeofaircraft.Leng.Entites.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SetRepository extends CrudRepository<Set, Integer> {
    List<Set> findAllByUser(User user);
}
