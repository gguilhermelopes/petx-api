package vet.petx.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ClinicOperatingHoursValidator implements AppointmentValidator {

    public void validate(AppointmentScheduleDTO obj){
        LocalDateTime appointmentDateTime = obj.dateTime();

        if(appointmentDateTime.equals(DayOfWeek.SUNDAY)
                || appointmentDateTime.getHour() < 7
                || appointmentDateTime.getHour() > 18)
            throw new ValidationException("Date/Time provided is outside of operating hours.");
    }
}
