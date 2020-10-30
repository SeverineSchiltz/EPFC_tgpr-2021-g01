package lycheenoisi.paintball.view;

public class SignupView extends View {

    public void displayHeader() {
        clear();
        displayHeader("Signup");
    }

    public void displayMenu() {
        println(" [L] Login");
        println("\n[S] SignUp");
        println("\n[Q] Quit");
    }

    public Action askForAction() {
        return doAskForAction(-1, "", " [lL]|[sS]|[qQ]");
    }

    public String askUsername() {
        return askString("Username: ", null);
    }

    public String askPassword() {
        return askString("Password: ", null, true);
    }

}
