package vet.petx.api.domain.veterinarian;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {

    Page<Veterinarian> findAllByActiveTrue(Pageable pageable);

    @Query("""
            SELECT v FROM Veterinarian v
            WHERE
                v.active = true
                AND
                v.specialization = 0
                AND
                v.id NOT IN (
                    SELECT a.veterinarian.id FROM Appointment a
                    WHERE
                    a.dateTime = :dateTime
                )
            ORDER BY RAND()
            LIMIT 1;
            """)
    Veterinarian pickRandomVeterinarian(LocalDateTime dateTime);
}
