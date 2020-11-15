package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.MainMenuMemberView;
import lycheenoisi.paintball.view.View;

import static lycheenoisi.paintball.model.Role.membervip;

public class MainMenuMemberController extends Controller {

    public void run() {
        User connectedUser = PaintballApp.getLoggedUser();
        MainMenuMemberView view = new MainMenuMemberView();
        try {
            View.Action res;
            do {
                view.displayHeader();
                int size = 0;

                if (connectedUser.getRole().equals(membervip))
                    res = view.askForActionVIP(size);
                else
                    res = view.askForAction(size);

                switch (res.getAction()) {
                    case 'B':
                        new BookFieldController(connectedUser).run();
                        break;
                    case 'E':
                        new EditMenuController(connectedUser).run();
                        break;
                    case 'R':
                        new DisplayReservationsController().run();
                        break;
                    case 'A':
                        new DisplayAllFieldsController().run();
                        break;
                    case 'F':
                        new DisplayAllFightTypesController().run();
                        break;
                    case 'Q':
                        new DisplayAllEquipmentsController().run();
                        break;
                    case 'D':
                        new DisplayAvailableFieldsController().run();
                        break;
                }
            } while (res.getAction() != 'L');
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("logged out");
        }

        PaintballApp.logout();
    }
}