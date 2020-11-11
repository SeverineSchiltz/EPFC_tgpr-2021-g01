package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Reservation;
import lycheenoisi.paintball.view.CancelReservationView;

import java.util.List;

public class CancelReservationController extends Controller{
    private final CancelReservationView view = new CancelReservationView();

    @Override
    public void run() {
        view.displayHeader("Cancel a reservation:");

        Member m = (Member)PaintballApp.getLoggedUser();
        List<Reservation> res = Reservation.getReservationsNotCancelled(m);

        if (res.size() == 0) {
            view.println("You don't have any reservations made.");
            return;
        }
        view.println("Your reservations: ");
        int i = 1;
        for(Reservation r : res) {
            view.println(i + ") " + r);
            ++i;
        }
        view.println("Please select a reservation to cancel or enter 0 to leave: ");
        int cancelNumber = view.askInt("");
        if (cancelNumber == 0)
            return;
        while (cancelNumber > res.size() || cancelNumber < 0) {
            view.println("This reservation number doesn't exist! ");
            cancelNumber = view.askInt("");
            if (cancelNumber == 0) {
                view.println("Cancell aborted.");
                return;
            }
        }
        Reservation toCancel = res.get(cancelNumber - 1);
        Reservation.cancelReservation(toCancel.getId());
        view.println("The reservation #" + cancelNumber + " has been canceled." );
    }

    public void run(Member m2) {
        view.displayHeader("Cancel a reservation:");

        Member m = m2;
        List<Reservation> res = Reservation.getReservationsNotCancelled(m);

        if (res.size() == 0) {
            view.println("You don't have any reservations made.");
            return;
        }
        view.println("Your reservations: ");
        int i = 1;
        for(Reservation r : res) {
            view.println(i + ") " + r);
            ++i;
        }
        view.println("Please select a reservation to cancel or enter 0 to leave: ");
        int cancelNumber = view.askInt("");
        if (cancelNumber == 0)
            return;
        while (cancelNumber > res.size() || cancelNumber < 0) {
            view.println("This reservation number doesn't exist! ");
            cancelNumber = view.askInt("");
            if (cancelNumber == 0) {
                view.println("Cancell aborted.");
                return;
            }
        }
        Reservation toCancel = res.get(cancelNumber - 1);
        Reservation.cancelReservation(toCancel.getId());
        view.println("The reservation #" + cancelNumber + " has been canceled." );
    }


}
