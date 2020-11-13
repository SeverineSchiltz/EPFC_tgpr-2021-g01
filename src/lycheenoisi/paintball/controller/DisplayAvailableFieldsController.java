package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.model.FightType;
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

                String inputTimeslot=null;
                Timeslot timeslot=null;
                boolean valid = false;
                do {
                    inputTimeslot = view.askTimeslot();
                    if(inputTimeslot!=null){ inputTimeslot = inputTimeslot.substring(0, 1).toUpperCase() + inputTimeslot.substring(1, inputTimeslot.length()).toLowerCase();}
                    for(Timeslot t : Timeslot.values()){
                        if(inputTimeslot!=null && inputTimeslot.equals(t.name())){
                            valid = true;
                        }
                    }
                }while(!valid);
                timeslot=Timeslot.valueOf(inputTimeslot);
                String fightType=null;
                do {
                    fightType = view.askFightType();
                }while(!FightType.isValidFightTypeName(fightType));

                var fields = Field.getAvailableFields(date, timeslot ,fightType);
                view.displayAvailableFields(fields);
                res = view.askForAction(fields.size());
                switch (res.getAction()) {
                    case 'B':
                        new BookFieldAndEquipmentController(PaintballApp.getLoggedUser()).run();
                        break;
                }
            } while (res.getAction() != 'L' && res.getAction() != 'B');
        } catch (View.ActionInterruptedException e) {
        }

    }

}