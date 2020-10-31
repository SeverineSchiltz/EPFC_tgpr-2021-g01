//Classe obsolète: à supprimer
package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Reservation;

import java.util.List;

public class DisplayReservationsView extends View {


    public void displayHeader() {
//        clear();
//        println("\n=== Member List ===\n");
        displayHeader("Reservations List");
    }

    public void displayReservations(List<Reservation> reservations) {
//        for (var m : members)
//            //System.out.println(m);
//            println(m);
        int i = 1;
        for (var r : reservations) {
            println(i + ") " + r);
            ++i;
        }
    }

    //    public View.Action askForAction(int size) {
//        return doAskForAction(size, "\n[V] View, [L] Leave",
//                "[vV][0-9]+|[lL]");
//    }
    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[M] MainMenu, [C] Cancel reservation",
                "[mM]+|[cC][0-9]");
    }


//
//    public View.Action askForActionAdmin() {
//        return doAskForAction(-1, "\n[U] Update, [L] Leave", "[uU]|[lL]");
//    }
}
