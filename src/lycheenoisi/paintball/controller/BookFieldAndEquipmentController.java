package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.*;
import lycheenoisi.paintball.view.BookFieldAndEquipmentView;

import java.time.LocalDate;


public class BookFieldAndEquipmentController extends Controller {
    private final BookFieldAndEquipmentView view = new BookFieldAndEquipmentView();

    @Override
    public void run() {
        User connectedUser = PaintballApp.getLoggedUser();
        String res = null;
        do {
            view.displayHeader();
            LocalDate preferredDate = null;
            boolean hasError = false;

            do {
                preferredDate = view.askDate();
                hasError = !this.isDateValid(preferredDate, connectedUser);
            } while (hasError);

            int timeSlot = 0;
            do {
                timeSlot = view.askTimeslot();
            } while (timeSlot < 1 || timeSlot > 3);
            String fightType = view.askFightType();
            Timeslot ts = null;
            if (timeSlot == 1)
                ts = Timeslot.Morning;
            if (timeSlot == 2)
                ts = Timeslot.Afternoon;
            if (timeSlot == 3)
                ts = Timeslot.Evening;
            var fields = Field.getAvailableFields(preferredDate, ts, fightType);
            view.displayAvailableFields(fields);
            if (fields.isEmpty()) {
                view.println("No field available with the current filters.");
                res = view.askString("[R] Retry, [L] Leave", null);
                continue;
            }
            int idTerrain = view.askInt("Choose a field to book: ");
            Reservation.createReservation(preferredDate, ts, idTerrain, connectedUser.getId(), fightType);
            break;
        } while (!res.equals("L") && !res.equals("l"));
    }

    public boolean isDateValid(LocalDate preferredDate, User connectedUser) {
        if (preferredDate == null) {
            return false;
        }
        if (LocalDate.now().plusDays(1).isAfter(preferredDate)) {
            return false;
        }
        if (connectedUser.getRole() == Role.membervip) {
            return preferredDate.isBefore(LocalDate.now().plusDays(1).plusMonths(3));
        }
       return preferredDate.isBefore(LocalDate.now().plusDays(1).plusWeeks(2));
    }


}
