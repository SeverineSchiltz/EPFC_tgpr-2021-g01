package lycheenoisi.paintball.view;

public class CancelReservationView extends View{

    public int askCancelReservationNumber() {
        String answer = askString("Numéro de réservation: ", null);
        return Integer.parseInt(answer);
    }

}
