package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.view.SignupView;
import lycheenoisi.paintball.view.StartMenuView;
import lycheenoisi.paintball.view.View;

import java.util.Date;

public class SignUpController {

    private final SignupView view = new SignupView();

    private String askUsername() {
        String username;
        Member member;
        do {
            username = view.askUsername();
            member = Member.getByUsername(username);
            if (member != null) {
                view.error("username already exists, please choose another one");
            }
        } while (member != null);
        return username;
    }

    private Date askBirthDate() {
        String username;
        Member member;
        do {
            username = view.askUsername();
            member = Member.getByUsername(username);
            if (member != null) {
                view.error("username already exists, please choose another one");
            }
        } while (member != null);
        return new Date();
    }

    private String askEmail() {
        String email;
        Member member;
        do {
            email = view.askUsername();
            member = Member.getByUsername(email);
            if (member != null) {
                view.error("username already exists, please choose another one");
            }
        } while (member != null);
        return email;
    }

    private String askFirstName() {
        String firstname;
        Member member;
        do {
            firstname = view.askUsername();
            member = Member.getByUsername(firstname);
            if (member != null) {
                view.error("username already exists, please choose another one");
            }
        } while (member != null);
        return firstname;
    }

    private String askLastName() {
        String lastname;
        Member member;
        do {
            lastname = view.askUsername();
            member = Member.getByUsername(lastname);
            if (member != null) {
                view.error("username already exists, please choose another one");
            }
        } while (member != null);
        return lastname;
    }

    private String askPassword() {
        String username;
        Member member;
        do {
            username = view.askUsername();
            member = Member.getByUsername(username);
            if (member != null) {
                view.error("username already exists, please choose another one");
            }
        } while (member != null);
        return username;
    }

    public void run() {
        view.displayHeader();
        try {
            var username = askUsername();
            var firstname = askFirstName();
            var lastname = askLastName();
            var birthdate = askBirthDate();
            var email = askEmail();
            var password = askPassword();
            Member.addMember(username, firstname, lastname, birthdate, email, password, "member");
            var member = new Member(username);
            PaintballApp.setLoggedUser(member);
            new MainMenuMemberController().run();
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("aborted signup");
        }
    }
}
