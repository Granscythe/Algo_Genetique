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
@Table(name = "ParametresGenetiques")
public class ParametresGenetiques {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column
	private int tauxMutation;
	@Enumerated(EnumType.STRING)
	private TransmissionGene gene;
	@Enumerated(EnumType.STRING)
	private TypeMutation mutation;
	

/////////////////Constructor vide///////////////////////////
	
	public ParametresGenetiques() {
		super();
	}
	
////////////////Constructor//////////////////////////////////
	
	public ParametresGenetiques(int tauxMutation) {
		this.tauxMutation=tauxMutation;
	}

///////////////////////////////////////GETTER SETTER//////////////////////////////////////////
	
	public Long getId() {return id;	}

	public void setId(Long id) {this.id = id;}

	public int getVersion() {return version;}

	public void setVersion(int version) {this.version = version;}

	public int getTauxMutation() {return tauxMutation;}

	public void setTauxMutation(int tauxMutation) {	this.tauxMutation = tauxMutation;}

	public TransmissionGene getGene() {	return gene;}

	public void setGene(TransmissionGene gene) {this.gene = gene;}

	public TypeMutation getMutation() {	return mutation;}

	public void setMutation(TypeMutation mutation) {this.mutation = mutation;}
	

/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
}
