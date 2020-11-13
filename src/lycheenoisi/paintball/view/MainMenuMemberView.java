package lycheenoisi.paintball.view;

public class MainMenuMemberView extends View {
    public void displayHeader() {
        displayHeader("Main menu member:");
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[B] Make a reservation, [E] Edit profile, [R] Display reservations, [D] Display available field, [A] Display fields, [F] Display fight types, [Q] Display Equipments, [L] Logout",
                "[bB]+|[eE]+|[rR]+|[aA]+|[fF]+|[qQ]+|[lL]|[dD]");
    }

    public View.Action askForActionVIP(int size) {
        return doAskForAction(size, "\n[B] Make a reservation, [E] Edit profile, [R] Display reservations, [D] Display available field, [A] Display fields, [F] Display fight types, [Q] Display Equipments, [L] Logout",
                "[bB]+|[eE]+|[rR]+|[aA]+|[fF]+|[qQ]+|[lL]|[dD]");
    }
}
