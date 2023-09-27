package vet.petx.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;
import vet.petx.api.domain.veterinarian.*;

import java.net.URI;


@CrossOrigin
@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<VeterinarianDTODetails> insert(
            @RequestBody @Valid VeterinarianDTOInsert obj,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Veterinarian vet = new Veterinarian(obj);
        repository.save(vet);

        URI uri = uriComponentsBuilder.path("/veterinarians/{id}").
                        buildAndExpand(vet.getId()).toUri();

        return ResponseEntity.created(uri).body(new VeterinarianDTODetails(vet));

    }

    @GetMapping
    public ResponseEntity<Page<VeterinarianDTOList>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        var response = repository.findAllByActiveTrue(pageable).map(VeterinarianDTOList::new);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeterinarianDTODetails> listById(@PathVariable Long id){
        Veterinarian vet = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new VeterinarianDTODetails(vet));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<VeterinarianDTODetails> update(@RequestBody @Valid VeterinarianDTOUpdate obj) {
        Veterinarian vet = repository.getReferenceById(obj.id());
        vet.updateInfo(obj);

        return ResponseEntity.ok().body(new VeterinarianDTODetails(vet));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Veterinarian vet = repository.getReferenceById(id);
        vet.inactivateVet();

        return ResponseEntity.noContent().build();
    }
}
