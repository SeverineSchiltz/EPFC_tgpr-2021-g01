package lycheenoisi.paintball.controller;

import lycheenoisi.paintball.model.Member;
import lycheenoisi.paintball.model.Reservation;

public class DisplayReservationsController {

    public void run() {
        Member m = new Member("lmalsag");
        for(Reservation r : Reservation.getReservationsNotCancelled(m))
            System.out.println(r);
    }

}
