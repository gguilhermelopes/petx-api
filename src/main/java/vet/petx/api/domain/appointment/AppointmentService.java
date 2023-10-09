package vet.petx.api.domain.appointment;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.petx.api.domain.appointment.DTO.AppointmentDetailsDTO;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;
import vet.petx.api.domain.appointment.validations.AppointmentValidator;
import vet.petx.api.domain.exceptions.ResourceNotFoundException;
import vet.petx.api.domain.pet.Pet;
import vet.petx.api.domain.pet.PetRepository;
import vet.petx.api.domain.veterinarian.Veterinarian;
import vet.petx.api.domain.veterinarian.VeterinarianRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    VeterinarianRepository veterinarianRepository;
    @Autowired
    PetRepository petRepository;

    @Autowired
    private List<AppointmentValidator> validators;
    public AppointmentDetailsDTO scheduleAppointment(AppointmentScheduleDTO obj) {

        if(obj.veterinarianId() != null && !veterinarianRepository.existsById(obj.veterinarianId()))
            throw new ResourceNotFoundException("Invalid veterinarian_id provided.");

        validators.forEach(validator -> validator.validate(obj));

        Veterinarian veterinarian = pickVeterinarian(obj);

        if(veterinarian == null) throw new ValidationException("No veterinarians available for the date/time provided.");

        Pet pet = petRepository
                .findById(obj.petId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid pet_id provided."));

        Appointment appointment = new Appointment(null, veterinarian, pet, obj.dateTime());
        appointmentRepository.save(appointment);

        return new AppointmentDetailsDTO(appointment);
    }

    public List<AppointmentDetailsDTO> listAll(){
        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentDetailsDTO::new)
                .toList();
    }

    public void deleteById(Long id){
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isEmpty()) throw new RuntimeException("Invalid id provided.");

        try {
            appointmentRepository.deleteById(appointment.get().getId());
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    private Veterinarian pickVeterinarian(AppointmentScheduleDTO obj) {
        if(obj.veterinarianId() != null)
            return veterinarianRepository.getReferenceById(obj.veterinarianId());

        return veterinarianRepository.pickRandomVeterinarian(obj.dateTime());
    }
}
