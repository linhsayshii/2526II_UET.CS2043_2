public class CalDate {
    public static boolean isnearlyOutofDate(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        String[] current = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).split("-");
        int cur_year = Integer.parseInt(current[0]);
        int cur_month = Integer.parseInt(current[1]);
        int cur_day = Integer.parseInt(current[2]);
        
        if (year > cur_year) {
            return false;
        } else if (year == cur_year) {
            if (month > cur_month) {
                return false;
            } else if (month == cur_month) {
                return day - cur_day < 7;
            }
        }
        return false;
    }
}
