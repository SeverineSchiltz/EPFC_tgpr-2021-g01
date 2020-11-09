package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.model.Role;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.view.AddMemberView;
import lycheenoisi.paintball.view.View;

import java.time.LocalDate;
import java.util.List;

public class AddMemberController {
    private final AddMemberView view = new AddMemberView();

    public void run() {
        View.Action res;
        List<String> errors;
        Member newMember = new Member();
        try {
            do {
                view.displayHeader();
                // encodage des données
                String username = view.askUserName();
                String firstname = view.askFirstname();
                String name = view.askName();
                String email = view.askEmail();
                String psw = view.askPsw();
                boolean vip = view.askVip();
                LocalDate birthDate = askBirthDate();

                // validations métier
                newMember.setUsername(username);
                newMember.setFirstName(firstname);
                newMember.setLastName(name);
                newMember.setEmail(email);
                newMember.setPassword(psw);
                if(vip){
                    newMember.setRole(Role.membervip);
                }else{
                    newMember.setRole(Role.member);
                }
                newMember.setBirthdate(birthDate);
                errors = newMember.validate();
                // affichage des erreurs
                if (errors.size() > 0)
                    view.showErrors(errors);

            } while (errors.size() > 0); // on recommence tant qu'il y a des erreurs

            res = view.askForAction();
            if (res.getAction() == 'O') {
                newMember.save();   // sauvegarde des nouvelles données
            }
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("add profile aborted");
        }
    }

    public LocalDate askBirthDate() {
        LocalDate date;
        String error;
        do {
            date = view.askBirthDate();
            error = User.isValidBirthdate(date);
            if (error != null) view.error(error);
        } while (error != null);
        return date;
    }

}
