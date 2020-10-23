package lycheenoisi.paintball.model;


public enum Timeslot {
    Morning(9,12), Aftenoon(14, 17), Evening(19,21) ;

    private int startTime ;
    private int endTime ;

    private Timeslot(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
