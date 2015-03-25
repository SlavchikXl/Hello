package com.kogut.recharge.system.logic;

import java.util.Formatter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Slava on 24.03.2015.
 */
public class IdGenerator {
    private static final int INCREMENT_RADIX = 16;
    private static final int TIMESTAMP_RADIX = 36;
    private static final AtomicLong MESSAGE_INCREMENT = new AtomicLong();

    public static String getAlertId() {
        StringBuilder id = new StringBuilder(14);
        Long time = System.currentTimeMillis();
        id.append(Long.toString(time, TIMESTAMP_RADIX).toUpperCase());
        id.append(getFormattedIncrement(MESSAGE_INCREMENT.incrementAndGet()));
        id.append("I0");
        return id.toString();
    }

    private static String getFormattedIncrement(long increment) {
        Formatter formatter = new Formatter();
        formatter.format("%4s", Long.toString(increment & 0xFFFF, INCREMENT_RADIX).toUpperCase());
        String incrementWithSpaces = formatter.toString();
        return incrementWithSpaces.replace(" ", "0");
    }
}
