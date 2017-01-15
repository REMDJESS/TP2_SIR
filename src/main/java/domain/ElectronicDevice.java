package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevice {

	@Id
	@GeneratedValue
	long id;
	
	double consommationMoyenne;
	
	//@ManyToOne
	//Home home;

	public ElectronicDevice(){
		
	}
	public ElectronicDevice(double consommationMoyenne){
		
		this.consommationMoyenne= consommationMoyenne;
		
	}
	/**
	 * @return the consommationMoyenne
	 */
	public double getConsommationMoyenne() {
		return consommationMoyenne;
	}

	/**
	 * @param consommationMoyenne the consommationMoyenne to set
	 */
	public void setConsommationMoyenne(double consommationMoyenne) {
		this.consommationMoyenne = consommationMoyenne;
	}

//	@ManyToOne
//	public Home getHome() {
//		return home;
//	}
//
//	public void setHome(Home home) {
//		this.home = home;
//	}
//
//	@Override
//	public String toString() {
//		return "ElectronicDevice [consommationMoyenne =" + consommationMoyenne + ", home="+ home.getNameHome() + "]";
//	}
}
