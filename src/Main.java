import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        checkLeapYear(2022);
        getDeviceLink(0, 2004);
        int deliveryDays = calculateDeliveryDays(55);
        System.out.println("Потребуется дней: " + deliveryDays);

    }
    public static void checkLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(year + " - високосный год");
        } else {
            System.out.println(year + " - невисокосный год");
        }
    }
    public static void getDeviceLink(int osType, int manufacturingYear) {
        if(osType != 1 && osType != 0) {
            throw new IllegalArgumentException("Неправильный тип ОС");
        }
        int currentYear = LocalDate.now().getYear();
        if (manufacturingYear > currentYear) {
            throw new IllegalArgumentException("Неправильный год производства");
        }
        String osString = osType == 0 ? "iOS" : "Android";
        String versionString = manufacturingYear > 2015 ? "полную" : "облегченную";
        System.out.printf("Установите %s версию для %s по ссылке%n", versionString, osString);
    }
    public static int calculateDeliveryDays(int deliveryDistance) {
        if (deliveryDistance <= 20){
            return 1;
        } else {
            return (int) Math.round((double) deliveryDistance / 40) +1;
        }
    }
}
