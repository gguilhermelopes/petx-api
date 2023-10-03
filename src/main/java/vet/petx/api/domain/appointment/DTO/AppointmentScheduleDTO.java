package vet.petx.api.domain.appointment.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentScheduleDTO(
        Long veterinarianId,
        @NotNull
        Long petId,
        @NotNull
        @Future
        LocalDateTime dateTime
) {
}
