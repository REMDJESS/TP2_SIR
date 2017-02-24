package domain;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author ANANI
 */
@Entity
public class Home {

    private long id;
    private String nomHome;
    private Person person;
    
   
    private List<Heater> heaters;

    // constructeur
    public Home(String nomHome, List<Heater> heaters) {
        this.nomHome = nomHome;
        this.heaters = heaters;
        initHeaters();
    }

    private void initHeaters() {
        if (heaters != null)
            for (Heater heater : heaters) {
                heater.setHome(this);
            }
    }

    public Home() {
    }

    // les getters et setters
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNomHome() {
        return nomHome;
    }

    public void setNomHome(String nomHome) {
        this.nomHome = nomHome;
    }

    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
