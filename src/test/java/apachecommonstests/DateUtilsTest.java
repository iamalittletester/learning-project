package apachecommonstests;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.Test;

import java.util.Date;

public class DateUtilsTest {
    @Test
    public void isSameDay() {
        System.out.println(DateUtils.isSameDay(new Date(System.currentTimeMillis() + 5 * DateUtils.MILLIS_PER_HOUR),
                new Date(System.currentTimeMillis())));
    }

    @Test
    public void addYears() {
        System.out.println(DateUtils.addYears(new Date(System.currentTimeMillis()), 1));
    }

    @Test
    public void addMonths() {
        System.out.println(DateUtils.addMonths(new Date(System.currentTimeMillis()), 10));
    }

    @Test
    public void setDays() {
        System.out.println(DateUtils.setDays(new Date(System.currentTimeMillis()), 1));
    }

    @Test
    public void setMinutes() {
        System.out.println(DateUtils.setMinutes(new Date(System.currentTimeMillis()), 10));
    }
}
