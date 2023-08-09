package dev.lpa;

import java.util.*;

public class Main {

    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {

        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(WeekDay.MONDAY, WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));

        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName());
//        RegularEnumSet
//        → EnumSet is an abstract class. Once implemented, the actual class is RegularEnumSet.

        annsDaysSet.forEach(System.out::println);
//        MONDAY
//        TUESDAY
//        THURSDAY
//        FRIDAY

        var allDaySet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(15));
        allDaySet.forEach(System.out::println);
//        SUNDAY
//        MONDAY
//        TUESDAY
//        WEDNESDAY
//        THURSDAY
//        FRIDAY
//        SATURDAY

        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        System.out.println("-".repeat(10));
        newPersonDays.forEach(System.out::println);
//        SUNDAY
//        WEDNESDAY
//        SATURDAY

        Set<WeekDay> anotherWay = EnumSet.copyOf(allDaySet);
        anotherWay.removeAll(annsDaysSet);
        System.out.println("-".repeat(11));
        anotherWay.forEach(System.out::println);
//        SUNDAY
//        WEDNESDAY
//        SATURDAY

        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("-".repeat(3));
        businessDays.forEach(System.out::println);
//        MONDAY
//        TUESDAY
//        WEDNESDAY
//        THURSDAY
//        FRIDAY

        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Mary", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[]{"Mary", "Bob"});
        employeeMap.forEach(
                (k, v) -> System.out.println(k + " : " + Arrays.toString(v)));
//        MONDAY : [Mary, Bob]
//        FRIDAY : [Ann, Mary, Bob]
    }
}
