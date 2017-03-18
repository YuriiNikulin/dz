package artcode.week6.jpaElectorat.service;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public interface IService {

    List<artcode.week6.jpaElectorat.model.Candidate> getCandidateByRegion(String region);

    List<artcode.week6.jpaElectorat.model.Candidate> getCandidatesByAge(int startAge, int endAge, int maxSizeRes);

    List<artcode.week6.jpaElectorat.model.Region> getRegionsWithMaxPopulation();

}

