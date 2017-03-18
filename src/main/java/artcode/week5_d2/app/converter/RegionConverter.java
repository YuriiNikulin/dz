package artcode.week5_d2.app.converter;

import artcode.week5_d2.app.model.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii on 04.03.17.
 */
public class RegionConverter {
    public static List<Region> from(ResultSet resultSet) {

        List<Region> regions = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("region_name");
                int population = resultSet.getInt("population");

                Region region = new Region(id, name, population);

                regions.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return regions;

    }
}
