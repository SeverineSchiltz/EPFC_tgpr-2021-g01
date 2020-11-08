package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.EditMenuView;
import lycheenoisi.paintball.view.View;

import java.time.LocalDate;
import java.util.List;

public class EditMenuController extends Controller{
    private final User user;
    private final EditMenuView view = new EditMenuView();

    public EditMenuController(User user) {
        this.user = user;
    }

    public LocalDate askBirthDate(LocalDate actual) {
        LocalDate date;
        String error;
        do {
            date = view.askBirthDate(actual);
            error = User.isValidBirthdate(date);
            if (error != null) view.error(error);
        } while (error != null);
        return date;
    }

    public void run(){
        View.Action res;
        List<String> errors;
        try{
            User current = (User)PaintballApp.getLoggedUser();
            //if (!current.isAdmin() && !current.isEmployee() && !current.equals(user)){
            //  prevent modification
            //}
            do {
                view.displayHeader();

                view.displayUsername(user.getUsername());
                String firstName = view.askFirstname(user.getFirstName());
                String lastName = view.askLastname(user.getLastName());
                LocalDate birthDate = view.askBirthDate(user.getBirthdate());
                String email = view.askEmail(user.getEmail());

                boolean admin = user.isAdmin();
                if (current.isAdmin() && !user.equals(current))
                    admin = view.askAdmin(admin);
                else
                    view.displayAdmin(user.isAdmin());

                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthdate(birthDate);
                user.setEmail(email);
                errors = user.validate();
                if (errors.size() > 0)
                    view.showErrors(errors);
            } while (errors.size() > 0);

            res = view.askForAction();
            if (res.getAction() == 'O')
                user.save();
            else
                user.reload();
        } catch (View.ActionInterruptedException e){
            user.reload();
            view.pausedWarning("Edit profile aborted");
        }
    }
}
