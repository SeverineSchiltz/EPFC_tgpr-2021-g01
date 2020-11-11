package lycheenoisi.paintball.view;

import lycheenoisi.paintball.model.Member;

import java.util.List;

public class DisplayMembersView extends View {

    public void displayHeader() {
        displayHeader("Members list");
    }

    public void displayMembers(List<Member> members) {
        int i = 1;
        for (var e : members) {
            this.println(i + ") " + e);
            ++i;
        }
    }

    public void displayMenu() {
        println("\n[E] Edit profile");
        println("\n[A] Add member");
        println("\n[D] Delete member");
        println("\n[F] Display all fields");
        println("\n[L] Leave");
    }

    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n", "[aAfFlL]|[eE][1-9]|[dD][1-9]");
    }

/*    public View.Action askForAction(int size) {
        return doAskForAction(size, "\n[E] EditProfile, [A] AddMember, [D] DeleteMember, " +
                        "[B] Book, [L] Leave",
                "[lLeEaAdDbBlL]");
    }*/

}
