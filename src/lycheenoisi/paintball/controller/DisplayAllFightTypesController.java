package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.model.FightType;
import lycheenoisi.paintball.view.DisplayAllFieldsView;
import lycheenoisi.paintball.view.DisplayAllFightTypesView;
import lycheenoisi.paintball.view.View;


public class DisplayAllFightTypesController extends Controller {

    @Override
    public void run() {
        var view = new DisplayAllFightTypesView();
        try {
            View.Action res;
            view.displayHeader();
            var fightTypes = FightType.getAllFightTypes();
            view.displayAllFightTypes(fightTypes);
            res = view.askForAction(fightTypes.size());
            switch (res.getAction()) {
                case 'L':
                    PaintballApp.logout();
                    view.pausedWarning("logged out");
                    new StartMenuController().run();
                    break;
            }
        } catch (View.ActionInterruptedException e) {
        }

    }

}