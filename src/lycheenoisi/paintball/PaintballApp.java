package lycheenoisi.paintball;
import lycheenoisi.paintball.controller.DisplayReservationsController;
import lycheenoisi.paintball.controller.LoginController;
import lycheenoisi.paintball.model.Model;
import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.User;
import lycheenoisi.paintball.view.ErrorView;

public class PaintballApp {
    private static User loggedUser;

    public static void setLoggedUser(User loggedUser) {
        PaintballApp.loggedUser = loggedUser;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    //test UC_DisplayReservations
    public static void main(String[] args) {
        //new MemberListController().run();
        if (!Model.checkDb())
            new ErrorView("Database is not available").close();
        else
            //new MemberListController().run();
            new LoginController().run();
    }

//    //public static void main(String[] args) {
//        System.out.println("Ca compile! :-)");
//    }

}
