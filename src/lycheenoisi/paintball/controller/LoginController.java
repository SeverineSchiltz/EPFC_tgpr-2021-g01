package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.view.View;
import lycheenoisi.paintball.view.LoginView;

public class LoginController extends Controller {

    private final LoginView view = new LoginView();

    private Member askUsername() {
        String username;
        Member member;
        do {
            username = view.askUsername();
            member = Member.getByUsername(username);
            if (member == null) {
                view.error("unknown user");
            }
        } while (member == null);
        return member;
    }

    private String askPassword(Member member) {
        String password = null;
        do {
            password = view.askPassword();
            if (!password.equals(member.getPassword())) {
                view.error("bad password");
            }
        } while (!password.equals(member.getPassword()));
        return password;
    }

    public void run() {
        view.displayHeader();
        try {
            var member = askUsername();
            askPassword(member);
            PaintballApp.setLoggedUser(member);
            new MainMenuMemberController().run(); //??? MainMenuMember() ?
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("aborted login");
        }
    }

}
