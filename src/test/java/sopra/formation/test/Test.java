package sopra.formation.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sopra.formation.config.ConfigJava;




public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigJava.class);


		
		
		
		
		
		
		context.close();

	}

}
