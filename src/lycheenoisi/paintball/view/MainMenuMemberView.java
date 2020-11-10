package lycheenoisi.paintball.view;

public class MainMenuMemberView extends View {
    public void displayHeader() {
        displayHeader("Main menu member:");
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[R] Make a reservation, [E] Edit profile, [F] Display Fields, [A] Display reservations, [L] Logout",
                "[rR]+|[eE]+|[fF]+|[aA]+|[lL]");
    }

    public View.Action askForActionVIP(int size) {
        return doAskForAction(size, "\n[R] Make a reservation, [E] Edit profile, [F] Display Fields, [A] Display reservations, [L] Logout",
                "[rR]+|[eE]+|[fF]+|[aA]+|[lL]");
    }
}
