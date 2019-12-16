package SergeyGroup.TrainingApp.domain

import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import java.time.LocalDateTime

@Entity
class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id

    String name

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    LocalDateTime data

   BigDecimal duration

    @ManyToOne
    User user

    @OneToMany( fetch = FetchType.LAZY,  mappedBy = 'training' )
    List<Exercises> exercises = []

}
