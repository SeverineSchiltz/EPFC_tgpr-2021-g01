
//Classe obsolète, à supprimer
package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Reservation;
import lycheenoisi.paintball.view.DisplayReservationsView;
import lycheenoisi.paintball.view.View;

public class DisplayReservationsController extends Controller {

//    public void run() {
//        Member m = new Member("lmalsag");
//        for(Reservation r : Reservation.getReservationsNotCancelled(m))
//            System.out.println(r);
//    }

    @Override
    public void run() {

//        for (var m : members)
//            System.out.println(m);

//        view.displayHeader();
//        view.displayMembers(members);
//        view.pause();
        try {
            var view = new DisplayReservationsView();
            View.Action res;
            do {
                var current = PaintballApp.getLoggedUser();
                var reservations = Reservation.getReservationsNotCancelled(current);
                view.displayHeader();
                view.displayReservations(reservations);
                res = view.askForAction(reservations.size());
                switch (res.getAction()) {
                    case 'C':
                        var r = reservations.get(res.getNumber() - 1);
                        //view.pausedWarning(String.format("You selected '%s'", m.getPseudo()));
                        //r.deleteReservation();
                        break;
                }
            } while (res.getAction() != 'M');
        } catch (View.ActionInterruptedException e) {
            // just leave the loop
        }
//        view.pausedWarning("Leaving the application");
//        view.close();
    }

}
