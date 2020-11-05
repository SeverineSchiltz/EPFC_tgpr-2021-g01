package lycheenoisi.paintball.model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Field extends Model{

    private int id;
    private String name;
    private String description;
    private boolean is_inside;
    private int level;
    private int maxPlayers;
    private int minPlayers;
    private boolean vip;
    private double price;

    // to delete ? (I let this constructor to avoid impacting the class Reservation.)
    public Field(String name, String description, boolean is_inside, int level, int maxPlayers, int minPlayers, boolean vip, double price) {
        this.setName(name);
        this.setDescription(description);
        this.setIs_inside(is_inside);
        this.setLevel(level);
        this.setMaxPlayers(maxPlayers);
        this.setMinPlayers(minPlayers);
        this.setVip(vip);
        this.setPrice(price);
    }

    public Field(int id, String name, String description, boolean is_inside, int level, int maxPlayers, int minPlayers, boolean vip, double price) {
        this.id = id;
        this.setName(name);
        this.setDescription(description);
        this.setIs_inside(is_inside);
        this.setLevel(level);
        this.setMaxPlayers(maxPlayers);
        this.setMinPlayers(minPlayers);
        this.setVip(vip);
        this.setPrice(price);
    }

    public Field() { }

    @Override
    public String toString(){
        return "Name field: " + this.getName() + ", Description: " + this.description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isIs_inside() {
        return is_inside;
    }

    public void setIs_inside(boolean is_inside) {
        this.is_inside = is_inside;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static ArrayList<Field> getAvailableFields(LocalDate date, Timeslot timeslot, String fightType){
         /*     select * from Field f
        left join Reservation r on f.id = r.field_id
        ++ to add >> join fight type et check fight type en input
        where not EXISTS(
                select * from Reservation r2
                where r2.field_id = f.id and r2.timeslot = 1 and r2.date = str_to_date('2020,10,19','%Y,%m,%d')
                */

        String request = "SELECT f.id, f.name, f.max_players, f.min_players, f.price";
        request += "from  Field f";
        request += "inner join Fight_Type_Field ftf on f.id = ftf.field_id";
        request += "inner join Fight_Type ft on ftf.fight_type_id = ft.id";
        request += "WHERE ft.name = ?";
        request += "AND NOT EXISTS(";
                request += "SELECT 1 FROM Reservation r2";
                request += "WHERE r2.field_id = f.id";
                request += "AND r2.date = ?";
                request += "AND r2.timeslot = ?)";

        var fields = new ArrayList<Field>();
        try {
            System.out.println(fightType);
            var stmt = db.prepareStatement(request);
            stmt.setString(1,fightType);
            stmt.setDate(2, java.sql.Date.valueOf(date));
            stmt.setInt(3, timeslot.getId());

            var rs = stmt.executeQuery();
            while (rs.next()) {
                    var f = new Field();
                    f.setId(rs.getInt("id"));
                    f.setName(rs.getString("name"));
                    f.setMaxPlayers(rs.getInt("max_players"));
                    f.setMinPlayers(rs.getInt("min_players"));
                    f.setPrice(rs.getDouble("price"));

                    fields.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fields;
    }
}