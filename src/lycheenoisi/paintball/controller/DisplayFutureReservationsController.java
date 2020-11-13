package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Employee;
import lycheenoisi.paintball.model.Reservation;
import lycheenoisi.paintball.view.View;
import lycheenoisi.paintball.view.DisplayFutureReservationsView;

public class DisplayFutureReservationsController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayFutureReservationsView();
            var current = PaintballApp.getLoggedUser();
            View.Action res;
            if (current != null && (current.isAdmin() || current.isEmployee())) {
                do {
                    var reservations = Reservation.getAllFutureReservations();
                    view.displayHeader();
                    view.displayReservations(reservations);
                    view.displayMenu();
                    res = view.askForAction(reservations.size());
                    switch (res.getAction()) {
                        case 'C': // to cancel a reservation
                            Reservation r = reservations.get(res.getNumber() - 1);
                            new CancelReservationController().run(r.getMb());
                            break;
                    }
                } while (res.getAction() != 'L'); // to leave (not consistent with "L" for login)
            }
        } catch (View.ActionInterruptedException e) {
        }
    }

}
