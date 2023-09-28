package vet.petx.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.petx.api.domain.user.DTO.AuthDataDTO;
import vet.petx.api.domain.user.User;
import vet.petx.api.infra.security.TokenDataDTO;
import vet.petx.api.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDataDTO> login(@RequestBody @Valid AuthDataDTO obj){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(obj.email(), obj.password());

        Authentication authentication = manager.authenticate(authenticationToken);

        String JwtToken = tokenService.createToken((User) authentication.getPrincipal());

        return ResponseEntity.ok().body(new TokenDataDTO(JwtToken));
    }
}
