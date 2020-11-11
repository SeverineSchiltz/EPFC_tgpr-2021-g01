package lycheenoisi.paintball.model;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public static boolean isValidFightTypeName(String nameToValidate){
        String request=null;
        request = "SELECT ft.name 'ft_name' from  fight_type ft";
        ArrayList<String> ftNames = new ArrayList<String>();

        try {
            var stmt = db.prepareStatement(request);
            var rs = stmt.executeQuery();
            while (rs.next()) {
                String ftName = rs.getString("ft_name");
                ftNames.add(ftName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("ftn input : "+nameToValidate);
        for(String ftn : ftNames){
            System.out.println("ftn db : "+ftn);
            if(nameToValidate!=null && nameToValidate.toUpperCase().equals(ftn)){
                return true;
            }
        }
        return false;
    }
}
