package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue
	long id;
	@Column(name = "nom", length = 75)
	String nom;
	@Column(name = "prenom", length = 150)
	String prenom;

	String email;
	//@OneToMany
	Home home;
	///@ManyToMany
	//List<Person> friends;

	public Person() {

	}

	public Person(String nom, String prenom, String email, Home home) {
		this.nom = nom;
		this.prenom = prenom;
		this.home = home;
		//this.friends = new ArrayList<Person>();
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	/**
	 * @return the friends
	 */
	/*public List<Person> getFriends() {
		return friends;
	}

	*//**
	 * @param friends
	 *            the friends to set
	 *//*
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}*/

	@Override
	public String toString() {
		return "Person [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", department="
                + home.getNameHome() + "]";
	}

}
