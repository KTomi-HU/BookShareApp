package hu.flow.ktomi.BookShare.persistence.repository;

import hu.flow.ktomi.BookShare.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByUsername(String username);

    User findByUsername(String username);

    void deleteByUsername(String username);
}
