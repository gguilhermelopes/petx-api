package vet.petx.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import vet.petx.api.domain.user.DTO.AuthDataDTO;
import vet.petx.api.domain.user.DTO.RegisterDataDTO;
import vet.petx.api.domain.user.User;
import vet.petx.api.domain.user.UserRepository;
import vet.petx.api.infra.security.TokenDataDTO;
import vet.petx.api.infra.security.TokenService;

import java.net.URI;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<TokenDataDTO> login(@RequestBody @Valid AuthDataDTO obj){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(obj.email(), obj.password());

        Authentication authentication = manager.authenticate(authenticationToken);

        String JwtToken = tokenService.createToken((User) authentication.getPrincipal());

        return ResponseEntity.ok().body(new TokenDataDTO(JwtToken));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDataDTO obj, UriComponentsBuilder uriComponentsBuilder){
        if(this.userRepository.findByEmail(obj.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(obj.password());

        User newUser = new User(obj.email(), encryptedPassword, obj.role());

        this.userRepository.save(newUser);

        URI uri = uriComponentsBuilder.path("/users/{id}")
                .buildAndExpand(newUser.getId()).toUri();


        return ResponseEntity.created(uri).build();
    }
}
