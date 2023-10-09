package vet.petx.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vet.petx.api.domain.appointment.AppointmentRepository;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;

import java.time.LocalDateTime;

@Component
public class PetAppointmentValidator  implements AppointmentValidator{
    @Autowired
    private AppointmentRepository repository;
    @Override
    public void validate(AppointmentScheduleDTO obj) {
        LocalDateTime firstTime = obj.dateTime().withHour(7);
        LocalDateTime lastTime = obj.dateTime().withHour(18);

        Boolean hasAppointmentToday = repository.existsByPetIdAndDateTime(obj.petId(), obj.dateTime());

        if(hasAppointmentToday) throw new ValidationException("Pet already booked for today.");

    }
}
