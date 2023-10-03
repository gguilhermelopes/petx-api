package vet.petx.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.petx.api.domain.appointment.AppointmentService;
import vet.petx.api.domain.appointment.DTO.AppointmentDetailsDTO;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService service;
    @PostMapping
    @Transactional
    public void schedule(@RequestBody @Valid AppointmentScheduleDTO obj){
       service.scheduleAppointment(obj);

    }
}
