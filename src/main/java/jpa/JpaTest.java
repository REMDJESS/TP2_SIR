package jpa;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANANI
 */
public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createPersons(); // la méthode pour créer une personne
        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();
        test.affichePerson();
        test.afficherHome();
        manager.close();
        System.out.println("effectué");
    }

    private void createPersons() {

        List<Person> lesAmisAntonio = new ArrayList<Person>();
        List<Person> lesAmisAnani = new ArrayList<Person>();

        Person ami = new Person("Fuertes", "VASQUEZ", null, null, null);
        lesAmisAntonio.add(ami);
        lesAmisAnani.add(ami);
        initHomesPerson(ami);
        manager.persist(ami);

        ami = new Person("Raymond", "ANANI", null, null, lesAmisAnani);
        lesAmisAntonio.add(ami);
        initHomesPerson(ami);
        manager.persist(ami);


        Person antonio = new Person("Fuertes", "VASQUEZ", createHomes(), createElectronicDevices(), lesAmisAntonio);
        initElectronicDevicesPerson(antonio);
        initHomesPerson(antonio);
        manager.persist(antonio);

    }

    private List<Home> createHomes() {
        List<Heater> heaters = new ArrayList<Heater>();
        heaters.add(new Heater("heater_0012"));
        heaters.add(new Heater("heater_0012"));
        heaters.add(new Heater("heater_0013"));

        List<Home> homes = new ArrayList<Home>();
        homes.add(new Home("maison_001", heaters));

        heaters = new ArrayList<Heater>();
        heaters.add(new Heater("heater_0021"));
        heaters.add(new Heater("heater_0022"));
        heaters.add(new Heater("heater_0023"));

        homes.add(new Home("maison_002", heaters));
        initHeatersHome(homes);
        return homes;
    }

    private List<ElectronicDevice> createElectronicDevices() {
        List<ElectronicDevice> electronicDevices = new ArrayList<ElectronicDevice>();
        electronicDevices.add(new ElectronicDevice("device_001", 1000));
        electronicDevices.add(new ElectronicDevice("device_002", 1200));
        electronicDevices.add(new ElectronicDevice("device_003", 1500));
        return electronicDevices;
    }

    private void initHeatersHome(List<Home> homes) {
        for (Home home : homes)
            for (Heater heater : home.getHeaters())
                heater.setHome(home);

    }

    private void initElectronicDevicesPerson(Person person) {
        if(person.getElectronicDevices() != null)
            for (ElectronicDevice electronicDevice : person.getElectronicDevices())
                electronicDevice.setPerson(person);
    }

    private void initHomesPerson(Person person){
        if(person.getHomes() != null)
            for (Home home : person.getHomes())
                home.setPerson(person);
    }
    private void affichePerson() {
        List<Person> affichePerson = manager.createQuery("Select p From Person p", Person.class).getResultList();

        System.out.println("num of personnes:" + affichePerson.size());
        for (Person next : affichePerson) {
            System.out.println("next personne: " + next);
        }
    }

    private void afficherHome() {
        List<Home> afficheHome = manager.createQuery("Select h From Home h", Home.class).getResultList();

        System.out.println("nombre de maison:" + afficheHome.size());
        for (Home next : afficheHome) {
            System.out.println("next home: " + next.getNomHome());
        }
    }

}
