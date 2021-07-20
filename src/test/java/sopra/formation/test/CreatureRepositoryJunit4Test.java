package sopra.formation.test;

import java.util.Optional;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import antlr.collections.List;
import sopra.formation.config.ConfigJava;
import sopra.formation.model.Creature;

import sopra.formation.repository.ICreatureRepository;



public class CreatureRepositoryJunit4Test {
	private static ClassPathXmlApplicationContext context;
	private static ICreatureRepository creatureRepo;
	
	@BeforeClass
	public static void start() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigJava.class);
		creatureRepo = context.getBean(ICreatureRepository.class);
	}

	@AfterClass
	public static void end() {
		context.close();
	}

	@Test
	public void createAndFindById() {
		System.out.println("testCreate Début ###################");
		
		Creature paul = new Creature(5,4,3);

		paul = creatureRepo.save(paul);
		
		Creature paulFind = creatureRepo.findById(paul.getId()).get();
		
		Assert.assertEquals(5, paulFind.getVitesse());
		
		Assert.assertEquals(4, paulFind.getVision());
		
		System.out.println("testCreate Fin ###################");
	}
	
	@Test
	public void modify() {
		System.out.println("testModify Début ###################");
		
		Creature paul = new Creature(5,4,3);

		paul = creatureRepo.save(paul);
		
		Creature paulFind = creatureRepo.findById(paul.getId()).get();
		
		
		paulFind.setVitesse(1);
		paulFind.setVision(1);
		paulFind.setEndurance(1);
		
		paulFind = creatureRepo.save(paulFind);
		
		paulFind = creatureRepo.findById(paulFind.getId()).get();
		
		Assert.assertEquals(1, paulFind.getVitesse());
		Assert.assertEquals ( 1, paulFind.getVision());
		Assert.assertEquals(1, paulFind.getEndurance());
		
		System.out.println("testModify Fin ###################");
	}
	@Test
	public void delete() {
		System.out.println("testDelete Début ###################");
		
		Creature paul = new Creature(3, 2, 2);

		paul = creatureRepo.save(paul);
		
		Creature paulFind = creatureRepo.findById(paul.getId()).get();
		
		creatureRepo.delete(paulFind);
		
		paulFind = creatureRepo.findById(paulFind.getId()).get();
		if(paulFind != null) {
			Assert.fail("La suppression de la matière a échouée");
		}
		
		
		Assert.assertNull(paulFind);
		System.out.println("testDelete Fin ###################");
}
	@Test
	public void findAll() {
		System.out.println("testFindAll Début ###################");
		
		int sizeStart = creatureRepo.findAll().size();
		
		Creature paul = new Creature(3, 2, 2);

		paul = creatureRepo.save(paul);
		
		Creature lea = new Creature(1, 1, 2);

		lea = creatureRepo.save(lea);
		
		int sizeEnd = creatureRepo.findAll().size();
		
		Assert.assertEquals(2, sizeEnd - sizeStart);
		
		System.out.println("testFindAll Fin ###################");
	}
	

}