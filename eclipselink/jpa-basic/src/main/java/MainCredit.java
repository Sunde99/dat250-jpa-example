import creditcard.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainCredit {
    private static final String PERSISTENCE_UNIT_NAME = "creditcard";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Person t");
        List<Person> personList = q.getResultList();
        for (Person per : personList) {
            System.out.println(per);
        }
        System.out.println("Size: " + personList.size());

        setupObjectWorld(em);

        em.close();
    }

    public static void setupObjectWorld(EntityManager em) {
        em.getTransaction().begin();
        // create new person
        Person person = new Person();
        person.setName("Tim Allen");
        em.persist(person);

        Address address = new Address("Elf Road, North Pole", 123);
        ArrayList<Person> listOfPeople = new ArrayList<>();
        listOfPeople.add(person);
        address.setOccupant(listOfPeople);
        em.persist(person);
        em.persist(address);

        ArrayList<Address> listOfAddresses = new ArrayList<>();
        listOfAddresses.add(address);
        person.setAddresses(listOfAddresses);
        em.persist(address);
        em.persist(person);

        Creditcard creditCard1 = new Creditcard();
        creditCard1.setNumber(62442);
        creditCard1.setBalance(13);
        creditCard1.setLimit(123213);
        em.persist(creditCard1);

        Creditcard creditcard2 = new Creditcard();
        creditcard2.setNumber(40000);
        creditcard2.setBalance(250);
        creditcard2.setLimit(0);
        em.persist(creditcard2);

        Pincode pincode = new Pincode();
        pincode.setCode("123");
        pincode.setCount(1);

        creditCard1.setCode(pincode);
        creditcard2.setCode(pincode);
        em.persist(pincode);
        em.persist(creditCard1);
        em.persist(creditcard2);

        ArrayList<Creditcard> listOfCreditCards = new ArrayList<>();
        listOfCreditCards.add(creditCard1);
        listOfCreditCards.add(creditcard2);
        person.setCards(listOfCreditCards);
        em.persist(person);

        Bank bank = new Bank();
        bank.name = "Pengebank";
        bank.setCards(listOfCreditCards);
        creditCard1.setBank(bank);
        creditcard2.setBank(bank);
        em.persist(bank);
        em.persist(creditCard1);
        em.persist(creditcard2);

        em.getTransaction().commit();
    }
}
