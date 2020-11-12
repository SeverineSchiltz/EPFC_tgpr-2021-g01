package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.view.DisplayFieldStatDetailView;
import lycheenoisi.paintball.view.View;

public class DisplayFieldStatDetailController extends Controller{
    private final int id;

    public DisplayFieldStatDetailController(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            View.Action res;
            do {
                var ft = Field.getFieldStats(id);
                var view = new DisplayFieldStatDetailView();

                view.displayHeader();
                view.displayFieldStat(ft);
                res = view.askForAction(ft.size());
            } while (res.getAction() != 'L');
        } catch (View.ActionInterruptedException e) {
        }
    }
}
