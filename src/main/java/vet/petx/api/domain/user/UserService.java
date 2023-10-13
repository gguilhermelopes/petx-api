package vet.petx.api.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.petx.api.domain.user.DTO.UserDetailsDTO;
import vet.petx.api.domain.user.DTO.UserFindByEmailDTO;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserDetailsDTO findByEmail(String email){
        User user = repository.findByUsername(email);


        if(user == null) throw new RuntimeException("Usuário não encontrado com o email informado.");

        return new UserDetailsDTO(user.getEmail(), user.getName(), user.getRole());
    }


}
