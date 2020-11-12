package lycheenoisi.paintball.controller;

//import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.model.Employee;
import lycheenoisi.paintball.view.DisplayEmployeesView;
import lycheenoisi.paintball.view.View;

public class DisplayEmployeesController extends Controller {

    @Override
    public void run() {
        try {
            View.Action res;
            do {
                var employees = Employee.getAllEmployees();
                var view = new DisplayEmployeesView();

                view.displayHeader();
                view.displayEmployees(employees);
                res = view.askForAction(employees.size());
                switch (res.getAction()) {
                    case 'A':
                        new AddEmployeeController().run();
                        break;
                    case 'E': // to edit a member's profile
                        Employee empToEdit = employees.get(res.getNumber() - 1);
                        new EditMenuController(empToEdit).run();
                        break;
                    case 'D':
                        Employee e = employees.get(res.getNumber() - 1);
                        Employee.delete(e);
                        break;
                }
            } while (res.getAction() != 'L');
        } catch (View.ActionInterruptedException e) {
        }
    }
}
