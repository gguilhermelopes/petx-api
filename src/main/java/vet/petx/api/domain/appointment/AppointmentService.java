package vet.petx.api.domain.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.petx.api.domain.appointment.DTO.AppointmentDetailsDTO;
import vet.petx.api.domain.appointment.DTO.AppointmentScheduleDTO;
import vet.petx.api.domain.exceptions.ResourceNotFoundException;
import vet.petx.api.domain.pet.Pet;
import vet.petx.api.domain.pet.PetRepository;
import vet.petx.api.domain.veterinarian.Veterinarian;
import vet.petx.api.domain.veterinarian.VeterinarianRepository;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    VeterinarianRepository veterinarianRepository;
    @Autowired
    PetRepository petRepository;
    public AppointmentDetailsDTO scheduleAppointment(AppointmentScheduleDTO obj) {

        if(obj.veterinarianId() != null && veterinarianRepository.existsById(obj.veterinarianId()))
            throw new ResourceNotFoundException("Invalid veterinarian_id provided.");

        Veterinarian veterinarian = pickVeterinarian(obj);

        Pet pet = petRepository
                .findById(obj.petId())
                .orElseThrow(() -> new ResourceNotFoundException("Invalid pet_id provided."));

        Appointment appointment = new Appointment(null, veterinarian, pet, obj.dateTime());
        appointmentRepository.save(appointment);

        return new AppointmentDetailsDTO(
                appointment.getId(),
                appointment.getVeterinarian().getId(),
                appointment.getPet().getId(),
                appointment.getDateTime());
    }

    private Veterinarian pickVeterinarian(AppointmentScheduleDTO obj) {
        if(obj.veterinarianId() != null)
            return veterinarianRepository.getReferenceById(obj.veterinarianId());

        return veterinarianRepository.pickRandomVeterinarian(obj.dateTime());
    }
}
