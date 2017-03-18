package artcode.spring.service;


import artcode.spring.dao.CandidatDaoJpaImpl;
import artcode.spring.model.Candidate;
import artcode.spring.model.Region;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public class Service implements IService {

    CandidatDaoJpaImpl candidatDao;

    public Service() {
    }

    public Service(CandidatDaoJpaImpl candidatDao) {
        this.candidatDao = candidatDao;
    }

    @Override
    public List<Candidate> getCandidatesByAge(int startAge, int endAge, int maxSizeRes) {
        return candidatDao.getByAge(startAge,endAge,maxSizeRes);
    }

    @Override
    public List<Candidate> getCandidateByRegion(String region) {
        return candidatDao.getByRegion(region);
    }

    @Override
    public List<Region> getRegionsWithMaxPopulation() {
        return candidatDao.maxPopulation();
    }
}
