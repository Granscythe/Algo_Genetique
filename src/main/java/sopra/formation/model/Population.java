package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
	
	@ManyToMany
	@JoinTable(name = "popCreature", joinColumns = @JoinColumn(name = "generation_id"), inverseJoinColumns = @JoinColumn(name = "creature_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"generation_id", "creature_id" }))
	private List<Creature> populationCreatures = new ArrayList<Creature>();
	
	@OneToOne
	@JoinColumn(name="parametres_id")
	private ParametresGenetiques parametres;
	
	@ManyToOne
	@JoinColumn(name="historique_id")
	private Historique historiques;
	
	@ManyToOne
	@JoinColumn(name="simulation_id")
	private Simulation simulation;
	
	@OneToOne
	@JoinColumn(name="environnement")
	private Environnement environnement; 
	
	
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

public List<Creature> getPopulationCreatures() {
	return populationCreatures;
}

public void setPopulationCreatures(List<Creature> populationCreatures) {
	this.populationCreatures = populationCreatures;
}

public ParametresGenetiques getParametres() {
	return parametres;
}

public void setParametres(ParametresGenetiques parametres) {
	this.parametres = parametres;
}

public Historique getHistoriques() {
	return historiques;
}

public void setHistoriques(Historique historiques) {
	this.historiques = historiques;
}

public Simulation getSimulation() {
	return simulation;
}

public void setSimulation(Simulation simulation) {
	this.simulation = simulation;
}

public Environnement getEnvironnement() {
	return environnement;
}

public void setEnvironnement(Environnement environnement) {
	this.environnement = environnement;
}





 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
}
