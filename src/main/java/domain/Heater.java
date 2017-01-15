package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Heater {
	@Id
	@GeneratedValue
	long id;
	
	double puissance;
	double consommationHeater;
	
	//@ManyToOne
	Home home;
	
	public Heater(){
		
	}
	public Heater( double puissance, double consommationHeater){
		this.puissance = puissance;	
		this.consommationHeater = consommationHeater;
	}

	/**
	 * @return the puissance
	 */
	public double getPuissance() {
		return puissance;
	}

	/**
	 * @param puissance the puissance to set
	 */
	public void setPuissance(double puissance) {
		this.puissance = puissance;
	}

	public double getConsommationHeater() {
		return consommationHeater;
	}
	public void setConsommationHeater(double consommationHeater) {
		this.consommationHeater = consommationHeater;
	}
	
	@ManyToOne
	public Home getHome() {
		return home;
	}

	
	public void setHome(Home home) {
		this.home = home;
	}
	@Override
	public String toString() {
		return "Heater [puissance =" + puissance + ", home="+ home.getNameHome() + "]";
	}

}
