package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.View;
import lycheenoisi.paintball.view.LoginView;

public class LoginController extends Controller {

    private final LoginView view = new LoginView();

    private User askUsername() {
        String username;
        User user;
        do {
            username = view.askUsername();
            user = User.getByUsername(username);
            if (user == null) {
                view.error("unknown user");
            }
        } while (user == null);
        return user;
    }

    private String askPassword(User user) {
        String password = null;
        do {
            password = view.askPassword();
            if (!password.equals(user.getPassword())) {
                view.error("bad password");
            }
        } while (!password.equals(user.getPassword()));
        return password;
    }

    public void run() {
        view.displayHeader();
        try {
            var user = askUsername();
            askPassword(user);
            PaintballApp.setLoggedUser(user);
            new CancelReservationController().run(); //??? MainMenuMember() ?
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("aborted login");
        }
    }

}
