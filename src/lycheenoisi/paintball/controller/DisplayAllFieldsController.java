package lycheenoisi.paintball.controller;
import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.view.DisplayAllFieldsView;
import lycheenoisi.paintball.view.View;


public class DisplayAllFieldsController extends Controller {

    @Override
    public void run() {
        try {
            var view = new DisplayAllFieldsView();
            View.Action res;
            do {
                view.displayHeader();
                var fields = Field.getAllFields();
                view.displayAllFields(fields);
                res = view.askForAction(fields.size());

            } while (res.getAction() != 'M');
        } catch (View.ActionInterruptedException e) {
        }

    }

}