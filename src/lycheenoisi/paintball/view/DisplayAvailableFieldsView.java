package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Field;

import java.time.LocalDate;
import java.util.ArrayList;

public class DisplayAvailableFieldsView extends View {

    public void displayHeader() { displayHeader("** Available fields **"); }
    public LocalDate askDate() { return askDate("Date (dd/mm/yyyy) : ", null); }
    public String askFightType() {return askString("Fight type (President|Battle Royal|Spy|Among us|Hunting|Conquering) : ",null);}
    public String askTimeslot() { return askString("Timeslot (Morning|Afternoon|Evening)  : ",null);}

    public void displayAvailableFields(ArrayList<Field> fields) {
        if (!fields.isEmpty() ) {
            int i = 1;
            for (var f : fields) {
                println(i + ") " +"Name : "+f.getName()+"| Min players : "+f.getMinPlayers()+"| Max players : "+f.getMaxPlayers()+"| Price : "+f.getPrice());
                ++i;
            }
        } else {
            println("No field available");
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[L] Leave, [B] Book a field",
                "[lL]+|[bB]");
    }

}
