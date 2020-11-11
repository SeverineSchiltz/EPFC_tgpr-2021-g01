package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.view.View;
import lycheenoisi.paintball.view.DisplayMembersView;

public class DisplayMembersController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayMembersView();
            var current = PaintballApp.getLoggedUser();
            View.Action res;
            if (current != null && (current.isAdmin() || current.isEmployee())) {
                do {
                    var members = Member.getAllMembers();
                    view.displayHeader();
                    view.displayMembers(members);
                    view.displayMenu();
                    res = view.askForAction(members.size());
                    switch (res.getAction()) {
                        case 'E': // to edit a member's profile
                            Member memberEdit = members.get(res.getNumber() - 1);
                            new EditMenuController(memberEdit).run();
                            break;
                        case 'A': // to add a member
                            new AddMemberController().run();
                            break;
                        case 'D': // to delete a member
                            // !!! to check !
                            Member memberDelete = members.get(res.getNumber() - 1);
                            memberDelete.delete();
                            break;
                        case 'B':
                            // !!! not the right UC at this stage !
                            new BookFieldAndEquipmentController().run();
                            break;
                    }

                } while (res.getAction() != 'L'); // to leave (not consistent with "L" for login)
            }
        } catch (View.ActionInterruptedException e) {
        }

    }

}
