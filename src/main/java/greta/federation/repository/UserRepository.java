package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
