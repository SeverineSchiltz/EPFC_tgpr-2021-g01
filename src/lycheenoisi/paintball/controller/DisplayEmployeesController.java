package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.PaintballApp;
import lycheenoisi.paintball.view.DisplayEmployeesView;
import lycheenoisi.paintball.view.View;

public class DisplayEmployeesController extends Controller {

    @Override
    public void run() {
//        try {
//            View.Action res;
//            do {
//                var employees = Employee.getAll();
//                var view = new DisplayEmployeesView();
//
//                view.displayHeader();
//                view.displayEmployees(employees);
//                res = view.askForAction(employees.size());
//                switch (res.getAction()) {
//                    case 'A':
//                        new AddEmployeeController().run();
//                        break;
//                    case 'D':
//                        Employee.delete(res.getNumber() - 1);
//                        break;
//                }
//            } while (res.getAction() != 'L');
//        } catch (View.ActionInterruptedException e) {
//        }
    }
}
