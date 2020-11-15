package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Field;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookFieldView extends View {

    public void displayHeader() { displayHeader("** Book a field **"); }
    public LocalDate askDate() { return askDate("Date (dd/mm/yyyy) : ", null); }
    public String askFightType() {return askString("Fight type (President|Battle Royal|Spy|Among us|Hunting|Conquering) : ",null);}
    public int askTimeslot() { return askInt("Timeslot (1:Morning 2:Afternoon 3:Evening)  : ");}

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
        return doAskForAction(size, "\n[M] MainMenu, [B] Book a field",
                "[mM]+|[bB]");
    }
}
