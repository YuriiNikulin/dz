package artcode.week6.jpaElectorat.testJpa;

import artcode.week6.jpaElectorat.model.Candidate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by yurii on 04.03.17.
 */
public class TestDell {
    /*public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        Candidate_spring_aop candidate = new Candidate_spring_aop("Vasya", 1, 1, 30);


        manager.getTransaction().begin();

        Candidate_spring_aop c = manager.find(Candidate_spring_aop.class, 4);
        manager.remove(c);

        manager.getTransaction().commit();
    }*/
}
