package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Address.class, mappedBy="owners")
    private Set<Address> addresses;
    @OneToMany(cascade = {CascadeType.PERSIST})
    private Set<CreditCard> creditCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Person() {}
    public String getName() {
        return name;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
