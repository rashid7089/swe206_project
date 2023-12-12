package Classes;

public class Date implements Comparable<Date>{
    private int year, month, day, hour;
    public Date(int year, int month, int day, int hour) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }

    public int compareTo(Date d) {
        if(year != d.year)
            return year - d.year;
        if(month != d.month)
            return month - d.month;
        if(day != d.day)
            return day - d.day;
        return hour - d.hour;
    }

    public boolean isValid() {
        if(month > 12 | month < 1 | day < 0 | day > 31 | hour < 0 | hour > 23)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return year + " " + month + " " + day + " " + hour;
    }
}