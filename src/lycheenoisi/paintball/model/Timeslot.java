package lycheenoisi.paintball.model;


public enum Timeslot {
    Morning(9,12, "am"), Afternoon(2, 4, "pm"), Evening(7,9, "pm") ;

    private int startTime ;
    private int endTime ;
    private String meridiem ;

    private Timeslot(int startTime, int endTime, String m) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.meridiem = m;
    }

    public String toString(){
        return " from " + this.getStartTime() + this.meridiem + " to " + this.getEndTime() + "pm";
    }
    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
