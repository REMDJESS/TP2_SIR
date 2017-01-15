package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {

	@Id
	@GeneratedValue
	long id;

	int taille;

	String nameHome;

	int nbrePiece;

	List<Person> person = new ArrayList<Person>();
	
	
	List<Heater> heater = new ArrayList<Heater>();

	// @OneToMany(mappedBy="home", cascade={CascadeType.REMOVE,
	// CascadeType.REFRESH})
	// List<Heater> heater;

	//List<ElectronicDevice> EquipementElectroniques = new ArrayList<ElectronicDevice>();

	// @ManyToOne(mappedBy ="person", cascade={ CascadeType.REMOVE,
	// CascadeType.REFRESH})
	// Person person;
	public Home() {
		super();

	}

	public Home( String nameHome, int taille, int nbrePiece) {
		this.nameHome= nameHome;
		this.taille = taille;
		this.nbrePiece = nbrePiece;
		
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public long getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getNameHome() {
		return nameHome;
	}

	public void setNameHome(String nameHome) {
		this.nameHome = nameHome;
	}

	public int getNbrePiece() {
		return nbrePiece;
	}

	public void setNbrePiece(int nbrePiece) {
		this.nbrePiece = nbrePiece;
	}

	@OneToMany(mappedBy = "home", cascade = { CascadeType.PERSIST })
	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}
	@OneToMany(mappedBy = "home", cascade = { CascadeType.PERSIST })
	public List<Heater> getHeater() {
		return heater;
	}

	public void setHeater(List<Heater> heater) {
		this.heater = heater;
	}


//	@OneToMany(mappedBy = "home", cascade = { CascadeType.PERSIST })
//	public List<ElectronicDevice> getEquipementElectroniques() {
//		return EquipementElectroniques;
//	}
//
//	public void setEquipementElectroniques(List<ElectronicDevice> equipementElectroniques) {
//		EquipementElectroniques = equipementElectroniques;
//	}

}
