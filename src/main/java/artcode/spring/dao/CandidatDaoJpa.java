package artcode.spring.dao;

import artcode.spring.model.Candidate;
import artcode.spring.model.Region;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public interface CandidatDaoJpa {


    List<Candidate> getByAge(int lowAge, int hightAge, int maxRes);

    List<Candidate> getByRegion(String region);

    List<Region> maxPopulation();
}
