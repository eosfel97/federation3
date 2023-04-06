package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer> {
    @Query(value = "select u from User u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);
}
