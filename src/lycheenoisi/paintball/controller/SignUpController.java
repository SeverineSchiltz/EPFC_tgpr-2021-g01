package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.SignupView;
import lycheenoisi.paintball.view.View;

import java.time.LocalDate;

public class SignUpController {

    private final SignupView view = new SignupView();

    private String askUsername() {
        String username;
        User user;
        do {
            username = view.askUsername();
            user = User.getByUsername(username);
            if (user != null) {
                view.error("username already exists, please choose another one");
            }
            else if (User.isValidUsername(username) != null) {
                view.error(User.isValidUsername(username));
            }
        } while (user != null || User.isValidUsername(username) != null);
        return username;
    }

    private LocalDate askBirthDate() {
        LocalDate birthdate;
        do {
            birthdate = view.askBirthdate();
            if(birthdate == null) {
                view.error("please enter your birth date");
            }
            else if (User.isValidBirthdate(birthdate) != null) {
                view.error(User.isValidBirthdate(birthdate));
            }
        } while (birthdate == null || User.isValidBirthdate(birthdate) != null);
        return birthdate;
    }

    private String askEmail() {
        String email;
        User user;
        do {
            email = view.askEmail();
            user = User.getByEmail(email);
            if(email == null) {
                view.error("please enter your email");
            }
            else if (user != null) {
                view.error("email already exists, please choose another one");
            }
            else if (User.isValidEmail(email) != null) {
                view.error(User.isValidEmail(email));
            }
        } while (email == null || user != null || User.isValidEmail(email) != null);
        return email;
    }

    private String askFirstName() {
        String firstname;
        do {
            firstname = view.askFirstName();
            if (firstname == null) {
                view.error("Please type your first name");
            }
        } while (firstname == null);
        return firstname;
    }

    private String askLastName() {
        String lastname;
        do {
            lastname = view.askLastName();
            if (lastname == null) {
                view.error("Please type your last name");
            }
        } while (lastname == null);
        return lastname;
    }

    private String askPassword() {
        String password;
        String passwordConfirmation;
        do {
            do {
                password = view.askPassword();
                if(password == null) {
                    view.error("Please type a password");
                }
                else if (User.isValidPassword(password) != null) {
                    view.error(User.isValidPassword(password));
                }
            } while (password == null || User.isValidPassword(password) != null);
            passwordConfirmation = view.askPasswordConfirmation();
            if (!password.equals(passwordConfirmation)) {
                view.error("the passwords do not match, please retype your password");
            }
        } while (!password.equals(passwordConfirmation));
        return password;
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
            var member = new Member(username, firstname, lastname, birthdate, email, password);
            member.save();
            PaintballApp.setLoggedUser(member);
            new MainMenuMemberController().run();
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("aborted signup");
        }
    }
}
