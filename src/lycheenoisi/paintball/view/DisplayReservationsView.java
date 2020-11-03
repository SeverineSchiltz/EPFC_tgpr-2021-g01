
package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Reservation;

import java.util.List;

public class DisplayReservationsView extends View {

    public void displayHeader() {
        displayHeader("Reservations List");
    }

    public void displayReservations(List<Reservation> reservations) {
        if (!reservations.isEmpty() ) {
            int i = 1;
            for (var r : reservations) {
                println(i + ") " + r);
                ++i;
            }
        }else{
            println("Pas de réservation");
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[M] MainMenu, [C] Cancel reservation",
                "[mM]+|[cC]");
    }

    public View.Action askForActionNotCancel(int size) {
        return doAskForAction(size, "\n[M] MainMenu",
                "[mM]");
    }

}
