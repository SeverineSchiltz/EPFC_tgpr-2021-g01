package lycheenoisi.paintball.view;

import java.time.LocalDate;

public class BookFieldAndEquipmentView extends View {

    public LocalDate askDate(String prompt) {
        return super.askDate(prompt, null);
    }
}
