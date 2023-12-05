
/**
 * Name: AUSTIN MOSER (moser)
 * Course: CSCI 241 - Computer Science I
 * Section: 9 <-- choose your section
 * Assignment: 9
 *
 * Project/Class Description:
 * (summarize ClockTime here)
 *
 * Known bugs:
 * (write the word none, or describe)
 */
public class ClockTime
{
    private int hour;
    private int minute;
    private int second;

    // Getter/Setters for hour:
    public void setHour(int hour){
        this.hour = hour;
    }

    public int getHour(){
        return hour;   
    }

    // Getter/Setters for minute:
    public void setMinute(int minute){
        this.minute = minute;
    }

    public int getMinute(){
        return minute;
    }

    // Getter/Setters for second:
    public void setSecond(int second){
        this.second = second;
    }    

    public int getSecond(){
        return second;
    }

    // Default Contstructor for ClockTime:
    public ClockTime(){
        // Sets all class instances to 0.
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    // Construtor with parameters:
    public ClockTime(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;

        if (second > 59){
            // Caculates the seconds to minutes and adds it to minute.
            this.minute += (second / 60);

            // Gets the remaining seconds.
            this.second %= 60;
        }

        // Checks if second is negative. If so then it will equal 0.
        if(second < 0){
            this.second = 0;
        }

        if (minute > 59){
            // Calculates minutes to hours and adds it to hour.
            this.hour += (minute/60);

            // Gets the remaining minutes.
            this.minute %= 60;
        }

        // Checks if minute is negative. If so then it will equal 0.
        if(minute < 0){
            this.minute = 0;
        }

        if(hour > 24){
            // Gets the remaining hours if its over 24.
            this.hour %= 24;
        }
        // Checks if hour is negative. If so then it will equal 0.
        if(hour < 0){
            this.hour = 0;
        }
    }

    public String toString(){
        // Formats hour,minute, and secods to have 2 digits:
        String h = String.format("%02d",this.hour);
        String m = String.format("%02d",this.minute);
        String s = String.format("%02d",this.second);

        return  h+ ":" +m + ":" + s;
    }

    public String toString12(){
        int hHour;
        //if hour is above or equal to 12 then it will be moduled to get the remainder of the next set of 12 hours
        if(hour >= 12){
            hHour= hour % 12;

            // Formats hour,minute, and secods to have 2 digits:
            String h = String.format("%02d",hHour);
            String m = String.format("%02d",this.minute);
            String s = String.format("%02d",this.second);

            return h + ":" + m + ":" + s + " P.M.";
        }

        // Formats hour,minute, and secods to have 2 digits:
        String h = String.format("%02d",this.hour);
        String m = String.format("%02d",this.minute);
        String s = String.format("%02d",this.second);

        return h + ":" + m + ":" + s + " A.M.";
    }

    public void advance(int extraSeconds){
        // Adds the extra seconds to second.
        second += extraSeconds;

        // Takes the total of seconds and divides it by 60 to get the extraMinutes.
        int extraMinutes= second / 60;

        // Mods second to get the remainding seconds.
        second %= 60;

        // Adds the extraMinutes to minute.
        minute += extraMinutes;

        // Takes the total of minute and divides it by 60 to get the extraHours.
        int extraHours = minute / 60;

        // Mods minute to get the remainding minutes.
        minute %= 60;

        // Adds the extraHours to hour.
        hour += extraHours;

        // Mods hour to get the remainding hours.
        hour %= 24;
    }

    public boolean equals(ClockTime obj){
        // set isEquals to false;
        boolean isEquals = false;
        // Tests if current object hour is equal to old object hour, same goes for seconds and minutes.
        if(this.hour == obj.hour){
            if(this.minute == obj.minute){
                if(this.second == obj.second){
                    // if all is true then isEquals is true
                    isEquals = true;
                }
            }
        }
        // else is equals is false;
        return isEquals;
    }
}
 