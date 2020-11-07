package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Field;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookFieldAndEquipmentView extends View {

    public void displayHeader() { displayHeader("** Available fields **"); }
    public LocalDate askDate() { return askDate("Date (dd/mm/yyyy) : ", null); }
    public String askFightType() {return askString("Fight type : ",null);}
    public int askTimeslot() { return askInt("Timeslot (1. Matin , 2. Aprem , 3. Soir.)  : ");}

    public void displayAvailableFields(ArrayList<Field> fields) {
        if (!fields.isEmpty() ) {
            int i = 1;
            for (var f : fields) {
                println(i + ") " +"Name : "+f.getName()+"| Min players : "+f.getMinPlayers()+"| Max players : "+f.getMaxPlayers()+"| Price : "+f.getPrice());
                ++i;
            }
        } else {
            println("Aucun terrain n'est disponible");
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[M] MainMenu, [B] Book a field",
                "[mM]+|[bB]");
    }
}
