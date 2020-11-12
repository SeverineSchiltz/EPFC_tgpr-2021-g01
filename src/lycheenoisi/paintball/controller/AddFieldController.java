package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.view.AddFieldView;
import lycheenoisi.paintball.view.View;
import java.util.List;


public class AddFieldController extends Controller{
    private final AddFieldView view = new AddFieldView();

    public void run() {
        View.Action res;
        List<String> errors;
        Field newField = new Field();
        try {
            do {
                view.displayHeader();
                String name = view.askName();
                String description = view.askDescription();
                boolean is_inside = view.askIsInside();
                int level = view.askLevel();
                int maxPlayers = view.askMaxPlayers();
                int minPlayers = view.askMinPlayers();
                boolean vip = view.askIsVip();
                double price = view.askPrice();

                newField.setName(name);
                newField.setDescription(description);
                newField.setIs_inside(is_inside);
                newField.setLevel(level);
                newField.setMaxPlayers(maxPlayers);
                newField.setMinPlayers(minPlayers);
                newField.setVip(vip);
                newField.setPrice(price);

                errors = newField.validate();
                if (errors.size() > 0)
                    view.showErrors(errors);

            } while (errors.size() > 0);

            res = view.askForAction();
            if (res.getAction() == 'O') {
                newField.save();
            }
        } catch (View.ActionInterruptedException e) {
            view.pausedWarning("Add field aborted");
        }
    }

}
