package artcode.spring_aop.dao;

import artcode.spring_aop.model.Candidate_spring_aop;
import artcode.spring_aop.model.Region_spring_aop;
import artcode.spring_aop.utils.MyConection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Component
public class CandidatDao implements ICandidatDao {

    //@Autowired
    private MyConection myConection;

    EntityManager manager  = myConection.getEntityManager();

    public CandidatDao() {
    }

    @Override
    public List<Candidate_spring_aop> getByAge(int lowAge, int hightAge, int maxRes) {

        String jpql = "SELECT c FROM Candidate_spring_aop c WHERE c.age BETWEEN :lowAge and :hightAge";
        Query query = manager.createQuery(jpql);

        List list =
                query.setParameter("hightAge", hightAge)
                        .setParameter("lowAge", lowAge)
                        .setMaxResults(maxRes)
                        .getResultList();

        return list;
    }

    @Override
    public List<Candidate_spring_aop> getByRegion(String region) {

        String jpql = "SELECT c FROM Candidate_spring_aop c JOIN c.region r " +
                "WHERE r.name = :region";

        Query query = manager.createQuery(jpql);

        List<Candidate_spring_aop> list = query.setParameter("region", region)
                .setMaxResults(5).getResultList();


        return list;
    }

    @Override
    public List<Region_spring_aop> maxPopulation() {

        String jpql = "SELECT r FROM Region_spring_aop r WHERE population = (SELECT max(r.population) FROM r)";

        Query query = manager.createQuery(jpql);

        List<Region_spring_aop> list = query.getResultList();

        return list;
    }
}
