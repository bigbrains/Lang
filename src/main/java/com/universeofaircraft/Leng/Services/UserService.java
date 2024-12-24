package com.universeofaircraft.Leng.Services;

import com.universeofaircraft.Leng.Entites.User;
import com.universeofaircraft.Leng.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final EntityManager em;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(EntityManager em, UserRepository userRepository) {
        this.em = em;
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public User signupUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        em.persist(user);
        em.flush();

        return user;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findOneByUsername(username);
        System.out.println("User not found!");
        if (user.isPresent()) {
            return user.get();
        }

        throw new UsernameNotFoundException("User not found!");
    }
}
