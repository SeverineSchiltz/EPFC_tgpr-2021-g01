package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Employee;

import java.util.List;

public class DisplayEmployeesView extends View {
    public void displayHeader() {
        displayHeader("Employee List");
    }

    public void displayEmployees(List<Employee> employees) {
        int i = 1;
        for (var e : employees) {
            this.println(i + ") " + e);
            ++i;
        }
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[A] Add, [E] Edit, [D] Delete, [L] Leave",
                "[aA]+|[eE][0-9]+|[dD][0-9]+|[lL]");
    }

}
