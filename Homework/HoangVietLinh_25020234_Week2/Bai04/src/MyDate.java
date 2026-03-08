public class MyDate {
    private int day;
    private int month;
    private int year;
    MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public void getFormattedDate() {
        System.out.println(day + "/" + month + "/" + year);
    }
}
