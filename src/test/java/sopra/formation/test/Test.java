package sopra.formation.test;

import sopra.formation.app.Application;
import sopra.formation.model.Creature;
import sopra.formation.model.Environnement;
import sopra.formation.model.Historique;
import sopra.formation.model.ParametresGenetiques;
import sopra.formation.model.Population;
import sopra.formation.model.Simulation;
import sopra.formation.model.User;
import sopra.formation.repository.ICreatureRepository;
import sopra.formation.repository.IEnvironnementRepository;
import sopra.formation.repository.IHistoriqueRepository;
import sopra.formation.repository.IParametresGenetiquesRepository;
import sopra.formation.repository.IPopulationRepository;
import sopra.formation.repository.ISimulationRepository;
import sopra.formation.repository.IUserRepository;


public class Test {

	public static void main(String[] args) {
		Application.getInstance();
		
		 ICreatureRepository creatureRepo = Application.getInstance().getCreatureRepo();
		 IPopulationRepository populationRepo = Application.getInstance().getPopulationRepo();
		 IParametresGenetiquesRepository parametresRepo = Application.getInstance().getParametresRepo();
		 IEnvironnementRepository environnementRepo = Application.getInstance().getEnvironnementRepo();
		 IHistoriqueRepository historiqueRepo = Application.getInstance().getHistoriqueRepo();
		 ISimulationRepository simulationRepo = Application.getInstance().getSimulationRepo();
		 IUserRepository userRepo = Application.getInstance().getUserRepo();
		 
		 
		 Creature crea1 = new Creature();
		 crea1.setTaille(2);
		 crea1.setVitesse(1);
		 crea1.setTaille(2);
		 crea1.setVision(0);
		 
		 Environnement env1 = new Environnement();
		 env1.setTaillex(40);
		 env1.setTailley(20);
		 env1.setTerrain("V1");
		 
		 Historique hist1 = new Historique();
		
		 
		 ParametresGenetiques pGenes1 = new ParametresGenetiques();
		 pGenes1.setTauxMutation(12);
		 
		 Population p1 = new Population();
		 p1.setLimiteVision(5);
		 p1.setLimiteTaille(5);
		 p1.setLimiteVitesse(5);
		 
		 Simulation sim1 = new Simulation();
		 sim1.setNom("Simulation 1");
		 
		 User user1 = new User();
		 user1.setMail("google@gmail.com");
		 
		 crea1 = creatureRepo.save(crea1);
		 
		 hist1 = historiqueRepo.save(hist1);
		 pGenes1 = parametresRepo.save(pGenes1);
		 env1 = environnementRepo.save(env1);
		 sim1= simulationRepo.save(sim1);
		 user1 = userRepo.save(user1);
		 
		 p1.setEnvironnement(env1);
		 p1.setHistoriques(hist1);
		 p1.setParametres(pGenes1);
		 p1.setSimulation(sim1);
		 p1 = populationRepo.save(p1);
		 
		 env1.setHistorique(hist1);
		 env1.setPopulation(p1);
		 env1.setSimulation(sim1);
		 env1 = environnementRepo.save(env1);
	}

}
