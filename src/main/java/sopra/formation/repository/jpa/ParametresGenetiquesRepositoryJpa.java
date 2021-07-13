package sopra.formation.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.formation.app.Application;
import sopra.formation.model.ParametresGenetiques;
import sopra.formation.model.Population;
import sopra.formation.repository.IParametresGenetiquesRepository;

public class ParametresGenetiquesRepositoryJpa implements IParametresGenetiquesRepository {

///////////////////////////////////// CRUD ////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<ParametresGenetiques> findAll() {
		List<ParametresGenetiques> parametresGenetiques = new ArrayList<ParametresGenetiques>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<ParametresGenetiques> query = em.createQuery("select pG from ParametresGenetiques pG", ParametresGenetiques.class);

			parametresGenetiques = query.getResultList();

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

		return parametresGenetiques;
	}

	@Override
	public ParametresGenetiques findById(Long id) {
		ParametresGenetiques parametresGenetiques = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			parametresGenetiques = em.find(ParametresGenetiques.class, id);

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

		return parametresGenetiques;
	}

	@Override
	public ParametresGenetiques save(ParametresGenetiques obj) {
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
	public void delete(ParametresGenetiques obj) {
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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	

}
