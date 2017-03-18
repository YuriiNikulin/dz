package artcode.week5_d2.app.dao;

/**
 * Created by yurii on 28.02.17.
 */

import artcode.week5_d2.app.converter.CandidateConverter;
import artcode.week5_d2.app.converter.RegionConverter;
import artcode.week5_d2.app.model.Candidate;
import artcode.week5_d2.app.model.Region;
import artcode.week5_d2.app.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by serhii on 26.02.17.
 */
public class CandidateDaoImpl implements CandidateDao {


    @Override
    public Candidate create(Candidate entity) {
        return null;
    }

    @Override
    public List<Candidate> getAll(int offset, int length) {
        return null;
    }

    @Override
    public Candidate findOne(Integer integer) {
        return null;
    }

    @Override
    public Candidate delete(Integer integer) {
        return null;
    }

    @Override
    public List<Candidate> getByAge(int lowAge, int hightAge) {

        String sql = "SELECT id, name, age FROM candidates c WHERE c.age BETWEEN ? and ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, lowAge);
            preparedStatement.setInt(2, hightAge);

            ResultSet resultSet = preparedStatement.executeQuery();

            return CandidateConverter.from(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public List<Candidate> getByRegion(String region) {

        String sql = "SELECT candidates.id,candidates.name,candidates.age,regions.region_name " +
                "FROM candidates INNER JOIN regions ON candidates.region_id=regions.id " +
                "WHERE region_name LIKE ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {
            preparedStatement.setString(1, region);

            ResultSet resultSet = preparedStatement.executeQuery();

            return CandidateConverter.from(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }


    //todo
    @Override
    public List<Region> maxPopulation() {

        String sql = "SELECT id,region_name,population FROM regions WHERE population = (SELECT max(population) FROM regions)";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            return RegionConverter.from(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
