
package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Reservation;
import lycheenoisi.paintball.view.DisplayReservationsView;
import lycheenoisi.paintball.view.View;

public class DisplayReservationsController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayReservationsView();
            View.Action res;
            do {
                var current = (Member)PaintballApp.getLoggedUser();
                var reservations = Reservation.getReservationsNotCancelled(current);
                view.displayHeader();
                view.displayReservations(reservations);
                res = view.askForAction(reservations.size());
                switch (res.getAction()) {
                    case 'C':
                        new CancelReservationController().run();
                        break;
                }
            } while (res.getAction() != 'M');
        } catch (View.ActionInterruptedException e) {
            // just leave the loop
        }

    }

}
