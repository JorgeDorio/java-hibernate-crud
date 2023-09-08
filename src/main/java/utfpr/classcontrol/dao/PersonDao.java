package utfpr.classcontrol.dao;

import utfpr.classcontrol.model.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonDao {
    private EntityManager em;

    public PersonDao(EntityManager em) {
        this.em = em;
    }

    public void connect() {
        em.getTransaction().begin();
    }

    public void end() {
        em.close();
    }

    public void save(Person p) {
        em.persist(p);
        em.getTransaction().commit();
    }

    public void remove(Person p) {
        p = em.merge(p);
        em.remove(p);
        em.getTransaction().commit();
    }

    public List<Person> getAll() {
        String query = "SELECT p FROM Person p";
        return em.createQuery(query, Person.class).getResultList();
    }

    public Person getByCpf(String cpf) {
        String query = "SELECT p FROM Person p WHERE p.cpf = :cpf";
        return em.createQuery(query, Person.class).setParameter("cpf", cpf).getSingleResult();
    }

    public Person getById(int id) {
        return em.find(Person.class, id);
    }

    public void update(Person p) {
        em.merge(p);
    }

    public void rollback() {
        em.getTransaction().rollback();
    }
}
