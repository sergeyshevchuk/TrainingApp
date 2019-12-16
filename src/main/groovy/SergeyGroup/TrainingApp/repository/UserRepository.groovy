package SergeyGroup.TrainingApp.repository

import SergeyGroup.TrainingApp.domain.User


//import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

import javax.persistence.Id

interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll()

    Optional<User> findByEmail(String email)

    Optional<User> findByName(String name)
}
