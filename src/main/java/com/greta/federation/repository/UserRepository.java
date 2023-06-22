package com.greta.federation.repository;

import com.greta.federation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);

  /*  @Query(value = "SELECT user_id, username, first_name, last_name, email, password " +
            "FROM user_info where username = :USERNAME ",
            nativeQuery = true)
    Optional<UserInfo> findByUsername(@Param("USERNAME") String USERNAME);

    @Query(value = "SELECT user_id, username, first_name, last_name, email, password " +
            "FROM user_info where email = :EMAIL ",
            nativeQuery = true)
    Optional<UserInfo> findByEmail(@Param("EMAIL") String EMAIL);*/
}
