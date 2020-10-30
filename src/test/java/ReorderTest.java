import TDD_week3.DateProvider;
import TDD_week3.Reminder;
import org.junit.Test;
import static org.junit.Assert.*;


public class ReorderTest {
    @Test
    public void ReminderHasTodaysDate(){
        DateProvider dateProvider= new DateProvider() {
            @Override
            public String getTodaysDate(){
                return "20/7/1999";
            }

            @Override
            public String getTime() {
                return null;
            }
        };
        Reminder reminder= new Reminder(dateProvider);


        assertEquals("20/7/1999",reminder.getDate());
    }
    @Test
    public void ReminderHasNowTime(){


        DateProvider dateProvider= new DateProvider() {
            @Override
            public String getTodaysDate() {
                return null;
            }

            @Override
            public String getTime(){
                return "10:30";
            }
        };
        Reminder reminder=new Reminder(dateProvider);
        assertEquals("10:30",reminder.getTime());


    }
}
