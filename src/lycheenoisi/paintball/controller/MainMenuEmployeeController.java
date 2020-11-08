package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.view.BookFieldAndEquipmentView;
import lycheenoisi.paintball.view.MainMenuEmployeeView;
import lycheenoisi.paintball.view.View;
import static lycheenoisi.paintball.model.Role.*;

public class MainMenuEmployeeController extends Controller {

    public void run() {
        MainMenuEmployeeView view = new MainMenuEmployeeView();
        try {
            View.Action res;
            do {
                view.displayHeader();
                var current = PaintballApp.getLoggedUser();
                int size = 0;

                if (current.getRole().equals(admin))
                    res = view.askForActionAdmin(size);
                else
                    res = view.askForAction(size);

                switch (res.getAction()) {
                    case 'M':
                        new DisplayMembersController().run();
                        break;
                    case 'R':
                        //new DisplayFuturReservations().run();
                        break;
                    case 'E':
                        new DisplayEmployeesController().run();
                        break;
                }
            } while (res.getAction() != 'L');
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("logged out");
        }

        PaintballApp.logout();
    }
}