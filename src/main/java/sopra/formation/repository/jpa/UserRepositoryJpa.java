package sopra.formation.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.formation.app.Application;
import sopra.formation.model.Environnement;
import sopra.formation.model.Simulation;
import sopra.formation.model.User;
import sopra.formation.repository.IUserRepository;

public class UserRepositoryJpa implements IUserRepository {

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEntityManagerFactory().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<User> query = em.createQuery("select u from User u", User.class);

			users = query.getResultList();

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

		return users;
	}

	@Override
	public User findById(Integer id) {
		User  users = null;

			EntityManager em = null;
			EntityTransaction tx = null;

			try {
				em = Application.getInstance().getEntityManagerFactory().createEntityManager();
				tx = em.getTransaction();
				tx.begin();

				users = em.find( User.class, id);

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

			return users;
		}

	@Override
	public User save(User obj) {
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
	public void delete(User obj) {
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
