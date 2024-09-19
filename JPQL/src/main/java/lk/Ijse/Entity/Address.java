package lk.ijse.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
    @Id
    private int aid;
    private String city;
    private String country;

    @ManyToOne
    private Student customer;

    public Address() {
    }

    public Address(int aid, String city, String country, Student customer) {
        this.aid = aid;
        this.city = city;
        this.country = country;
        this.customer = customer;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getCustomer() {
        return customer;
    }

    public void setCustomer(Student customer) {
        this.customer = customer;
    }
}
