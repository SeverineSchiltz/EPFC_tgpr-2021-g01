package lycheenoisi.paintball.model;

import java.sql.Date;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lycheenoisi.paintball.model.Timeslot.*;

public class Reservation extends Model {

    private int id;
    private LocalDate date;
    private Timeslot timeslot;
    private boolean isCancelled;
    private Field field;
    private List<EquipmentType> equipmentTypeList = new ArrayList<>();
    private FightType ft;
    private Member mb;
    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;

    }

    public static void cancelReservation(int id) {
        String requestSetIsCancelled = " UPDATE reservation SET is_cancelled = true where id = ?";
        String requestDeleteReservationEquipmentStock = "DELETE from reservation_equipment_stock WHERE reservation_id = ?";
        try {
            var statementUpdate = db.prepareStatement(requestSetIsCancelled);
            statementUpdate.setInt(1, id);
            statementUpdate.executeQuery();
            var statementDelete = db.prepareStatement(requestDeleteReservationEquipmentStock);
            statementDelete.setInt(1, id);
            statementDelete.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createReservation(LocalDate date, Timeslot timeslot, int fieldId, int userId, String fightType) {
        String requestNameFT = " SELECT * FROM fight_type where name = ?";
        try {
            var statementNameFT = db.prepareStatement(requestNameFT);
            statementNameFT.setString(1, fightType);
            var rs = statementNameFT.executeQuery();
            int fightTypeId = 0;
            while (rs.next()) {
                fightTypeId = rs.getInt("id");
            }


        String requestCreateReservation = " INSERT into RESERVATION (`date`, `timeslot`, `is_cancelled`, `field_id`, `user_id`, `fight_type_id`) VALUES (?, ?, NULL, ?, ?, ?)";

            var statementCreate = db.prepareStatement(requestCreateReservation);
            statementCreate.setDate(1, Date.valueOf(date));
            statementCreate.setString(2, timeslot.getNomDB());
            statementCreate.setInt(3, fieldId);
            statementCreate.setInt(4, userId);
            statementCreate.setInt(5, fightTypeId);
            statementCreate.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Reservation> getReservationsNotCancelled(Member m) {
//        Requete:
//        SELECT r.id, r.date, r.timeslot, f.name 'field_name', f.description 'field_description', f.is_inside, f.level, f.min_players, f.max_players, f.vip, f.price, et.name 'equipment_name', et.rent_price
//        from reservation r
//        LEFT JOIN user u ON u.id =  r.user_id
//        LEFT JOIN field f ON f.id = r.field_id
//        LEFT JOIN reservation_equipment_stock re ON re.reservation_id = r.id
//        LEFT JOIN equipment_stock eo ON eo.id = re.equipment_stock_id
//        LEFT JOIN equipment_type et ON et.id = eo.equipment_type_id
//        WHERE u.username = 'lmalsag' and r.is_cancelled IS NULL and r.date > NOW()
//        ORDER BY r.id

        String request = " SELECT r.id, r.date, r.timeslot, f.name 'field_name', f.description 'field_description', f.is_inside, f.level, f.min_players, f.max_players, f.vip, f.price, et.name 'equipment_name', et.rent_price";
        request += " from reservation r";
        request += " LEFT JOIN user u ON u.id =  r.user_id";
        request += " LEFT JOIN field f ON f.id = r.field_id";
        request += " LEFT JOIN reservation_equipment_stock re ON re.reservation_id = r.id";
        request += " LEFT JOIN equipment_stock eo ON eo.id = re.equipment_stock_id";
        request += " LEFT JOIN equipment_type et ON et.id = eo.equipment_type_id";
        request += " WHERE u.username = ? and r.is_cancelled IS NULL and r.date > NOW()";
        request += " ORDER BY r.id";

        var list = new ArrayList<Reservation>();
        try {
            var stmt = db.prepareStatement(request);
            stmt.setString(1, m.getUsername());
            var rs = stmt.executeQuery();
            //à changer pour avoir les équipements bien reliés à la bonne réservation
            int idPrec = -1;
            var r = new Reservation();
            r.setMb(m);
            while (rs.next()) {
                if (rs.getInt("id") != idPrec) {
                    r = new Reservation();
                    r.id = rs.getInt("id");
                    r.setDate(rs.getObject("date", LocalDate.class));
                    String tmsl = rs.getString("timeslot");
                    if(tmsl.equals(Morning.getNomDB())){
                        r.setTimeslot(Morning);
                    }else if(tmsl.equals(Afternoon.getNomDB())){
                        r.setTimeslot(Afternoon);
                    }else if(tmsl.equals(Evening.getNomDB())){
                        r.setTimeslot(Evening);
                    }
                    r.setCancelled(false);
                    var f = new Field(rs.getString("field_name"), rs.getString("field_description"), rs.getBoolean("is_inside"), rs.getInt("level"), rs.getInt("max_players"), rs.getInt("min_players"), rs.getBoolean("vip"), rs.getDouble("price"));
                    r.setField(f);
                    r.getEquipmentList().add(new EquipmentType(rs.getString("equipment_name"), rs.getDouble("rent_price")));
                    list.add(r);
                }else{
                    r.getEquipmentList().add(new EquipmentType(rs.getString("equipment_name"), rs.getDouble("rent_price")));
                }
                idPrec = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Reservation> getAllFutureReservations() {

        var list = new ArrayList<Reservation>();

        String query = "SELECT r.id 'Booking_ID', u.username 'Member_username', r.date 'Booking_date', ";
        query += "r.timeslot 'Booking_timeslot', f.name 'Field_name', ft.name 'Fight_type_name', ";
        query += "et.name 'Equipment_type_name' ";
        query += "FROM reservation r ";
        query += "JOIN user u ON r.user_id = u.id ";
        query += "JOIN field f ON r.field_id = f.id ";
        query += "JOIN fight_type ft ON r.fight_type_id = ft.id ";
        query += "JOIN reservation_equipment_stock res ON r.id = res.reservation_id ";
        query += "JOIN equipment_stock es ON res.equipment_stock_id = es.id ";
        query += "JOIN equipment_type et ON es.equipment_type_id = et.id ";
        query += "WHERE r.is_cancelled IS NULL AND r.date >= NOW() ";
        //query += " AND (u.role = 'member' OR u.role = 'member vip') ";
        query += "ORDER BY r.id";

        try {
            var stmt = db.prepareStatement(query);
            var rs = stmt.executeQuery();
            int idPrec = 0;
            var reservation = new Reservation();
            while (rs.next()) {
                if (rs.getInt("id") != idPrec) {
                    reservation = new Reservation();
                    reservation.id = rs.getInt("Booking_ID");
                    reservation.setDate(rs.getObject("Booking_date", LocalDate.class));
                    String tmsl = rs.getString("Booking_timeslot");
                    if (tmsl.equals(Morning.getNomDB())) {
                        reservation.setTimeslot(Morning);
                    } else if (tmsl.equals(Afternoon.getNomDB())) {
                        reservation.setTimeslot(Afternoon);
                    } else if (tmsl.equals(Evening.getNomDB())) {
                        reservation.setTimeslot(Evening);
                    }
                    reservation.setCancelled(false);

                    var member = new Member(rs.getString("Member_username"));
                    reservation.setMb(member);

                    var field = new Field(rs.getString("Field_name"));
                    reservation.setField(field);

                    var fightType = new FightType(rs.getString("Fight_type_name"));
                    reservation.setFt(fightType);

                    var equipmentType = new EquipmentType(rs.getString("Equipment_type_name"));
                    reservation.getEquipmentList().add(equipmentType);

                    list.add(reservation);

                } else {
                    var equipmentType = new EquipmentType(rs.getString("Equipment_type_name"));
                    reservation.getEquipmentList().add(equipmentType);

                }
                idPrec = reservation.id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String toString(){
        String equipments ="";
        for(EquipmentType eq : equipmentTypeList){
            equipments += eq.toString() + ", ";
        }
        String m;
        if (this.mb == null) {
            m = "";
        } else {
            m = "; [username: " + this.mb.getUsername() + "]";
        }

        String dt = this.getDate().getDayOfMonth() + "/" + this.getDate().getMonthValue() + "/" + this.getDate().getYear();
        return "Reservation Date : " + dt + " " + this.timeslot + "; [" + this.getField() + "]; [" + equipments + "]"
                + m;
    }

    public void cancelReservation(){

    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public List<EquipmentType> getEquipmentList() {
        return equipmentTypeList;
    }

    public void setEquipmentList(List<EquipmentType> equipmentTypeList) {
        this.equipmentTypeList = equipmentTypeList;
    }

    public FightType getFt() {
        return ft;
    }

    public void setFt(FightType ft) {
        this.ft = ft;
    }

    public Member getMb() {
        return mb;
    }

    public void setMb(Member mb) {
        this.mb = mb;
    }
}
