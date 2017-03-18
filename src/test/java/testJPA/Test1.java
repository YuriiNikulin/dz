package testJPA;

import artcode.week6.jpaElectorat.dao.CandidatDaoJpaImpl;
import artcode.week6.jpaElectorat.model.Candidate;
import artcode.week6.jpaElectorat.model.Clan;
import artcode.week6.jpaElectorat.model.Region;
import artcode.week6.jpaElectorat.service.IService;
import artcode.week6.jpaElectorat.service.Service;
import artcode.week6.jpaElectorat.utils.MyConection;
import artcode.week6.jpaElectorat.utils.MyDB;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.ValidationMode;
import java.util.List;
import java.util.UUID;

/**
 * Created by yurii on 05.03.17.
 */
public class Test1 {

    @Test
    public void test1() {

        IService service = new Service(new CandidatDaoJpaImpl());

        List<Candidate> candidates = service.getCandidatesByAge(30, 60, 10);

        Assert.assertTrue(candidates.size() != 0);

    }

    @Test
    public void testByRegion() {

        IService service = new Service(new CandidatDaoJpaImpl());

        List<Candidate> candidates = service.getCandidateByRegion("0-region");

        Assert.assertTrue(candidates.size() != 0);
    }

    @Test
    public void testMaxPopulation() {

        IService service = new Service(new CandidatDaoJpaImpl());

        List<Region> regions = service.getRegionsWithMaxPopulation();

        Assert.assertTrue(regions.size() != 0);

    }

    @Before
    public void beforeTests(){
        //MyDB.generateDB(5);
    }
}
