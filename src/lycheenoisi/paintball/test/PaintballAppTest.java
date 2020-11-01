package lycheenoisi.paintball.test;

import lycheenoisi.paintball.controller.CancelReservationController;
import lycheenoisi.paintball.controller.DisplayReservationsController;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Model;
import lycheenoisi.paintball.view.ErrorView;
import org.junit.Test;

import static lycheenoisi.paintball.PaintballApp.setLoggedUser;
import static org.junit.Assert.*;

public class PaintballAppTest {

    @Test //plus utilisé:
    public void test_UC_DisplayReservations(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            setLoggedUser(new Member("sschilt"));
            new DisplayReservationsController().run();
        }
    }

    @Test
    public void test_UC_CancelReservations(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            setLoggedUser(new Member("lmalsag"));
            new CancelReservationController().run();
        }
    }


}