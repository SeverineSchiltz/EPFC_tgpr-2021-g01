package lycheenoisi.paintball.model;

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
}