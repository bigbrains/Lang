package com.universeofaircraft.Leng.Repository;

import com.universeofaircraft.Leng.Entites.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findOneByUsername(String username);
}
