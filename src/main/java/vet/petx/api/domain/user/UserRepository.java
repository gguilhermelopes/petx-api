package vet.petx.api.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import vet.petx.api.domain.user.DTO.UserFindByEmailDTO;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.email = :email")
     User findByUsername(String email);
}
