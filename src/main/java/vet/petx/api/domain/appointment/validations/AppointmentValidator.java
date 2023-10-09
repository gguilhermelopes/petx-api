package vet.petx.api.domain.appointment.validations;

import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;

public interface AppointmentValidator {
    void validate (AppointmentScheduleDTO obj);
}
