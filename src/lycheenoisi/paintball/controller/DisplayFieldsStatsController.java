package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.view.DisplayFieldsStatsView;
import lycheenoisi.paintball.view.View;

public class DisplayFieldsStatsController extends Controller{
    @Override
    public void run() {
        try {
            View.Action res;
            do {
                var fields = Field.getAllFieldsStats();
                var view = new DisplayFieldsStatsView();

                view.displayHeader();
                view.displayAllFieldsStat(fields);
                res = view.askForAction(fields.size());
                switch (res.getAction()) {
                    case 'D':

                        break;

                }
            } while (res.getAction() != 'L');
        } catch (View.ActionInterruptedException e) {
        }
    }
}
