package lycheenoisi.paintball.test;

import lycheenoisi.paintball.controller.*;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Model;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.ErrorView;
import org.junit.Test;

import static lycheenoisi.paintball.PaintballApp.setLoggedUser;
import static lycheenoisi.paintball.model.User.getByUsername;

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

    @Test
    public void test_UC_DisplayReservationsController(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            User user = getByUsername("sschilt");
            setLoggedUser(user); //member
            //setLoggedUser(getByUsername("cjadot")); //member vip
            new DisplayReservationsController().run();
        }
    }

    @Test
    public void test_UC_DisplayAvailableFieldsController(){     /* LEYLA TEST */
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            User user = getByUsername("lmalsag");
            setLoggedUser(user);
            new DisplayAvailableFieldsController().run();
        }
    }

    @Test
    public void test_UC_EditProfile(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            User user = getByUsername("sschilt"); //member
            //User user = getByUsername("cjadot"); //member vip
            User userEmp = getByUsername("nvorkap"); //employee
            setLoggedUser(userEmp);
            new EditMenuController(user).run();
        }
    }

    @Test
    public void test_UC_AddMember(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            User user = getByUsername("lmalsag"); //admin
            //User user = getByUsername("nvorkap"); //employee
            setLoggedUser(user);
            new AddMemberController().run();
        }
    }

    @Test
    public void test_UC_DisplayMemberController(){
        if (!Model.checkDb()) {
            new ErrorView("Database is not available").close();
        }else {
            User user = getByUsername("lmalsag"); // admin
            setLoggedUser(user);
            new DisplayMembersController().run();
        }
    }


}