package vet.petx.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vet.petx.api.domain.appointment.AppointmentRepository;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;

@Component
public class VeterinarianDateTimeAppointmentValidator implements AppointmentValidator {
    @Autowired
    private AppointmentRepository repository;

    public void validate(AppointmentScheduleDTO obj){
        Boolean hasAnotherAppointment = repository.existsByVeterinarianIdAndDateTime(obj.veterinarianId(), obj.dateTime());

        if(hasAnotherAppointment)
            throw new ValidationException("The veterinarian is already booked for this date and time.");
    }
}
