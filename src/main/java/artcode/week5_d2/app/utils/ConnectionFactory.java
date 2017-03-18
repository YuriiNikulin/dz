package artcode.week5_d2.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static artcode.week5_d2.app.utils.PropertiesHolder.get;
/**
 * Created by serhii on 26.02.17.
 */
public class ConnectionFactory {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("can not init driver for db");
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = get("db.url") + "/" + get("db.name");
        return DriverManager.getConnection(url, get("db.user"), get("db.pass"));
    }
}
