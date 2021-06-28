package com.htw.whoisdown.repository;


import com.htw.whoisdown.user.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Long> {

    UserApp findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
