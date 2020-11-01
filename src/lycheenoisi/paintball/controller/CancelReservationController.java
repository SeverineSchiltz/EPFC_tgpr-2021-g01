package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Reservation;
import lycheenoisi.paintball.view.CancelReservationView;

import java.util.List;

public class CancelReservationController {
    private final CancelReservationView view = new CancelReservationView();

    public void run() {
        Member m = (Member)PaintballApp.getLoggedUser();
        List<Reservation> res = Reservation.getReservationsNotCancelled(m);

        if (res.size() == 0) {
            view.println("Vous n'avez pas de réservations.");
            return;
        }
        view.println("Voici vos réservations: ");
        int i = 1;
        for(Reservation r : res) {
            System.out.println(i + ") " + r);
            ++i;
        }
        view.println("Veuillez séléctionner une réservation à annuler: ");
        int cancelNumber = view.askCancelReservationNumber();
        while (cancelNumber > res.size()) {
            view.println("Numéro de réservation non existant! ");
            cancelNumber = view.askCancelReservationNumber();
        }
        Reservation toCancel = res.get(cancelNumber - 1);
        Reservation.cancelReservation(toCancel.getId());
        view.println("La réservation " + cancelNumber + " a bien été annulée." );
    }


}
