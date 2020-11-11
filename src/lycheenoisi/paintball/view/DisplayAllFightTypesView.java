package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Field;
import lycheenoisi.paintball.model.FightType;

import java.util.ArrayList;

public class DisplayAllFightTypesView extends View {

    public void displayHeader() { displayHeader("** Fight types **"); }

    public void displayAllFightTypes(ArrayList<FightType> fightTypes) {
        if (!fightTypes.isEmpty() ) {
            int i = 1;
            for (var ft : fightTypes) {
                println(i + ") " + ft.getName()
                        + "\nDescription: " + ft.getDescription() + "\n");
                ++i;
            }
        } else {
            println("There is no fight type in the system");
        }
    }

    public Action askForAction(int size) {
        return doAskForAction(size, "\n[M] MainMenu",
                "[mM]");
    }

}

