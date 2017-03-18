package artcode.week5_d2.app.service;

import artcode.week5_d2.app.dao.CandidateDao;
import artcode.week5_d2.app.exeption.NoRegionFoundExeption;
import artcode.week5_d2.app.model.Candidate;
import artcode.week5_d2.app.model.Region;

import java.util.List;

/**
 * Created by serhii on 26.02.17.
 */
public class MainServiceImpl implements MainService {

    private CandidateDao candidateDao;

    public MainServiceImpl(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public List<Candidate> getCandidateByRegion(String region) {
        return candidateDao.getByRegion(region);
    }

    @Override
    public List<Candidate> getCandidatesByAge(int startAge, int endAge) {
        // validation, preprocess, Logger
        return candidateDao.getByAge(startAge, endAge);
    }

    @Override
    public List<Region> getRegionsWithMaxPopulation() {
        return candidateDao.maxPopulation();
    }


}
