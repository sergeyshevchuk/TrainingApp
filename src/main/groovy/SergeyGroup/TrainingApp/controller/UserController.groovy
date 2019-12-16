package SergeyGroup.TrainingApp.controller

import SergeyGroup.TrainingApp.model.NewUserDTO
import SergeyGroup.TrainingApp.model.UserDTO
import SergeyGroup.TrainingApp.service.UserService
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping('/api/user')
class UserController {
    @Autowired
    UserService userService

    @GetMapping
    List<UserDTO> getAllUser() {
        userService
                .getUsers()
    }

    @GetMapping('email/{email}')
    ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        userService
                .userByEmail(email)
                .map { ResponseEntity.ok(it) }
                .orElse(ResponseEntity.notFound().build())
    }

    @GetMapping('name/{name}')
    ResponseEntity<UserDTO> getUserByName(@PathVariable String name) {
        userService
                .userByName(name)
                .map { ResponseEntity.ok(it) }
                .orElse(ResponseEntity.notFound().build())

    }
    @PostMapping('/registration')
    ResponseEntity<UserDTO> createNewUser(@RequestBody NewUserDTO user){
        userService
                    .newUser(user)
                    .map { ResponseEntity.ok(it) }
                    .orElse(ResponseEntity.notFound().build())
    }
}