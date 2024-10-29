package com.example.PersistenceTutorial

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*

@SpringBootApplication
class PersistenceTutorialApplication

fun main(args: Array<String>) {
	runApplication<PersistenceTutorialApplication>(*args)
}

interface PlayerDataRepository: JpaRepository<playerdata, Long>
{

}

@RestController
@RequestMapping("api")


class PlayerDataRestController(val PlayerDataRepo: PlayerDataRepository)
{
	@GetMapping("PlayerData") // controls where the map goes localhost:8080/Example
	fun GetAll() = PlayerDataRepo.findAll()

	@PostMapping("PlayerData")
	fun SavePlayerData(@RequestBody PlayerData: playerdata)
	{
		PlayerDataRepo.save(PlayerData)
	}
}

@Entity
class playerdata(
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	val Id: Long = 0, var Xcoord: Float = 0.0f, var Ycoord: Float = 0.0f, var Zcoord: Float = 0.0f
)


//interfacenterface MachineStateRepository: JpaRepository<machinestate, Long>
//{
//
//}


//class MachineStateController(val MachineStateRepo: MachineStateRepository)
//{
//	@GetMapping("Example")
//	fun TestFunction(): List<machinestate>
//	{
//		return MachineStateRepo.findAll()
//	}
//
//}

//@Entity
//class machinestate(
//	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	val Id: Long = 0, var OnButton: Boolean = true, var OffButton: Boolean = false
//)

