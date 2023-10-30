package pp.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pp.spring.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
