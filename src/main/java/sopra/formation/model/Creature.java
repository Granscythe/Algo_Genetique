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
@Table(name = "Creature")
public class Creature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column
	private int vitesse;
	@Column
	private int vision;
	@Column
	private int taille;
	@Column
	private int endurance;
	@Column
	private int besoinNourriture;
	
	@Column
	private int estomac;
	@Column
	private int posX;
	@Column
	private int posY;
	
	@Column
	private boolean statut;
	@Column
	private Creature pere;
	@Column 
	private Creature mere;
	@Column
	private int generationMort;
	
/////Constructor vide////////////////////////
	
	public Creature() {
		super();
	}

////////Constructor///////////////////////////////
	
	public Creature(int vitesse, int vision, int taille, int endurance, int besoinNourriture) {
		this.vitesse=vitesse;
		this.vision=vision;
		this.taille=taille;
		this.endurance=endurance;
		this.besoinNourriture=besoinNourriture;
	}
	
	public Creature(int vitesse, int vision, int taille) {
		this.vitesse=vitesse;
		this.vision=vision;
		this.taille=taille;
		this.endurance=endurance;
		this.besoinNourriture=besoinNourriture;
	}

//////////////////////////////GETTER SETTER//////////////////////////////////////////////////////////////////////////////////
	
	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}

	public int getVersion() {return version;}

	public void setVersion(int version) {this.version = version;}

	public int getVitesse() {return vitesse;}

	public void setVitesse(int vitesse) {this.vitesse = vitesse;}

	public int getVision() {return vision;}

	public void setVision(int vision) {	this.vision = vision;}

	public int getTaille() {return taille;}

	public void setTaille(int taille) {	this.taille = taille;}

	public int getEndurance() {	return endurance;}

	public void setEndurance(int endurance) {this.endurance = endurance;}

	public int getBesoinNourriture() {return besoinNourriture;}

	public void setBesoinNourriture(int besoinNourriture) {	this.besoinNourriture = besoinNourriture;}

	public int getEstomac() {return estomac;}

	public void setEstomac(int estomac) {this.estomac = estomac;}

	public int getPosX() {return posX;}

	public void setPosX(int posX) {	this.posX = posX;}

	public int getPosY() {return posY;}

	public void setPosY(int posY) {	this.posY = posY;}

	public boolean isStatut() {	return statut;}

	public void setStatut(boolean statut) {	this.statut = statut;}

	public Creature getPere() {	return pere;}

	public void setPere(Creature pere) {this.pere = pere;}

	public Creature getMere() {	return mere;}

	public void setMere(Creature mere) {this.mere = mere;}

	public int getGenerationMort() {return generationMort;}

	public void setGenerationMort(int generationMort) {	this.generationMort = generationMort;}	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
}
