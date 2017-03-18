package artcode.week6.jpaElectorat.testJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by yurii on 04.03.17.
 */
public class TestJPQL {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        Query query =
                manager.createQuery("SELECT u FROM Candidate_spring_aop u WHERE u.name = :inName");

        List list =
                query.setParameter("inName", "Vasya")
                        .setFirstResult(1)
                        .setMaxResults(3)
                        .getResultList();

        list.stream().forEach(System.out::println);
    }
}
