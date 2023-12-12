package Classes;

public class Date implements Comparable<Date>{
    private int year, month, day;
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int compareTo(Date d) {
        if(year != d.year)
            return year - d.year;
        if(month != d.month)
            return month - d.month;
        return day - d.day;
    }

    public boolean isValid() {
        if(month > 12 | month < 1 | day < 0 | day > 31)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return year + " " + month + " " + day;
    }
}