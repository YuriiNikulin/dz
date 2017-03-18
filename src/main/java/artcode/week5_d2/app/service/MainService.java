package artcode.week5_d2.app.service;

import artcode.week5_d2.app.exeption.NoRegionFoundExeption;
import artcode.week5_d2.app.model.Candidate;
import artcode.week5_d2.app.model.Region;

import java.util.List;

/**
 * Created by yurii on 28.02.17.
 */
public interface MainService {

    List<Candidate> getCandidateByRegion(String region);

    List<Candidate> getCandidatesByAge(int startAge, int endAge);

    List<Region> getRegionsWithMaxPopulation();

}
