package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(String role);
}
