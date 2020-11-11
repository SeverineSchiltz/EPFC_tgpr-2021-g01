package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.User;

import java.time.LocalDate;

public class AddEmployeeView extends View{
    public void displayHeader() {
        displayHeader("Add Employee Profile");
    }

    public String askUserName() {
        return askString("Username : ", null);
    }

    public String askName() {
        return askString("Lastname : ", null);
    }

    public String askFirstname() {
        return askString("Firstname : ", null);
    }

    public String askEmail() {
        return askString("Email : ", null);
    }

    public String askPsw() {
        return askString("Password : ", null, true);
    }

    public LocalDate askBirthDate() {
        return askDate("Birth Date : ", null);
    }

    public boolean askAdmin() {
        return askBoolean("Is Admin (true or false) : ", false);
    }

    public View.Action askForAction() {
        return doAskForAction(-1,
                "\n[O] Confirm, [C] Cancel", "[oO]|[cC]");
    }

    public void displayAdmin() {
        println("Admin: ");
    }
}
