package org.foodeezz.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bakhtiar.galib on 3/12/15.
 */
public class DateTimeHelper {

    public static String getCurrentDateTimeString() {
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
    }

    public static String getCurrentNanoTimeString() {
        return System.nanoTime() + "";
    }
}
