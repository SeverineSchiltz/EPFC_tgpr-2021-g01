package lycheenoisi.paintball.view;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EditMenuView extends View{
    
    public void displayHeader() {
        displayHeader("Edit Profile");
    }

    public void displayUsername(String username) {
        println("Username: " + username);
    }

    public String askFirstname(String actual) {
        return askString("First Name (" + actual + "): ", actual);
    }
    public String askLastname(String actual) {
        return askString("Last Name (" + actual + "): ", actual);
    }
    public String askEmail(String actual) {
        return askString("E-mail (" + actual + "): ", actual);
    }
    
    public LocalDate askBirthDate(LocalDate actual) {
        return askDate("Birth Date (" +
                (actual == null ? "null" : DateTimeFormatter.ofPattern("dd/MM/yyyy").format(actual)) + "): ", actual);
    }

    public boolean askAdmin(boolean actual) {
        return askBoolean("Is Admin (" + actual + "): ", actual);
    }

    public View.Action askForAction() {
        return doAskForAction(-1,
                "\n[O] Confirm, [C] Cancel", "[oO]|[cC]");
    }

    public void displayAdmin(boolean admin) {
        println("Admin: " + admin);
    }
}
