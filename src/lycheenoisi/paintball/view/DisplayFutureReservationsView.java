package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Reservation;

import java.util.List;

public class DisplayFutureReservationsView extends View {

    public void displayHeader() {
        displayHeader("Future reservations list");
    }

    public void displayReservations(List<Reservation> reservations) {
        if (!reservations.isEmpty() ) {
            int i = 1;
            for (var r : reservations) {
                println(i + ") " + r);
                ++i;
            }
        } else {
            println("There are no future reservations");
        }
    }

    public void displayMenu() {
        println("\n[C] Cancel a reservation");
        println("\n[L] Leave");
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n", "[lL]|[cC][1-9]");
    }

}
