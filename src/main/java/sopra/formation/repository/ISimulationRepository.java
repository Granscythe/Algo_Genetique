package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Environnement;
import sopra.formation.model.Simulation;
import sopra.formation.model.User;

public interface ISimulationRepository extends JpaRepository<Simulation, Integer>{

	Simulation findByNom(String nom);
	List<Simulation> findByModeSimulation(String name);
	List<Simulation> findByUser(User nom);	
	List<Simulation> findByEnvironnement(Environnement environnement);
}
