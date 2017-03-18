package artcode.spring_aop.service;


import artcode.spring_aop.dao.CandidatDao;
import artcode.spring_aop.model.Candidate_spring_aop;
import artcode.spring_aop.model.Region_spring_aop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Service implements IService {

    @Autowired
    CandidatDao candidatDao;

    public Service() {
    }

    public Service(CandidatDao candidatDao) {
        this.candidatDao = candidatDao;
    }

    @Override
    public List<Candidate_spring_aop> getCandidatesByAge(int startAge, int endAge, int maxSizeRes) {
        return candidatDao.getByAge(startAge,endAge,maxSizeRes);
    }

    @Override
    public List<Candidate_spring_aop> getCandidateByRegion(String region) {
        return candidatDao.getByRegion(region);
    }

    @Override
    public List<Region_spring_aop> getRegionsWithMaxPopulation() {
        return candidatDao.maxPopulation();
    }
}
