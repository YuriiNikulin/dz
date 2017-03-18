package artcode.spring_aop.dao;

import artcode.spring_aop.model.Candidate_spring_aop;
import artcode.spring_aop.model.Region_spring_aop;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public interface ICandidatDao {


    List<Candidate_spring_aop> getByAge(int lowAge, int hightAge, int maxRes);

    List<Candidate_spring_aop> getByRegion(String region);

    List<Region_spring_aop> maxPopulation();
}
