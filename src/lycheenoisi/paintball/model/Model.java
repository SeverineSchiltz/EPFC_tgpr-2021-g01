package lycheenoisi.paintball.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Model {
    protected static Connection db;

    static {
        try {
            db = DriverManager.getConnection("jdbc:mariadb://localhost:3306/tgpr-2021-g01-paintball?user=root&password=root");
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

    public boolean isAdmin() {
        return false;
    }
}
