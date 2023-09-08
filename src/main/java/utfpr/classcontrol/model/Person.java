package utfpr.classcontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name = "document")
    private String cpf;
    private int age;
    private String contact;
    private String city;
    private String street;
    private int number;
    @Enumerated(EnumType.STRING)
    private Job job;

    // GET SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(int index) {
        switch (index) {
            case 1:
                job = Job.DOCTOR;
                break;
            case 2:
                job = Job.TEACHER;
                break;
            case 3:
                job = Job.DEVELOPER;
                break;
        }
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15d %-15s %-15s %-15s %-15d %-15s %-15s%n", getName(), getAge(), getCpf(), getCity(), getStreet(), getNumber(), getContact(), getJob());
    }
}
