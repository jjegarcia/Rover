package TDD_week3;

import TDD_week3.DateProvider;

public class Reminder {
    private final String date;
    private String time;

    public Reminder(DateProvider dateProvider) {
        date= dateProvider.getTodaysDate();
        time=dateProvider.getTime();
    }

    public String getDate() {
        return  date;
    }

    public String getTime() {
        return time;
    }
}
