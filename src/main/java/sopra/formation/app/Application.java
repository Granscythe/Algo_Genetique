package sopra.formation.app;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.ICreatureRepository;
import sopra.formation.repository.IEnvironnementRepository;
import sopra.formation.repository.IHistoriqueRepository;
import sopra.formation.repository.IParametresGenetiquesRepository;
import sopra.formation.repository.IPopulationRepository;
import sopra.formation.repository.ISimulationRepository;
import sopra.formation.repository.IUserRepository;
import sopra.formation.repository.jpa.CreatureRepositoryJpa;
import sopra.formation.repository.jpa.EnvironnementRepositoryJpa;
import sopra.formation.repository.jpa.HistoriqueRepositoryJpa;
import sopra.formation.repository.jpa.ParametresGenetiquesRepositoryJpa;
import sopra.formation.repository.jpa.PopulationRepositoryJpa;
import sopra.formation.repository.jpa.SimulationRepositoryJpa;
import sopra.formation.repository.jpa.UserRepositoryJpa;




public class Application {
	private static Application instance = null;

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Algo_genetique");

	private final ICreatureRepository creatureRepo = new CreatureRepositoryJpa();
	private final IPopulationRepository populationRepo = new PopulationRepositoryJpa();
	private final IParametresGenetiquesRepository parametresRepo = new ParametresGenetiquesRepositoryJpa();
	private final IEnvironnementRepository environnementRepo = new EnvironnementRepositoryJpa();
	private final IHistoriqueRepository historiqueRepo = new HistoriqueRepositoryJpa();
	private final ISimulationRepository simulationRepo = new SimulationRepositoryJpa();
	private final IUserRepository userRepo = new UserRepositoryJpa();
	


	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public ICreatureRepository getCreatureRepo() {
		return creatureRepo;
	}

	public IPopulationRepository getPopulationRepo() {
		return populationRepo;
	}

	public IParametresGenetiquesRepository getParametresRepo() {
		return parametresRepo;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}

	public IEnvironnementRepository getEnvironnementRepo() {
		return environnementRepo;
	}

	public IHistoriqueRepository getHistoriqueRepo() {
		return historiqueRepo;
	}

	public ISimulationRepository getSimulationRepo() {
		return simulationRepo;
	}

	public IUserRepository getUserRepo() {
		return userRepo;
	}
	
	
	
}

