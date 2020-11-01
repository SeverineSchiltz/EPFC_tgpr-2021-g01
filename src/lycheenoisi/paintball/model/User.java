package lycheenoisi.paintball.model;

import java.sql.PreparedStatement;
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
    private Role role;

    // Constructeurs

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, Role role){
        this(username);
        this.password = password;
        this.role = role;
    }

    public User(String username, String firstname, String lastname, LocalDate birthdate, String email,
                String password, Role role) {
        this(username, password, role);
        this.firstName = firstname;
        this.lastName = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
    }

    // Liste des accesseurs et mutateurs

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Validations

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

    // Role: to check
    public static String isValidRole(Role role) {
        if (role.equals("admin") || role.equals("employee") || role.equals("member") || role.equals("membervip"))
            return "role should be 'admin' or 'employe' or 'member' or 'member vip'";
        return null;
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
        err = isValidRole(role);
        if (err != null) errors.add(err);

        // cross-fields validations
        /*if (profile != null && profile.equals(pseudo))
            errors.add("profile and pseudo must be different");
        gardé comme exemple*/
        return errors;
    }

    // To check with enum

    public boolean isAdmin() {
        return this.getRole().getNomDB().equals(Role.admin.getNomDB());
    }

    public boolean isEmployee() {
        return this.getRole().getNomDB().equals(Role.employee.getNomDB());
    }

    public boolean isMember() {
        return this.getRole().getNomDB().equals(Role.member.getNomDB());
    }

    public boolean isMemberVIP() {
        return this.getRole().getNomDB().equals(Role.membervip.getNomDB());
    }

    // Method "mapper": check user.setRole
    public static void mapper(ResultSet rs, User user) throws SQLException {
        user.setUsername(rs.getString("username"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setBirthdate(rs.getObject("birthdate", LocalDate.class));
//        user.setEmail(rs.getString("email")); // pas d'adresses mail pour le moment
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getObject("role", Role.class));
    }

    // Method "getByUsername": complete for "admin" and "employee"
    public static User getByUsername(String username) {
        User user = null;
        try {
            String query = "select * from User where username=?";
            var stmt = db.prepareStatement(query);
            stmt.setString(1, username);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                if(rs.getString("role").equals(Role.member.getNomDB()) ||
                        rs.getString("role").equals(Role.membervip.getNomDB()))
                    user = new Member();
                mapper(rs, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (User)user;
    }

    public boolean save() {
        User u = getByUsername(this.getUsername());
        int count = 0;
        try {
            PreparedStatement stmt;
            if (u == null) {
                String query = "insert into User (username, firstname, lastname, birthdate, email, password, role) " +
                        "values (?,?,?,?,?,?,?)";
                stmt = db.prepareStatement(query);
                stmt.setString(1, this.getUsername());
                stmt.setString(2, this.getFirstName());
                stmt.setString(3, this.getLastName());
                stmt.setObject(4, this.getBirthdate());
                stmt.setString(5, this.getEmail());
                stmt.setString(6, this.getPassword());
                stmt.setObject(7, this.getRole());
            } else {
                String query = "update User set firstname=?, lastname=?, birthdate=?, email=?, password=?, " +
                        "role=? where username=?";
                stmt = db.prepareStatement(query);
                stmt.setString(1, this.getFirstName());
                stmt.setString(2, this.getLastName());
                stmt.setObject(3, this.getBirthdate());
                stmt.setString(4, this.getEmail());
                stmt.setString(5, this.getPassword());
                stmt.setObject(6, this.getRole());
                stmt.setString(7, this.getUsername());
            }
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count == 1;
    }

    public boolean delete() {
        int count = 0;
        try {
            String query = "delete from User where username=?";
            PreparedStatement stmt = db.prepareStatement(query);
            stmt.setString(1, this.getUsername());
            count = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count == 1;
    }

    public void reload() {
        try {
            String query = "select * from User where username=?";
            var stmt = Model.db.prepareStatement(query);
            stmt.setString(1, this.getUsername());
            var rs = stmt.executeQuery();
            if (rs.next()) {
                mapper(rs, this);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
