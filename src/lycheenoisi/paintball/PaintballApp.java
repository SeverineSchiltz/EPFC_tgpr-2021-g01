package lycheenoisi.paintball;
import lycheenoisi.paintball.controller.CancelReservationController;
import lycheenoisi.paintball.controller.DisplayReservationsController;
import lycheenoisi.paintball.controller.LoginController;
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

    //test UC_DisplayReservations
    public static void main(String[] args) {
        //new MemberListController().run();
        setLoggedUser(new Member("nvorkap"));
        if (!Model.checkDb())
            new ErrorView("Database is not available").close();
        else
            //new MemberListController().run();
            //new LoginController().run();
        new CancelReservationController().run();
    }

//    //public static void main(String[] args) {
//        System.out.println("Ca compile! :-)");
//    }

}
