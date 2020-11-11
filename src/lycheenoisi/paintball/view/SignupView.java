package lycheenoisi.paintball.view;

import java.time.LocalDate;

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

    public String askFirstName() {
        return askString("First name: ", null);
    }

    public String askLastName() {
        return askString("Last name: ", null);
    }

    public LocalDate askBirthdate() {
        return askDate("Birth date (dd/mm/yyyy): ", null);
    }

    public String askEmail() {
        return askString("E-mail: ", null);
    }

    public String askPassword() {
        return askString("Password: ", null, true);
    }

    public String askPasswordConfirmation() {
        return askString("Confirm password:", null, true);
    }

}
