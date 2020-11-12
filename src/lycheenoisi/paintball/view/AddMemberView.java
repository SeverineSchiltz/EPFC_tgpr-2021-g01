package lycheenoisi.paintball.view;

import java.time.LocalDate;

public class AddMemberView extends View{
    public void displayHeader() {
        displayHeader("Add Member");
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
        return askString("Password : ", "", true);
    }

    public LocalDate askBirthDate() {
        return askDate("Birth Date : ", null);
    }

    public boolean askVip() {
        return askBoolean("Is VIP : ", false);
    }

    public View.Action askForAction() {
        return doAskForAction(-1,
                "\n[O] Confirm, [C] Cancel", "[oO]|[cC]");
    }

}