package sopra.formation.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.formation.model.Environnement;
import sopra.formation.model.Simulation;
import sopra.formation.repository.ISimulationRepository;

public class SimulationRepositoryJpa implements ISimulationRepository {

	@Override
	public List<Simulation> findAll() {
		List<Simulation> simulations = new ArrayList<Simulation>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Simulation> query = em.createQuery("select s from Simulation s",Simulation.class);

			 simulations  = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return  simulations ;
	}

	@Override
	public Simulation findById(Integer id) {
		 Simulation  simulations = null;

			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEntityManagerFactory().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				 simulations = em.find( Simulation.class, id);

				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

			} finally {
				if (em != null) {
					em.close();
				}
			}

			return  simulations;
		}

	@Override
	public Simulation save(Simulation obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.merge(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return obj;
	}


	@Override
	public void delete(Simulation obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			em.remove(em.merge(obj));

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	
}
