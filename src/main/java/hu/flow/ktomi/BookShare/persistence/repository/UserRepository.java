package hu.flow.ktomi.BookShare.persistence.repository;

import hu.flow.ktomi.BookShare.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
