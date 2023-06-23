package it.ictpiemonte.immobiliare.repository;

import it.ictpiemonte.immobiliare.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsernameAndPassword(String username, String encryptedPassword);

    // Query in SQL nativo
    @Modifying
    @Transactional
    @Query(value="UPDATE user SET password = :newPassword WHERE id = :userId", nativeQuery = true)
    void aggiornaPassword(@Param("userId") int userId, @Param("newPassword") String newPassword);

}
