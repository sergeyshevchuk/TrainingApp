package SergeyGroup.TrainingApp.repository

import SergeyGroup.TrainingApp.domain.Training


//import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

import java.awt.GridBagConstraints

interface TrainingRepository extends CrudRepository<Training, Integer> {

}