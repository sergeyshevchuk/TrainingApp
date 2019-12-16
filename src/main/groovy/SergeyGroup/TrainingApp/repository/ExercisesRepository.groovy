package SergeyGroup.TrainingApp.repository

import SergeyGroup.TrainingApp.domain.Exercises


//import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface ExercisesRepository extends CrudRepository<Exercises, Integer> {

}