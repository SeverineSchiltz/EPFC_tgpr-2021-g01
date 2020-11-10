package lycheenoisi.paintball.view;

import lycheenoisi.paintball.PaintballApp;

public class MainMenuMemberView extends View {

    public void displayHeader() {
        displayHeader("Main Menu - " + PaintballApp.getLoggedUser().getUsername());
    }

}
