package lycheenoisi.paintball.view;

public class MainMenuEmployeeView extends View {
    public void displayHeader() {
        displayHeader("Main menu employee:");
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[M] Display members, [R] Display all reservation, [L] Logout",
                "[vV]+|[fF]+|[lL]");
    }

    public View.Action askForActionAdmin(int size) {
        return doAskForAction(size, "\n[M] Display members, [R] Display all reservation,[E] Display employees, [L] Logout",
                "[vV]+|[fF]+|[eE]+|[lL]");
    }

}