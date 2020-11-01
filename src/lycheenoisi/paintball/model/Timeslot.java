package lycheenoisi.paintball.model;


public enum Timeslot {
    Morning("Morning",9,12, "am"), Afternoon("Afternoon",2, 4, "pm"), Evening("Evening",7,9, "pm") ;

    private final String nomDB;
    private int startTime ;
    private int endTime ;
    private String meridiem ;

    private Timeslot(String nomDB, int startTime, int endTime, String m) {
        this.nomDB = nomDB;
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

    public String getNomDB() {
        return this.nomDB;
    }
}
