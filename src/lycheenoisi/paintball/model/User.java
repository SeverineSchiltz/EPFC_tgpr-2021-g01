package lycheenoisi.paintball.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public abstract class User extends Model{
    private String username;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String password;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String isValidBirthdate(LocalDate birthdate) {
        if (birthdate == null)
            return null;
        if (birthdate.compareTo(LocalDate.now()) > 0)
            return "may not be born in the future";
        if (Period.between(birthdate, LocalDate.now()).getYears() < 18)
            return "must be 18 years old";
        return null;
    }

    public static String isValidUsername(String username) {
        if (username == null || !Pattern.matches("[a-zA-Z0-9]{3,}", username))
            return "invalid pseudo";
        return null;
    }

    public static String isValidPassword(String password) {
        if (password == null || !Pattern.matches("[a-zA-Z0-9]{3,}", password))
            return "invalid password";
        return null;
    }

    public static String isValidEmail(String email) {
        if (email == null || !Pattern.matches("[a-zA-Z0-9\\.]*@[a-zA-Z0-9]*\\.[a-zA-Z0-9]*", email))
            //pas normal: en regex "." remplace tout caractère et pour le point il faut utiliser "\."
            return "invalid password";
        return null;
    }

    public boolean isAdmin(){
        return true;// à modifier après avoir regarder les enum
    }

    public List<String> validate() {
        var errors = new ArrayList<String>();

        // field validations
        var err = isValidUsername(username);
        if (err != null) errors.add(err);
        err = isValidPassword(password);
        if (err != null) errors.add(err);
        err = isValidBirthdate(birthdate);
        if (err != null) errors.add(err);
        err = isValidEmail(email);
        if (err != null) errors.add(err);

        // cross-fields validations
        /*if (profile != null && profile.equals(pseudo))
            errors.add("profile and pseudo must be different");
        gardé comme exemple*/
        return errors;
    }

    public boolean save(){
        return true;
    }

    public void reload(){

    }

    public static void mapper(ResultSet rs, User user) throws SQLException {
        user.setUsername(rs.getString("username"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setBirthdate(rs.getObject("birthdate", LocalDate.class));
//        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
    }

    public static User getByUsername(String username) {
        User user = null;
        try {
            String query = "select * from User where username=?";
            var stmt = db.prepareStatement(query);
            stmt.setString(1, username);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                if(rs.getString("role").equals("member") ||
                        rs.getString("role").equals("member vip"))
                    user = new Member();
                mapper(rs, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (User)user;
    }
}
