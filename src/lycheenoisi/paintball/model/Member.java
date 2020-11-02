package lycheenoisi.paintball.model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Member extends User {
    public Member(String username) {
        super(username);
    }

    public Member() {}

    // List of all members (VIP included)
    // Query ok
    public static List<Member> getAllMembers() {
        var list = new ArrayList<Member>();
        try {
            String query = "SELECT * FROM User ";
            query += "WHERE role = 'Role.member.getNomDB()' OR role = 'Role.membervip.getNomDB()'";
            query += "ORDER BY username";
            var stmt = db.prepareStatement(query);
            var rs = stmt.executeQuery();
            while (rs.next()) {
                var member = new Member();
                mapper(rs, member);
                list.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static String isValidEmail(String email) {
        if (email == null || !Pattern.matches("[a-zA-Z0-9/.]*@[a-zA-Z0-9]*/.[a-zA-Z0-9]*", email))
            //pas normal: en regex "." remplace tout caractère et pour le point il faut utiliser "\."
            return "invalid password";
        return null;
    }



}