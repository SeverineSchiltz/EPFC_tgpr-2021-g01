package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Field;

import java.util.ArrayList;

public class StatByFieldView extends View{

    public void displayHeader() { displayHeader("** Statistics by field **"); }

    public void displayAvailableFields(ArrayList<Field> fields) {
        if (!fields.isEmpty() ) {
            int i = 1;
            for (var f : fields) {
                println(i + ") " +"Name : "+"| Total : ");//add getname and getvalue
                ++i;
            }
        } else {
            println("No activity available");
        }
    }


}
