package vet.petx.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vet.petx.api.domain.appointment.AppointmentService;
import vet.petx.api.domain.appointment.DTO.AppointmentDetailsDTO;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/appointments")
@SecurityRequirement(name = "bearer-key")
public class AppointmentController {
    @Autowired
    private AppointmentService service;
    @PostMapping
    @Transactional
    public ResponseEntity<AppointmentDetailsDTO> schedule(@RequestBody @Valid AppointmentScheduleDTO obj){
       return ResponseEntity.ok().body(service.scheduleAppointment(obj));

    }

    @GetMapping
    public ResponseEntity<List<AppointmentDetailsDTO>> list(){
        return ResponseEntity.ok().body(service.listAll());
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
