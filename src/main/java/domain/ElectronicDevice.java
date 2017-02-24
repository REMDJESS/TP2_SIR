package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


/**
 *
 * @author ANANI
 */
@Entity
public class ElectronicDevice extends SmartDevice {

    private double consommation;
    private Person person;


    public ElectronicDevice() {

    }

    public ElectronicDevice(String name, double consommation) {
        super(name);
        this.consommation = consommation;
    }

    public double getConsommation() {
        return consommation;
    }

    public void setConsommation(double consommation) {
        this.consommation = consommation;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}


