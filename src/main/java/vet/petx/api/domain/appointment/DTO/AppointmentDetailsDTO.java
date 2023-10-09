package vet.petx.api.domain.appointment.DTO;


import vet.petx.api.domain.appointment.Appointment;


import java.time.LocalDateTime;

public record AppointmentDetailsDTO(Long id, String veterinarian, String pet, String petOwner, LocalDateTime dateTime) {
    public AppointmentDetailsDTO(Appointment appointment) {
        this(appointment.getId(),
                appointment.getVeterinarian().getName(),
                appointment.getPet().getName(),
                appointment.getPet().getPetOwner().getName(),
                appointment.getDateTime());
    }
}
