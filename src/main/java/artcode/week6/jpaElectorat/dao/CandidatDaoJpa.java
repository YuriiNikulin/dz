package artcode.week6.jpaElectorat.dao;

import artcode.week6.jpaElectorat.model.Candidate;
import artcode.week6.jpaElectorat.model.Region;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public interface CandidatDaoJpa {


    List<Candidate> getByAge(int lowAge, int hightAge, int maxRes);

    List<Candidate> getByRegion(String region);

    List<Region> maxPopulation();
}
