package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Creature;

public interface ICreatureRepository extends JpaRepository<Creature, Long> {

	Creature findById(Integer id);
	List<Creature> findByVitesse(Integer vitesse);
	List<Creature> findByVision(Integer vision);
	List<Creature> findByTaille(Integer taille);
	List<Creature> findByEndurance(Integer endurance);
	List<Creature> findByBesoinNourriture(Integer besoinNourriture);
	List<Creature> findByPosX(Integer posX);
	List<Creature> findByPosY(Integer posY);
	List<Creature> findByEstomac(Integer estomac);
	List<Creature> findByStatut(Boolean statut);
	
//	@Query("Select e.id from Creature c join c.parent.pere p where c=:id")
//	List<Creature> findAllByPere(@Param("id") Creature creature);
	
//	@Query("Select e from Creature c join c.parent.mere p where c=:id")
//	List<Creature> findAllByMere(@Param("id") Creature creature);
	
}
