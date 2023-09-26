package vet.petx.api.veterinarian;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {

    Page<Veterinarian> findAllByActiveTrue(Pageable pageable);
}
