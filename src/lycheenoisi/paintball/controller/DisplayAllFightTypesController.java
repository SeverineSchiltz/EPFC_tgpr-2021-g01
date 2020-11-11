package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.model.FightType;
import lycheenoisi.paintball.view.DisplayAllFieldsView;
import lycheenoisi.paintball.view.DisplayAllFightTypesView;
import lycheenoisi.paintball.view.View;


public class DisplayAllFightTypesController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayAllFightTypesView();
            View.Action res;
            do {
                view.displayHeader();
                var fightTypes = FightType.getAllFightTypes();
                view.displayAllFightTypes(fightTypes);
                res = view.askForAction(fightTypes.size());
                switch (res.getAction()) {
                    case 'M':
                        new MainMenuEmployeeController().run();
                        break;
                }
            } while (res.getAction() != 'M');
        } catch (View.ActionInterruptedException e) {
        }

    }

}