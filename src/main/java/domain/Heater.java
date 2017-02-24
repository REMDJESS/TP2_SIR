package domain;

import javax.persistence.Entity;


/**
 *
 * @author ANANI
 */
@Entity
public class Heater extends SmartDevice {

    private Home home;

    public Heater() {
    }

    public Heater(String name) {
        super(name);
    }


    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
