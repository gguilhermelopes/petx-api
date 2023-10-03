package vet.petx.api.domain.appointment.DTO;

import java.time.LocalDateTime;

public record AppointmentDetailsDTO(Long id, Long veterinarianId, Long petId, LocalDateTime dateTime) {
}
