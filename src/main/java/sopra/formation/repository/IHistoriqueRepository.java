package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Historique;
import sopra.formation.model.Population;
import sopra.formation.model.Simulation;

public interface IHistoriqueRepository extends JpaRepository<Historique, Long> {

	Historique findByTic(Integer tic);
	
	Historique findByGenerationEnv(Integer generationEnv);
	Historique findByGenerationPop(Integer generationPop);
	Historique findBySimulation(Simulation simulation);
	
}
