import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Объявим все что необходимо для работы
        Calculator calculator = new Calculator();
        Scanner scan = new Scanner(System.in);
        int peopleCount;

        while (true) {
            System.out.println("На сколько человек необходимо разделить счет?");
            try {
                peopleCount = Integer.parseInt(scan.next());
                if (peopleCount < 1) {
                    System.out.println("Ошибка ввода попробуйте еще раз!");
                } else if (peopleCount == 1) {
                    System.out.println("Счет не может быть разделен на одного человека. Попробуйте еще раз!");
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка ввода! Возможен только ввод целых чисел.");
            }
        }

        // переменные для записи товара
        double price;
        String goodsName;
        while (true) {
            System.out.println("Введите наименование товара: ");
            goodsName = scan.next();
            while (true) {
                System.out.println("Введите стоимость товара: ");
                try {
                    price = Double.parseDouble(scan.next());
                    if (price <= 0) {
                        System.out.println("Стоимость товара не может быть отрицательной или меньше 0");
                    }
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Ошибка ввода! Необходимо ввести стоимость товара в формате рубли.копейки.");
                }
            }
            calculator.addGoods(goodsName, price);
            System.out.println("Товар добавлен в корзину!");
            System.out.println("Хотите ли вы добавить еще товар?");
            if (scan.next().toLowerCase().compareTo("завершить") == 0) {
                break;
            }
        }

        System.out.println("Добавленные товары: " + "\n" + calculator.basket);
        System.out.println("Стоимость счета на каждого человека составляет: " +
                String.format("%.2f", calculator.allPriceSum / peopleCount) + " " + calculator.correctStringCurrency(peopleCount));
        scan.close();
    }
}