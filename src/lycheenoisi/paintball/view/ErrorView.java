package lycheenoisi.paintball.view;

public class ErrorView extends View {
    public ErrorView(String error) {
        displayHeader();
        pausedError(error);
    }

    private void displayHeader() {
        println("\n=== Error ===\n");
    }
}
