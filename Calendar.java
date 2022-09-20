import java.sql.SQLOutput;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        // Get date from user
        Scanner getDate = new Scanner(System.in);
        System.out.println("Please provide a starting date for your calender. Format DD-MM-YYYY");
        // How can I tell the format is not correct? Regex?
        // How do I tell if numbers are correct? It's too late to check them once we check for the month's length
        // Option: Let user enter day, month and year separately
        String startingDate = getDate.next();
        System.out.println(startingDate);
        int startDay = Integer.parseInt(startingDate.substring(0, 2));
        int startMonth = Integer.parseInt(startingDate.substring(3, 5));
        int startYear = Integer.parseInt(startingDate.substring(6));

        // Check for leap year
        boolean isLeapYear = false;
        int monthLength = 0;
        if (startYear % 4 == 0 &&
            startYear % 100 != 0 &&
            startYear % 400 == 0
        ) {
            isLeapYear = true;
        }

        // Determine month length
        switch (startMonth) {
            case 1, 3, 5, 7, 8, 10, 12:
                monthLength = 31;
                break;
            case 4, 6, 9, 11:
                monthLength = 30;
                break;
            case 2:
                if (isLeapYear) {
                    monthLength = 29;
                } else {
                    monthLength = 28;
                }
            break;
            default:
                System.out.println("Month unknown.");
        }

        String calendar = createCalendar(startDay, startMonth, startYear, monthLength);
        System.out.println(calendar);
    }

    // Create calender
    // Why do the parameters have to have the same name as the arguments?? The variable names cannot be identified otherwise.
    static String createCalendar(int startDay, int startMonth, int startYear, int monthLength) {
        // get day of the week of given `startDay`:
        LocalDate date = LocalDate.of(startYear, startMonth, startDay);
        // How to get number instead of String?
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekValue = dayOfWeek.getValue();
        String dayOfWeekName = dayOfWeek.name();
        dayOfWeekName = dayOfWeekName.charAt(0) + dayOfWeekName.substring(1, 3).toLowerCase();
//        String weekDay = date.getDayOfWeek().toString().substring(0, 3);
//        weekDay = weekDay.charAt(0) + weekDay.substring(1).toLowerCase();
        System.out.println("day of week name: " + dayOfWeekName);

        String calendar = "";
        // Days row:
        String[] weekDays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int i = 0;
        while (i < weekDays.length) {
            calendar += weekDays[i] + "  ";
            i++;
        }
        calendar += "\n";


        // Print days in calendar:
        // Get day of week as number `weekDayNum` from 1 to 7: int dayOfWeekValue; String dayOfWeekName
        // first row:
        // print weekDayNum - 1 empty spaces
        for (int j = 0; j < (dayOfWeekValue - 1); j++) {
            calendar += "  ";
            // days from starting day are missing
        }

        // 7 - (weekDayNum + 1) times:
            // print date (number), starting from startDay
            // print \n
        for (int j = startDay; j < (7 - dayOfWeekValue + 1); j++) {
            calendar += "" + startDay + "  ";
        }
        calendar += "\n";
        // following rows:
        //
        // first row, starting
        for (int k = 1; k <= monthLength; k++) {
            // Add line break after 7 days
            if (k % 7 == 0) {
                calendar += k + "\n";
            } else {
                calendar += k + "   ";
            }
        }

        return calendar;
    }

}
