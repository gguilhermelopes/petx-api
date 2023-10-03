package vet.petx.api.domain.appointment.validations;

import jakarta.validation.ValidationException;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;

import java.time.Duration;
import java.time.LocalDateTime;

public class AppointmentAdvanceTimeValidator {

    public void validate(AppointmentScheduleDTO obj) {
        LocalDateTime appointmentDateTime = obj.dateTime();
        LocalDateTime now = LocalDateTime.now();

        Long minutesInterval = Duration.between(now, appointmentDateTime).toMinutes();

        if(minutesInterval < 30){
            throw new ValidationException("Appointment must be scheduled with at least a 30-minute advance notice.");
        }
    }
}
