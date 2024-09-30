package com.wo.gmnt.serviceImpl;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Util {

    public String generateId(String latestId, String defaultId) {
        return generateNextValue(latestId, defaultId);
    }

    public String generateCode(String latestId, String defaultCode) {
        return generateNextValue(latestId, defaultCode);
    }

    private String generateNextValue(String latestValue, String defaultValue) {
        if (latestValue == null) {
            return defaultValue;
        }
        String shortValue = extractShort(defaultValue);
        int count = Integer.parseInt(latestValue.substring(3)) + 1;
        return String.format("%s%03d", shortValue, count);
    }

    private String extractShort(String defaultValue) {
        StringBuilder shortString = new StringBuilder();
        for (char c : defaultValue.toCharArray()) {
            if (Character.isLetter(c)) {
                shortString.append(c);
            } else {
                break;
            }
        }
        return shortString.toString();
    }

    public String getDate() {
        return formatDate("yyyy/MM/dd");
    }

    public String getTime() {
        return formatDate("HH:mm:ss");
    }

    private String formatDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

}
