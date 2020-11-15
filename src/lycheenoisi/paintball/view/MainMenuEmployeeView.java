package lycheenoisi.paintball.view;

public class MainMenuEmployeeView extends View {
    public void displayHeader() {
        displayHeader("Main menu employee:");
    }

    public View.Action askForAction(int size) {

        return doAskForAction(size, "\n[M] Display members, \n[R] Display future reservations, \n[A] Display Fields, \n[S] Display Stat by field, \n[F] Display fight types, \n[Q] Display Equipments, \n[N] Add New Field, \n[L] Logout",
                "[mM]+|[rR]+|[aA]+|[lL]+|[sS]+|[fF]+|[qQ]+|[nN]");
    }

    public View.Action askForActionAdmin(int size) {
        return doAskForAction(size, "\n[M] Display members, \n[R] Display future reservations, \n[A] Display Fields, \n[E] Display employees, \n[S] Display Stat by field, \n[F] Display fight types, \n[Q] Display Equipments, \n[N] Add New Field,  \n[L] Logout",
                "[mM]+|[rR]+|[aA]+|[eE]+|[lL]+|[sS]+|[fF]+|[qQ]+|[nN]");

    }

}