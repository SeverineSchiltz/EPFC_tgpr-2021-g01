package lycheenoisi.paintball.view;

import java.util.List;

public class DisplayFieldStatDetailView extends View{
    public void displayHeader() { displayHeader("** Statistics by fight type **"); }

    public void displayFieldStat(List<String> ft) {
        println("Fight type  | NC |  C");
        if (!ft.isEmpty() ) {
            int i = 1;
            for (var f : ft) {
                println(f);
                ++i;
            }
        } else {
            println("No activity available");
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[L] Leave",
                "[lL]");
    }

}
