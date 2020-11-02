package lycheenoisi.paintball.view;

public class MainMenuEmployeeView extends View {
    public void displayHeader() {
        displayHeader("Main menu employee:");
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[M] Display members, [R] Display all reservations, [L] Logout",
                "[mM]+|[rR]+|[lL]");
    }

    public View.Action askForActionAdmin(int size) {
        return doAskForAction(size, "\n[M] Display members, [R] Display all reservations,[E] Display employees, [L] Logout",
                "[mM]+|[rR]+|[eE]+|[lL]");
    }

}