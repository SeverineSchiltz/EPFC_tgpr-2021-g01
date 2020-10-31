package lycheenoisi.paintball;
import lycheenoisi.paintball.controller.CancelReservationController;
import lycheenoisi.paintball.controller.DisplayReservationsController;
import lycheenoisi.paintball.controller.LoginController;
import lycheenoisi.paintball.controller.StartMenuController;
import lycheenoisi.paintball.model.Model;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.view.ErrorView;

public class PaintballApp {
    private static Member loggedUser;

    public static void setLoggedUser(Member loggedUser) {
            PaintballApp.loggedUser = loggedUser;
        }

    public static Member getLoggedUser() {
        return loggedUser;
    }

    public static void main(String[] args) {
        if (!Model.checkDb())
            new ErrorView("Database is not available").close();
        else
            new StartMenuController().run();
    }

//    //test UC_DisplayReservations
//    public static void main(String[] args) {
//        if (!Model.checkDb()) {
//            new ErrorView("Database is not available").close();
//        }else {
//            setLoggedUser(new Member("lmalsag"));
//            new DisplayReservationsController().run();
//        }
//    }

//    //test UC_CancelReservations
//    public static void main(String[] args) {
//        if (!Model.checkDb())
//            new ErrorView("Database is not available").close();
//        else
//            setLoggedUser(new Member("lmalsag"));
//            new CancelReservationController().run();
//    }

//    //public static void main(String[] args) {
//        System.out.println("Ca compile! :-)");
//    }

}
