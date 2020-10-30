package lycheenoisi.paintball;
import lycheenoisi.paintball.controller.StartMenuController;
import lycheenoisi.paintball.model.Model;
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

    public static void main(String[] args) {
        if (!Model.checkDb())
            new ErrorView("Database is not available").close();
        else
            new StartMenuController().run();
    }

//    //public static void main(String[] args) {
//        System.out.println("Ca compile! :-)");
//    }

}
