package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.model.EquipmentType;
import lycheenoisi.paintball.view.DisplayAllEquipmentsView;
import lycheenoisi.paintball.view.View;


public class DisplayAllEquipmentsController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayAllEquipmentsView();
            View.Action res;
            do {
                view.displayHeader();
                var equipments = EquipmentType.getAllEquipments();
                view.displayAllEquipments(equipments);
                res = view.askForAction(equipments.size());
                switch (res.getAction()) {
                    case 'F':
                        new DisplayAvailableFieldsController().run();
                        break;
                }
            } while (res.getAction() != 'M');
        } catch (View.ActionInterruptedException e) {
        }

    }

}