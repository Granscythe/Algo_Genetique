package sopra.formation.app;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.ICreatureRepository;
import sopra.formation.repository.IParametresGenetiquesRepository;
import sopra.formation.repository.IPopulationRepository;
import sopra.formation.repository.jpa.CreatureRepositoryJpa;
import sopra.formation.repository.jpa.ParametresGenetiquesRepositoryJpa;
import sopra.formation.repository.jpa.PopulationRepositoryJpa;




public class Application {
	private static Application instance = null;

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Algo_genetique");

	private final ICreatureRepository creatureRepo = new CreatureRepositoryJpa();
	private final IPopulationRepository populationRepo = new PopulationRepositoryJpa();
	private final IParametresGenetiquesRepository parametresRepo = new ParametresGenetiquesRepositoryJpa();

	


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
	
	
}

