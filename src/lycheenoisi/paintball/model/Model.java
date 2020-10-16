package lycheenoisi.paintball.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Model {
    protected static Connection db;

    static {
        try {
            db = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tgpr_msn?user=root&password=root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkDb() {
        try {
            if (db == null)
                return false;
            return db.isValid(0);   // 0 pour ne pas utiliser de timeout
        } catch (SQLException e) {
            return false;
        }
    }
}
