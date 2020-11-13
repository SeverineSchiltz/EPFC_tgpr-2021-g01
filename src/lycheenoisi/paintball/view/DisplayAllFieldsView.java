package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Field;

import java.util.ArrayList;

public class DisplayAllFieldsView extends View {

    public void displayHeader() { displayHeader("** Fields **"); }
    public void displayAllFields(ArrayList<Field> fields) {
        if (!fields.isEmpty() ) {
            int i = 1;
            for (var f : fields) {
                println(i + ") " +"Name : "+f.getName()+"| Min players : "+f.getMinPlayers()+"| Max players : "+f.getMaxPlayers()+"| Price : "+f.getPrice());
                ++i;
            }
        } else {
            println("There is no field in the system");
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[M] MainMenu",
                "[mM]");
    }

}