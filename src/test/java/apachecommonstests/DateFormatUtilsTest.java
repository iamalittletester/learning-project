package apachecommonstests;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.annotations.Test;

import java.util.TimeZone;

public class DateFormatUtilsTest {
    @Test
    public void formatUTC() {
        System.out.println(DateFormatUtils.formatUTC(System.currentTimeMillis(), "yyyy-MM-dd hh:mm"));
    }

    @Test
    public void formatTimezone() {
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm", TimeZone
                .getTimeZone("America/Detroit")));
    }

    @Test
    public void formatTimezone2() {
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm", TimeZone
                .getTimeZone("Europe/Tallinn")));
    }

    @Test
    public void formatTimezone3() {
        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm", TimeZone
                .getTimeZone("Asia/Singapore")));
    }
}
