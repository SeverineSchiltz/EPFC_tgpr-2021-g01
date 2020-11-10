package lycheenoisi.paintball.view;

import lycheenoisi.paintball.PaintballApp;

public class MainMenuMemberView extends View {
    public void displayHeader() {
        displayHeader("Main menu member:");
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[R] Make a reservation, [E] Edit profile, [A] Display reservations, [L] Logout",
                "[rR]+|[eE]+|[aA]+|[lL]");
    }

    public View.Action askForActionVIP(int size) {
        return doAskForAction(size, "\n[R] Make a reservation, [E] Edit profile, [A] Display reservations, [L] Logout",
                "[rR]+|[eE]+|[aA]+|[lL]");
    }
}
