package com.fyiernzy.simplegrep.validator.option;

import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ColorOptionArgValidator implements OptionArgValidator {

    private static final Set<String> SUPPORTED_COLOR = new HashSet<>();
    
    static {
        SUPPORTED_COLOR.addAll(List.of("red", "blue", "green", "yellow"));
    }
    @Override
    public void validate(@NotNull String arg, @Nullable String possibleValue) {
        Validate.notNull(arg, "Argument cannot be null");
        Validate.notBlank(arg, "Argument cannot be blank");
        Validate.notNull(possibleValue, "Color value cannot be blank");
        Validate.notBlank(possibleValue, "Color value cannot be blank");
        Validate.isTrue(SUPPORTED_COLOR.contains(possibleValue));
    }

    public static void main(String[] args) {
        // LocalDate instances
        LocalDate newDate = LocalDate.of(2024, 12, 13);
        LocalDate oldDate = null;

        // Convert LocalDate to Date
        Date newDateConverted = convertLocalDateToDate(newDate);
        Date oldDateConverted = oldDate != null ? convertLocalDateToDate(oldDate) : null;

        System.out.println("Converted newDate: " + newDateConverted);
        System.out.println("Converted oldDate: " + oldDateConverted);
    
        if(newDateConverted.before(oldDateConverted)) {
            System.out.println("newDate is before oldDate");
        }
    }

    public static Date convertLocalDateToDate(LocalDate localDate) {
        // Convert LocalDate to LocalDateTime (midnight of the given date)
        LocalDateTime localDateTime = localDate.atStartOfDay();
        // Convert LocalDateTime to Date
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
