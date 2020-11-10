package lycheenoisi.paintball.view;

public class CancelReservationView extends View{

    public int askCancelReservationNumber() {
        String answer = askString("Reservation number: ", null);
        return Integer.parseInt(answer);
    }

    public void displayHeader(String title) {
        super.displayHeader(title);
    }

}
