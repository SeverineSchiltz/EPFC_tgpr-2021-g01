package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Role;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.BookFieldAndEquipmentView;
import lycheenoisi.paintball.view.CancelReservationView;

import java.time.LocalDate;


public class BookFieldAndEquipmentController extends Controller {
    private final BookFieldAndEquipmentView view= new BookFieldAndEquipmentView();

    @Override
    public void run() {
        User connectedUser = PaintballApp.getLoggedUser();
        LocalDate dateSouhaitee = null;
        boolean hasError = false;

        do {
            dateSouhaitee = view.askDate("Veuillez entrer une date.");
            hasError = !this.dateValide(dateSouhaitee, connectedUser);
        } while (hasError);

        int timeSlot = 0;
        do {
            timeSlot = view.askInt("Veuillez entrer un moment de la journée: 1. Matin , 2. Aprem , 3. Soir.");
        } while (timeSlot < 1 || timeSlot > 3);
    }

    public boolean dateValide(LocalDate dateSouhaitee, User connectedUser) {
        if (dateSouhaitee == null) {
            return false;
        }
        if (LocalDate.now().plusDays(1).isAfter(dateSouhaitee)) {
            return false;
        }
        if (connectedUser.getRole() == Role.membervip) {
            return dateSouhaitee.isBefore(LocalDate.now().plusDays(1).plusMonths(3));
        }
       return dateSouhaitee.isBefore(LocalDate.now().plusDays(1).plusWeeks(2));
    }


}
