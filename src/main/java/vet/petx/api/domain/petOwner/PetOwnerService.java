package vet.petx.api.domain.petOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.petx.api.domain.petOwner.DTO.PetOwnerDetailsDTO;
import vet.petx.api.domain.petOwner.DTO.PetOwnerInsertDTO;
import vet.petx.api.domain.petOwner.DTO.PetOwnerUpdateDTO;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerService {
    @Autowired
    private PetOwnerRepository repository;

    public PetOwnerDetailsDTO insert(PetOwnerInsertDTO obj) {
        PetOwner petOwner = new PetOwner(obj);
        repository.save(petOwner);

        return new PetOwnerDetailsDTO(petOwner);
    }

    public List<PetOwnerDetailsDTO> listAll() {
        return repository.findAll()
                .stream()
                .filter(PetOwner::getActive)
                .map(PetOwnerDetailsDTO::new)
                .toList();
    }

    public PetOwnerDetailsDTO findBydId(Long id){
        Optional<PetOwner> petOwner = repository.findById(id);

        return new PetOwnerDetailsDTO(petOwner.orElseThrow(() -> new RuntimeException("Invalid id provided.")));
    }

    public PetOwnerDetailsDTO update(Long id, PetOwnerUpdateDTO obj){
        PetOwner petOwner = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid id provided."));

        if(obj.areAllPropertiesNull()) throw new RuntimeException("Invalid properties provided.");

        petOwner.updateInfo(obj);

        return new PetOwnerDetailsDTO(petOwner);
    }

    public void deleteById(Long id){
        PetOwner petOwner = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid id provided."));

        petOwner.inactivateVet();
    }
}
