package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.ElectronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

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
            test.createPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }
		test.listPerson();
	
		tx.commit();
		
		
		manager.close();
		System.out.println("done");
		
	}
	private void createPerson() {
        int numOfPerson = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
        if (numOfPerson == 0) {
            Home home = new Home("beaulieu", 500, 3);
            manager.persist(home);
            
//            ElectronicDevice electronicDevice = new ElectronicDevice( 500);
//            manager.persist(electronicDevice);
            
            Heater heater = new Heater( 500, 30000);
            manager.persist(heater);

            manager.persist(new  Person("anani", "raymond", "ankor@gmail.com",home));
            manager.persist(new Person("Vasquez","Antonio","antonio@gmail.com",home));

        }
    }

    private void listPerson() {
        List<Person> resultList = manager.createQuery("Select a From Employee a", Person.class).getResultList();
        System.out.println("num of employess:" + resultList.size());
        for (Person next : resultList) {
            System.out.println("next employee: " + next);
        }
    }


	


}
