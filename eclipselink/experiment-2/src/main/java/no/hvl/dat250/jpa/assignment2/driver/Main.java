package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select p from Person p");
        List<Person> todoList = q.getResultList();
        for (Person todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        Set<Person> persons = new HashSet<>();
        Set<Address> addresses = new HashSet<>();
        Set<CreditCard> cards = new HashSet<>();

        em.getTransaction().begin();
        Person person = new Person();
        Address address = new Address();
        CreditCard card1 = new CreditCard();
        CreditCard card2 = new CreditCard();
        Pincode pin = new Pincode();
        Bank bank = new Bank();

        person.setName("Max Mustermann");
        persons.add(person);

        address.setStreet("Inndalsveien");
        address.setNumber(28);
        addresses.add(address);

        card1.setBalance(-5000);
        card1.setLimit(-10000);
        card1.setNumber(12345);
        card1.setBank(bank);
        card1.setPincode(pin);
        cards.add(card1);

        card2.setBalance(1);
        card2.setLimit(2000);
        card2.setNumber(123);
        card2.setBank(bank);
        card2.setPincode(pin);
        cards.add(card2);

        bank.setName("Pengebank");
        bank.setOwnedCards(cards);

        pin.setCount(1);
        pin.setPincode("123");

        person.setAddresses(addresses);
        person.setCreditCards(cards);

        address.setOwners(persons);

        em.persist(person);
        em.persist(address);
        em.persist(bank);
        em.persist(card1);
        em.persist(card2);
        em.persist(pin);


        em.getTransaction().commit();

        em.close();
        factory.close();

    }
}
