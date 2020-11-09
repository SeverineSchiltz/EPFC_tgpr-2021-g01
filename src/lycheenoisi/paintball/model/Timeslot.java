package lycheenoisi.paintball.model;


public enum Timeslot {
    Morning(1, "Morning",9,12, "am"),
    Afternoon(2, "Afternoon",1, 4, "pm"),
    Evening(3, "Evening",4,7, "pm") ;

    private final int id;
    private final String nomDB;
    private int startTime ;
    private int endTime ;
    private String meridiem ;

    private Timeslot(int id, String nomDB, int startTime, int endTime, String m) {
        this.id = id;
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

    public int getId() { return id; }
}
