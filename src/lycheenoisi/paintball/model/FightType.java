package lycheenoisi.paintball.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static lycheenoisi.paintball.model.Role.*;
import static lycheenoisi.paintball.model.Role.admin;
import static lycheenoisi.paintball.model.User.mapper;

public class FightType extends Model {
    private String name;
    private String description;
    private int id;

    public FightType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public FightType() { }

    public FightType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<FightType> getAllFightTypes() {
        var list = new ArrayList<FightType>();
        try {
            String query = "SELECT * FROM fight_type ";
            var stmt = db.prepareStatement(query);
            var rs = stmt.executeQuery();
            while (rs.next()) {
                var fightType = new FightType();
                mapper(rs, fightType);
                list.add(fightType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void mapper(ResultSet rs, FightType fightType) throws SQLException {
        fightType.setId(rs.getInt("id"));
        fightType.setName(rs.getString("name"));
        fightType.setDescription(rs.getString("description"));
    }
}
