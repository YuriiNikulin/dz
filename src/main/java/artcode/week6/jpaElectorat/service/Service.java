package artcode.week6.jpaElectorat.service;



import artcode.week6.jpaElectorat.dao.CandidatDaoJpaImpl;
import artcode.week6.jpaElectorat.model.Candidate;
import artcode.week6.jpaElectorat.model.Region;

import java.util.List;

/**
 * Created by yurii on 05.03.17.
 */
public class Service implements IService{

    CandidatDaoJpaImpl candidatDao;

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
