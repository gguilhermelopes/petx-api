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
    public PetDetailsDTO insert(PetInsertDTO obj){

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

        return new PetDetailsDTO(pet);
    }

    public List<PetDetailsDTO> listAll(){

        return petRepository.findAll()
                .stream()
                .filter(pet -> pet.getPetOwner().getActive())
                .map(PetDetailsDTO::new)
                .toList();
    }

    public PetDetailsDTO FindBydId(Long id){
        Optional<Pet> pet = petRepository.findById(id);

        return new PetDetailsDTO(pet.orElseThrow(() -> new RuntimeException("Invalid id provided.")));
    }

    public PetDetailsDTO update(Long id, PetUpdateDTO obj){
        Pet pet = petRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid id provided."));

        if(obj.areAllPropertiesNull()) throw new RuntimeException("Invalid properties provided.");

        pet.updateInfo(obj);

        return new PetDetailsDTO(pet);
    }

    public void deleteById(Long id) {
       Optional<Pet> pet = petRepository.findById(id);
       if(pet.isEmpty()) throw new RuntimeException("Invalid id provided.");
       try{
           petRepository.deleteById(pet.get().getId());
       }catch (RuntimeException e){
           throw new RuntimeException(e.getMessage());
       }
    }
}
