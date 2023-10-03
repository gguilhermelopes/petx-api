package vet.petx.api.domain.appointment;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Boolean existsByVeterinarianIdAndDateTime(Long veterinarianId, LocalDateTime dateTime);
}
