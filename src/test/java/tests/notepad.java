package tests;

public class notepad {
    public static void main(String[] args) {
        System.out.println(weekday2(50));

    }
    public static String weekday2(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> throw new IllegalStateException("Unexpected value: " + day);
        };
    }
}
