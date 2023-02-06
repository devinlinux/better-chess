package gui;

public class Clock {
    
    //  fields
    private int hours;
    private int minutes;
    private int seconds;

    //  constructor
    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    //  outOfTime
    public boolean outOfTime() {
        return this.hours == 0 && this.minutes == 0 && this.seconds == 0;
    }

    //  decrease
    public void decrease() {
        if (this.minutes == 0 && this.seconds == 0) {
            this.seconds = 59;
            this.minutes = 59;
            this.hours--;
        } else if (this.seconds == 0) {
            this.seconds = 59;
            this.minutes--;
        } else this.seconds--;
    }

    //  toString
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds);
    }
}
