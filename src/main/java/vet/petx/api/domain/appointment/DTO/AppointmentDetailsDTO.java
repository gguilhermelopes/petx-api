package vet.petx.api.domain.appointment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import vet.petx.api.domain.appointment.Appointment;
import vet.petx.api.domain.pet.Pet;
import vet.petx.api.domain.veterinarian.Veterinarian;

import java.time.LocalDateTime;

public record AppointmentDetailsDTO(Long id, String veterinarian, Pet pet, LocalDateTime dateTime) {
    public AppointmentDetailsDTO(Appointment appointment) {
        this(appointment.getId(),
                appointment.getVeterinarian().getName(),
                appointment.getPet(),
                appointment.getDateTime());
    }
}
