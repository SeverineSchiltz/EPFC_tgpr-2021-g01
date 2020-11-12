package lycheenoisi.paintball.view;

import java.util.List;

public class DisplayFieldsStatsView extends View{

    public void displayHeader() { displayHeader("** Statistics by field **"); }

    public void displayAllFieldsStat(List<String> fields) {
        println("   Field       | NC |  C");
        if (!fields.isEmpty() ) {
            int i = 1;
            for (var f : fields) {
                println(i + ") " + f);
                ++i;
            }
        } else {
            println("No activity available");
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[D] Detail, [L] Leave",
                "|[dD][0-9]+|[lL]");
    }

}
