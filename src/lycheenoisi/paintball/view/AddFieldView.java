package lycheenoisi.paintball.view;

public class AddFieldView extends View{
    public void displayHeader() {
        displayHeader("** Add a new Field **");
    }

    public String askName() {
        return askString("Name : ", null);
    }

    public String askDescription() {
        return askString("Description : ", null);
    }

    public boolean askIsInside() { return askBoolean("Is Inside (true or false) : ", false); }

    public int askLevel() { return askInt("Level : "); }

    public int askMaxPlayers() { return askInt("Max players : "); }

    public int askMinPlayers() { return askInt("Min players : "); }

    public boolean askIsVip()  {
        return askBoolean("Is VIP (true or false) : ", false);
    }

    public double askPrice() { return askDouble("Price : "); }

    public View.Action askForAction() {
        return doAskForAction(-1,
                "\n[O] Confirm, [C] Cancel", "[oO]|[cC]");
    }

    public void displayAdmin() {
        println("Admin: ");
    }
}