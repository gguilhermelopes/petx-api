package vet.petx.api.domain.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.petx.api.domain.pet.DTO.PetDetailsDTO;
import vet.petx.api.domain.pet.DTO.PetInsertDTO;
import vet.petx.api.domain.pet.DTO.PetUpdateDTO;
import vet.petx.api.domain.petOwner.PetOwner;
import vet.petx.api.domain.petOwner.PetOwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetOwnerRepository petOwnerRepository;
    public Pet insert(PetInsertDTO obj){

        Optional<PetOwner> petOwner = petOwnerRepository.findById(obj.petOwnerId());
        if(petOwner.isEmpty()) throw new RuntimeException("Couldn't find pet owner with provided id.");


        Pet pet = new Pet(
                null,
                obj.name(),
                obj.species(),
                obj.age(),
                obj.breed(),
                obj.weight(),
                petOwner.get()
        );

        petRepository.save(pet);

        return pet;
    }

    public List<PetDetailsDTO> listAll(){
        List<PetDetailsDTO> petList = petRepository.findAll()
                .stream()
                .filter(pet -> pet.getPetOwner().getActive())
                .map(PetDetailsDTO::new)
                .toList();

        return petList;
    }

    public PetDetailsDTO FindBydId(Long id){
        Pet pet = petRepository.getReferenceById(id);

        return new PetDetailsDTO(pet);
    }

    public PetDetailsDTO update(Long id, PetUpdateDTO obj){
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isEmpty()) throw new RuntimeException("Invalid id provided.");

        if(obj.areAllPropertiesNull()) throw new RuntimeException("Invalid properties provided.");

        pet.get().updateInfo(obj);

        return new PetDetailsDTO(pet.get());
    }
}
