package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.view.EditMenuView;
import lycheenoisi.paintball.view.View;

import java.time.LocalDate;
import java.util.List;

public class EditMenuController extends Controller{
    private final Member member;
    private final EditMenuView view = new EditMenuView();

    public EditMenuController(Member member) {
        this.member = member;
    }

    public LocalDate askBirthDate(LocalDate actual) {
        LocalDate date;
        String error;
        do {
            date = view.askBirthDate(actual);
            error = Member.isValidBirthdate(date);
            if (error != null) view.error(error);
        } while (error != null);
        return date;
    }

    public void run(){
        View.Action res;
        List<String> errors;
        try{
            Member current = PaintballApp.getLoggedUser();
            do{
                view.displayHeader();

                view.displayUsername(member.getUsername());
                String firstName = view.askFirstname(member.getFirstName());
                String lastName = view.askLastname(member.getLastName());
                LocalDate bitrhdate = view.askBirthDate(member.getBirthdate());
                String email = view.askEmail(member.getEmail());
                
                boolean admin = member.isAdmin();
                if (current.isAdmin() && !member.equals(current))
                    admin = view.askAdmin(admin);
                else
                    view.displayAdmin(member.isAdmin());
                
                member.setFirstName(firstName);
                member.setLastName(lastName);
                member.setBirthdate(bitrhdate);
                member.setEmail(email);
                errors = member.validate();
                if (errors.size() > 0)
                    view.showErrors(errors);
            } while (errors.size() >0);

            res = view.askForAction();
            if (res.getAction() == 'O')
                member.save();
            else
                member.reload();
        } catch (View.ActionInterruptedException e){
            member.reload();
            view.pausedWarning("Edit profile aborted");
        }
    }
}
