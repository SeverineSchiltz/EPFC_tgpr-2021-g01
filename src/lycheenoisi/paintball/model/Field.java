package lycheenoisi.paintball.model;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;



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

    public Field(String name) {
        this.name = name;
    }

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

    public static ArrayList<Field> getAllFields(){
        return getAvailableFields(null,null,null);
    }

    public static ArrayList<Field> getAvailableFields(LocalDate date, Timeslot timeslot, String fightType){
        String request;
        if(date!=null && timeslot!=null && fightType!=null){
            request = "SELECT f.id 'id', f.name 'name', f.max_players 'max_players', f.min_players 'min_players', f.price 'price' from  Field f";
            request += " inner join Fight_Type_Field ftf on f.id = ftf.field_id";
            request += " inner join Fight_Type ft on ftf.fight_type_id = ft.id";
            request += " WHERE NOT EXISTS(SELECT * FROM Reservation r2 WHERE r2.field_id = f.id";
            request += " AND r2.date = ? ";
            request += " AND r2.timeslot = ? )";
            request += " AND ft.name = ?";
        }
        else {
            request = "SELECT f.id 'id', f.name 'name', f.max_players 'max_players', f.min_players 'min_players', f.price 'price' from  Field f";
        }
        var fields = new ArrayList<Field>();
        try {
            var stmt = db.prepareStatement(request);

            if(date!=null && timeslot!=null && fightType!=null) {
                stmt.setDate(1, java.sql.Date.valueOf(date));
                stmt.setString(2, timeslot.getNomDB());
                stmt.setString(3, fightType);
            }
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



    public void save() {
        String query = "insert into Field (name, description, is_inside, level, max_players, min_players, vip, price) " +
                "values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt;
            stmt = db.prepareStatement(query);
            stmt.setString(1, this.getName());
            stmt.setString(2, this.getDescription());
            stmt.setBoolean(3, this.isIs_inside());
            stmt.setInt(4, this.getLevel());
            stmt.setInt(5, this.getMaxPlayers());
            stmt.setInt(6, this.getMinPlayers());
            stmt.setBoolean(7, this.isVip());
            stmt.setDouble(8, this.getPrice());
            stmt.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String isValidName(String name) {
        if (name == null || !Pattern.matches("[a-zA-Z0-9]{3,}", name))
            return "invalid field name, must be at least 3 characters long with no special character";
        return null;
    }

 /*   public static String isValidDescription(String description) {
        if (description == null || !Pattern.matches("[a-zA-Z0-9]{1,}", description))
            return "there shl";
        return null;
    } */


    public List<String> validate() {
        var errors = new ArrayList<String>();

        var err = isValidName(name);
        if (err != null) errors.add(err);
        //la description peut être null
        //err = isValidDescription(description);
        //if (err != null) errors.add(err);
        return errors;
    }


    public static List<String> getAllFieldsStats(){
        String query =  "SELECT src.name, "+
                        "(SELECT count(*) "+
                        "FROM field trg1 JOIN reservation ON trg1.id=reservation.field_id "+
                        "WHERE reservation.is_cancelled IS NULL and src.id=trg1.id) as NC, "+
                        "(SELECT count(*) "+
                        "FROM field trg2 JOIN reservation ON trg2.id=reservation.field_id "+
                        "WHERE reservation.is_cancelled IS NOT NULL and src.id=trg2.id) as C "+
                        "FROM field src "+
                        "GROUP BY src.name "+
                        "ORDER BY src.id";

        var fieldsStats = new ArrayList<String>();
        try {
            var stmt = db.prepareStatement(query);

            var rs = stmt.executeQuery();
            while (rs.next()) {
                String field = String.format("%-12s",rs.getString(1))+"  "+
                                String.format("%2s",rs.getString(2))+"   "+
                                String.format("%2s",rs.getString(3));
                fieldsStats.add(field);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fieldsStats;
    }

    public static List<String> getFieldStats(int id){
        String query =  "SELECT src.name, " +
                        "(SELECT count(*) " +
                        "FROM field f1 JOIN reservation ON f1.id=reservation.field_id " +
                                      "JOIN fight_type trg1 on reservation.fight_type_id = trg1.id " +
                        "WHERE reservation.is_cancelled IS NULL and src.id=trg1.id and f1.id = "+id+") as NC, " +
                        "(SELECT count(*) " +
                        "FROM field f2 JOIN reservation ON f2.id=reservation.field_id " +
                                      "JOIN fight_type trg2 on reservation.fight_type_id = trg2.id " +
                        "WHERE reservation.is_cancelled IS NOT NULL and src.id=trg2.id and f2.id = "+id+") as C " +
                        "FROM fight_type src " +
                        "GROUP BY src.name";

        var fieldsStats = new ArrayList<String>();
        try {
            var stmt = db.prepareStatement(query);

            var rs = stmt.executeQuery();
            while (rs.next()) {
                String field = String.format("%-12s",rs.getString(1))+"  "+
                        String.format("%2s",rs.getString(2))+"   "+
                        String.format("%2s",rs.getString(3));
                fieldsStats.add(field);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fieldsStats;
    }
}