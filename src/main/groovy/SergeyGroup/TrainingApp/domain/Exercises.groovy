package SergeyGroup.TrainingApp.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    String name

    String description

    BigDecimal duration

    ExerciseType exerciseType

    @ManyToOne
    Training training
}
