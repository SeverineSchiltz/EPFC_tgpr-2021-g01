package lycheenoisi.paintball;
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

    public static boolean isLogged() {
        return loggedUser != null;
    }

    public static void logout() {
        setLoggedUser(null);
    }

    public static boolean isAdmin() {
        return loggedUser != null && loggedUser.isAdmin();
    }

    public static void main(String[] args) {
        if (!Model.checkDb())
            new ErrorView("Database is not available").close();
        else
            new StartMenuController().run();
    }

}
