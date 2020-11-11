package lycheenoisi.paintball.view;

public class LoginView extends View {

    public void displayHeader() {
        clear();
        displayHeader("Login");
        //println("\n=== Login ===\n");
    }

    public String askUsername() {
        return askString("Username: ", null);
    }

    public String askPassword() {
        return askString("Password: ", null, true);
    }

}
