package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.view.MainMenuEmployeeView;
import lycheenoisi.paintball.view.View;

public class MainMenuEmployeeController extends Controller {

    public void run() {
        MainMenuEmployeeView view = new MainMenuEmployeeView();
        try {
            View.Action res;
            do {
                view.displayHeader();
                var current = PaintballApp.getLoggedUser();
                int size = 0;

                res = view.askForActionAdmin(size); // à modifier dès que les classes Role, USER et Employee seront commitées
//                if (current.role...)
//                    res = view.askForActionAdmin(size);
//                else
//                    res = view.askForAction(size);

                switch (res.getAction()) {
                    case 'M':
                        //new DisplayMembers().run();
                        break;
                    case 'R':
                        //new DisplayReservations().run();
                        break;
                    case 'E':
                        //new DisplayEmployees().run();
                        break;
                }
            } while (res.getAction() != 'L');
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("logged out");
        }

        PaintballApp.logout();
    }
}