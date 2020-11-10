package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.model.Timeslot;
import lycheenoisi.paintball.view.DisplayAvailableFieldsView;
import lycheenoisi.paintball.view.View;

import java.time.LocalDate;


public class DisplayAvailableFieldsController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayAvailableFieldsView();
            View.Action res;
            do {
                view.displayHeader();
                LocalDate date = view.askDate();
                var inputTimeslot = view.askTimeslot();
                Timeslot timeslot=null;
                if(inputTimeslot!=null){
                    timeslot=Timeslot.valueOf(inputTimeslot);
                }
                String fightType = view.askFightType();
                var fields = Field.getAvailableFields(date, timeslot ,fightType);
                view.displayAvailableFields(fields);
                res = view.askForAction(fields.size());
                switch (res.getAction()) {
                    case 'B':
                        new BookFieldAndEquipmentController().run();
                        break;
                    case 'M' :
                        new MainMenuEmployeeController().run();
                }
            } while (res.getAction() != 'M');
        } catch (View.ActionInterruptedException e) {
        }

    }

}