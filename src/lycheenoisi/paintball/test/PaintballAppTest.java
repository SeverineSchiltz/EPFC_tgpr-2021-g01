package lycheenoisi.paintball.test;

import lycheenoisi.paintball.controller.CancelReservationController;
import lycheenoisi.paintball.controller.MainMenuEmployeeController;
import lycheenoisi.paintball.model.Employee;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Model;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.ErrorView;
import org.junit.Test;

import static lycheenoisi.paintball.PaintballApp.setLoggedUser;
import static lycheenoisi.paintball.model.User.getByUsername;
import static org.junit.Assert.*;

public class PaintballAppTest {
    

    @Test
    public void test_UC_CancelReservations(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            setLoggedUser(new Member("lmalsag"));
            new CancelReservationController().run();
        }
    }

    @Test
    public void test_UC_MainMenuEmployee(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            setLoggedUser(getByUsername("lmalsag")); //admin
            //setLoggedUser(getByUsername("nvorkap")); //employee
            new MainMenuEmployeeController().run();
        }
    }


}