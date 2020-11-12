package lycheenoisi.paintball.view;

public class MainMenuEmployeeView extends View {
    public void displayHeader() {
        displayHeader("Main menu employee:");
    }

    public View.Action askForAction(int size) {

        return doAskForAction(size, "\n[M] Display members, [R] Display future reservations, [A] Display Fields, [S] Display Stat by field, [F] Display fight types, [L] Logout",
                "[mM]+|[rR]+|[aA]+|[lL]+|[sS]+|[fF]");

    }

    public View.Action askForActionAdmin(int size) {
        return doAskForAction(size, "\n[M] Display members, [R] Display future reservations, [A] Display Fields, [E] Display employees, [S] Display Stat by field, [F] Display fight types, [L] Logout",
                "[mM]+|[rR]+|[aA]+|[eE]+|[lL]+|[sS]+|[fF]");
    }

}