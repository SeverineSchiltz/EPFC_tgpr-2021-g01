package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.view.View;
import lycheenoisi.paintball.view.StartMenuView;

public class StartMenuController extends Controller {

    public void run() {
        StartMenuView view = new StartMenuView();
        try {
            View.Action res;
            do {
                view.displayHeader();
                view.displayMenu();
                res = view.askForAction();
                switch (res.getAction()) {
                    case 'L':
                        new LoginController().run();
                        break;
                    case 'S':
                        new SignUpController().run();
                        break;
                }
            } while (res.getAction() != 'Q');
        } catch (View.ActionInterruptedException e) {

        }
        view.pausedWarning("leaving the application");
        view.close();
    }

}
