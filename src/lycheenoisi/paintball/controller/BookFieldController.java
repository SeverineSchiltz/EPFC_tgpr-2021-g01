package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.model.*;
import lycheenoisi.paintball.view.BookFieldView;
import lycheenoisi.paintball.view.View;

import java.time.LocalDate;


public class BookFieldController extends Controller {
    private final BookFieldView view = new BookFieldView();
    private final User user;


    public BookFieldController(User user) {this.user = user;}

    @Override
    public void run() {
        String res = null;
        try {
            do {
                view.displayHeader();
                LocalDate preferredDate = null;
                String hasError;

                do {
                    preferredDate = view.askDate();
                    hasError = this.isDateValid(preferredDate, user);
                    if (hasError != null){
                        view.println(hasError);
                    }
                } while (hasError != null);

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
                Reservation.createReservation(preferredDate, ts, idTerrain, user.getId(), fightType);
                break;
            } while (!res.equals("L") && !res.equals("l"));
        } catch (View.ActionInterruptedException e) {
        }
    }

    public String isDateValid(LocalDate preferredDate, User connectedUser) {
        if (preferredDate == null) {
            return "Enter a date";
        }
        if (LocalDate.now().plusDays(1).isAfter(preferredDate)) {
            return "cannot book in past";
        }
        if (connectedUser.getRole() == Role.membervip) {
            return preferredDate.isBefore(LocalDate.now().plusDays(1).plusMonths(3))?null:"Date too far (3 months max)";
        }
        return preferredDate.isBefore(LocalDate.now().plusDays(1).plusWeeks(2))?null:"Date too far (2 weeks max)";
    }


}
