package lycheenoisi.paintball.view;

public class StartMenuView extends View {

    public void displayHeader() {
        displayHeader("Start Menu");
    }

    public void displayMenu() {
        println(" [L] Login");
        println("\n[S] SignUp");
        println("\n[Q] Quit");
    }

    public Action askForAction() {
        return doAskForAction(-1, "", " [lL]|[sS]|[qQ]");
    }
}
