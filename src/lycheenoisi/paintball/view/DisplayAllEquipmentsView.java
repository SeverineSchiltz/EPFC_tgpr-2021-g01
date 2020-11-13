package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.EquipmentType;

import java.util.ArrayList;

public class DisplayAllEquipmentsView extends View {

    public void displayHeader() { displayHeader("** Equipments **"); }
    public void displayAllEquipments(ArrayList<EquipmentType> equipments) {
        if (!equipments.isEmpty() ) {
            int i = 1;
            for (var e : equipments) {
                println(i + ") " +"Name : "+e.getName()+"| To rent : "+e.getRent_price()+" € | To sell : "+e.getRent_price()+" €");
                ++i;
            }
        } else {
            println("There is no equipment in the system");
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[M] MainMenu, [F] Available Fields",
                "[mM]+|[fF]");
    }

}

