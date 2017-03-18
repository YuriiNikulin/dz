package artcode.week5_d2.app.dao;

/**
 * Created by yurii on 28.02.17.
 */

import artcode.week5_d2.app.model.Candidate;

import java.util.List;

/**
 * crud - create, read, update, delete + specific methods
 */
public interface CandidateDao extends Dao<Candidate,Integer> {

    List<Candidate> getByAge(int lowAge, int hightAge);

    List<Candidate> getByRegion(String region);

    List<artcode.week5_d2.app.model.Region> maxPopulation();

}
