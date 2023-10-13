package vet.petx.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vet.petx.api.domain.user.DTO.UserDetailsDTO;
import vet.petx.api.domain.user.DTO.UserFindByEmailDTO;
import vet.petx.api.domain.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDetailsDTO> findByEmail(@RequestBody String email){
        return ResponseEntity.ok().body(service.findByEmail(email));
    }
}
