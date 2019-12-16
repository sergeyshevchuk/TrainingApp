package SergeyGroup.TrainingApp.service

import SergeyGroup.TrainingApp.domain.User
import SergeyGroup.TrainingApp.model.NewUserDTO
import SergeyGroup.TrainingApp.model.UserDTO
import SergeyGroup.TrainingApp.repository.UserRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Slf4j
@Service
class UserService {
    @Autowired UserRepository userRepository
    List<UserDTO> getUsers() {
        userRepository
                .findAll()
                .collect {it -> new UserDTO(name: it.name, email:it.email, age:it.age, weight: it.weight)}
    }
    Optional<UserDTO> userByEmail(String email) {
        userRepository
                        .findByEmail(email)
                        .map{Optional.of(new UserDTO(name: it.name, email:it.email, age:it.age, weight: it.weight))}
                        .orElse(Optional.empty())

    }

    Optional<UserDTO> userByName(String name) {
        userRepository
                .findByName(name)
                .map{Optional.of(new UserDTO(name: it.name, email:it.email, age:it.age, weight: it.weight))}
                .orElse(Optional.empty())
    }
    Optional<UserDTO> newUser(NewUserDTO user){
    def userEmail = userByEmail(user.email)
    if (userEmail.isPresent() ){
    log.info('Такой E-MAIL существует')
        Optional.empty()
    }
        def saver = userRepository.save(new User(name: user.name, email: user.email,
                password: user.password, age: user.age, weight: user.weight))
        Optional.of(new UserDTO(name: saver.name, email:saver.email, age:saver.age, weight: saver.weight))

    }
}

