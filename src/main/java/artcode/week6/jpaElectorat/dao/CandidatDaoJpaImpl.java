package artcode.week6.jpaElectorat.dao;

import artcode.week6.jpaElectorat.model.Candidate;
import artcode.week6.jpaElectorat.model.Region;
import artcode.week6.jpaElectorat.utils.MyConection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public class CandidatDaoJpaImpl implements CandidatDaoJpa{


    @Override
    public List<Candidate> getByAge(int lowAge, int hightAge, int maxRes) {

        String jpql = "SELECT c FROM Candidate_spring_aop c WHERE c.age BETWEEN :lowAge and :hightAge";
        EntityManager manager = MyConection.getEntityManager();
        Query query = manager.createQuery(jpql);

        List list =
                query.setParameter("hightAge", hightAge)
                        .setParameter("lowAge", lowAge)
                        .setMaxResults(maxRes)
                        .getResultList();

        return list;
    }

    @Override
    public List<Candidate> getByRegion(String region) {

        String jpql = "SELECT c FROM Candidate_spring_aop c JOIN c.region r " +
                "WHERE r.name = :region";

        EntityManager manager = MyConection.getEntityManager();
        Query query = manager.createQuery(jpql);

        List<Candidate> list = query.setParameter("region", region)
                .setMaxResults(5).getResultList();


        return list;
    }

    @Override
    public List<Region> maxPopulation() {

        String jpql = "SELECT r FROM Region_spring_aop r WHERE population = (SELECT max(r.population) FROM r)";

        EntityManager manager = MyConection.getEntityManager();
        Query query = manager.createQuery(jpql);

        List<Region> list = query.getResultList();

        return list;
    }
}
