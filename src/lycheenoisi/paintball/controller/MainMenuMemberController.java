package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.view.MainMenuMemberView;

public class MainMenuMemberController {
    private final MainMenuMemberView view = new MainMenuMemberView();

    public void run() {
        view.displayHeader();
    }
}
