package artcode.week5_d2.app.test;

import artcode.week5_d2.app.dao.CandidateDao;
import artcode.week5_d2.app.dao.CandidateDaoImpl;
import artcode.week5_d2.app.model.Candidate;
import artcode.week5_d2.app.model.Region;
import artcode.week5_d2.app.service.MainService;
import artcode.week5_d2.app.service.MainServiceImpl;
import artcode.week5_d2.app.utils.ConnectionFactory;
import artcode.week5_d2.app.utils.PropertiesHolder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * Created by yurii on 28.02.17.
 */
public class TestApp {

    public static void main(String[] args) throws SQLException {
        List<Candidate> candidateList;
        List<Candidate> candidateListByRegion;
        List<Region> regionList;

        ConnectionFactory.getConnection();
        CandidateDao candidateDao = new CandidateDaoImpl();

        MainService mainService = new MainServiceImpl(candidateDao);

        candidateList = mainService.getCandidatesByAge(30, 40);

        candidateListByRegion = mainService.getCandidateByRegion("Kiev");

        regionList = mainService.getRegionsWithMaxPopulation();


        System.out.println("candidateListByAge");
        for (Candidate candidate : candidateList) {
            System.out.println(candidate.toString());
        }

        System.out.println("candidateListByRegion");
        for (Candidate candidate : candidateListByRegion) {
            System.out.println(candidate.toString());
        }

        System.out.println("max population");
        for (Region region : regionList) {
            System.out.println(region.toString());
        }

    }
}
