package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Population")
public class Population {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long generation;
	@Version
	private int version;
	@Column
	private int limiteVitesse;
	@Column
	private int limiteVision;
	@Column 
	private int limiteTaille;
	@Enumerated(EnumType.STRING)
	private TypePopulation type;
	
	
////////////////Constructeur Vide/////////////////////
	
 public Population(){
	 super();
 }

//////////////////Constructeur//////////////////////////
 
 public Population(int limiteVitesse, int limiteVision, int limiteTaille) {
	 this.limiteVitesse=limiteVitesse;
	 this.limiteVision=limiteVision;
	 this.limiteTaille=limiteTaille;
 }

 ////////////////////////////////GETTER/SETTER/////////////////////////////////////////////////////////////////////////////
 
public Long getGeneration() {return generation;}

public void setGeneration(Long generation) {this.generation = generation;}

public int getVersion() {return version;}

public void setVersion(int version) { this.version = version;}

public int getLimiteVitesse() {return limiteVitesse;}

public void setLimiteVitesse(int limiteVitesse) {this.limiteVitesse = limiteVitesse;}

public int getLimiteVision() {return limiteVision;}

public void setLimiteVision(int limiteVision) {this.limiteVision = limiteVision;}

public int getLimiteTaille() {return limiteTaille;}

public void setLimiteTaille(int limiteTaille) {
	this.limiteTaille = limiteTaille;
}

public TypePopulation getType() {return type;}

public void setType(TypePopulation type) {this.type = type;}

 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
}
