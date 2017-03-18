package artcode.spring_aop.service;

import artcode.spring_aop.model.Candidate_spring_aop;
import artcode.spring_aop.model.Region_spring_aop;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public interface IService {

    List<Candidate_spring_aop> getCandidateByRegion(String region);

    List<Candidate_spring_aop> getCandidatesByAge(int startAge, int endAge, int maxSizeRes);

    List<Region_spring_aop> getRegionsWithMaxPopulation();

}

