package artcode.spring.service;

import artcode.spring.model.Candidate;
import artcode.spring.model.Region;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public interface IService {

    List<Candidate> getCandidateByRegion(String region);

    List<Candidate> getCandidatesByAge(int startAge, int endAge, int maxSizeRes);

    List<Region> getRegionsWithMaxPopulation();

}

