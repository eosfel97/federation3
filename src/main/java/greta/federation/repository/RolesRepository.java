package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository  extends JpaRepository<Roles, Long> {
}
