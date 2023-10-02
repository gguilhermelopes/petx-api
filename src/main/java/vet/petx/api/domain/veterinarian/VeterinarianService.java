package vet.petx.api.domain.veterinarian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.petx.api.domain.veterinarian.DTO.VeterinarianDetailsDTO;
import vet.petx.api.domain.veterinarian.DTO.VeterinarianInsertDTO;
import vet.petx.api.domain.veterinarian.DTO.VeterinarianUpdateDTO;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {
    @Autowired
    private VeterinarianRepository repository;

    public VeterinarianDetailsDTO insert(VeterinarianInsertDTO obj) {
        Veterinarian veterinarian = new Veterinarian(obj);
        repository.save(veterinarian);

        return new VeterinarianDetailsDTO(veterinarian);
    }

    public List<VeterinarianDetailsDTO> listAll() {
        return repository.findAll()
                .stream()
                .filter(Veterinarian::getActive)
                .map(VeterinarianDetailsDTO::new)
                .toList();
    }

    public VeterinarianDetailsDTO findBydId(Long id){
        Optional<Veterinarian> veterinarian = repository.findById(id);

        return new VeterinarianDetailsDTO(veterinarian.orElseThrow(() -> new RuntimeException("Invalid id provided.")));
    }
    public VeterinarianDetailsDTO update(Long id, VeterinarianUpdateDTO obj){
        Veterinarian veterinarian = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid id provided."));

        if(obj.areAllPropertiesNull()) throw new RuntimeException("Invalid properties provided.");

        veterinarian.updateInfo(obj);

        return new VeterinarianDetailsDTO(veterinarian);
    }

    public void deleteById(Long id){
        Veterinarian veterinarian = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid id provided."));

        veterinarian.inactivateVet();
    }


}
