package lycheenoisi.paintball.model;

import java.util.Date;

public class Member extends Model {
    private String username;

    public Member(String username){
        this.setUsername(username);
    }

    public static Member getByUsername(String username) {
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return "";
    }

    public static boolean addMember(String username, String firstname, String lastname, Date birthdate, String email, String password, String role) {
        return true;
    }
}