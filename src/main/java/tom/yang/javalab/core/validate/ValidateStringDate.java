package tom.yang.javalab.core.validate;

import java.util.HashSet;
import java.util.Set;

public class ValidateStringDate {
    private static Set<String> dates = new HashSet<String>();

    static {
        for (int year = 1900; year < 2050; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= daysInMonth(year, month); day++) {
                    StringBuilder date = new StringBuilder();
                    date.append(String.format("%04d", year));
                    date.append(String.format("%02d", month));
                    date.append(String.format("%02d", day));
                    dates.add(date.toString());
                }
            }
        }
    }

    public static boolean isValidDate2(String dateString) {
        return dates.contains(dateString);
    }

    private static int daysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            daysInMonth = 31;
            break;
        case 2:
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
            break;
        default:
            daysInMonth = 30;
        }
        return daysInMonth;
    }
}
