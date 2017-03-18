package artcode.week6.jpaElectorat.testJpa;


import artcode.week6.jpaElectorat.dao.CandidatDaoJpaImpl;
import artcode.week6.jpaElectorat.model.Candidate;
import artcode.week6.jpaElectorat.model.Region;
import artcode.week6.jpaElectorat.service.IService;
import artcode.week6.jpaElectorat.service.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by yurii on 04.03.17.
 */
public class Test {
   /* public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        Candidate_spring_aop candidate = new Candidate_spring_aop("Vasya", 1,1,30);


        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(candidate);
            transaction.commit();

            System.out.println("resalt");
            Candidate_spring_aop c = manager.find(Candidate_spring_aop.class,1);
            System.out.println(c);

        }catch (Exception e){
            transaction.rollback();
        }finally {
            manager.close();
            entityManagerFactory.close();
        }


    }*/


    public static void main(String[] args) {
        IService service = new Service(new CandidatDaoJpaImpl());

        List<Region> regions = service.getRegionsWithMaxPopulation();

        for (Region region : regions) {
            System.out.println(region.toString());
        }

    }
}
