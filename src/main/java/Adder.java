import java.util.List;
import java.util.Scanner;

public class Adder implements CatalogAdder {

    @Override
    public void sum(List<Catalog> list) {
        try {
            Scanner scan = new Scanner(System.in);
            int currentPrice = 0;
            int sumProducts = 0;
            int[] countProducts = new int[list.size()];
            while (true) {
                String input = scan.nextLine();
                if (input.equals("end")) {
                    viewСart(list, countProducts, sumProducts);
                    break;
                }
                String[] parts = input.split(" ");
                int productNumber = Integer.parseInt(parts[0]) - 1;
                int productCount = Integer.parseInt(parts[1]);

                currentPrice = list.get(productNumber).getPrice() * productCount;
                sumProducts += currentPrice;

                countProducts[productNumber] += productCount;
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите номер товара и через пробел количество. Попробуйте еще раз");
        }
    }

    @Override
    public void viewСart(List<Catalog> list, int[] countProducts, int sumProducts) {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < countProducts.length; ++i) {
            if (countProducts[i] == 0) {
                continue;
            }
            System.out.println(list.get(i).getName() + " " + countProducts[i] + " шт "
                    + list.get(i).getPrice() + " руб/шт " + list.get(i).getPrice() * countProducts[i] + " руб в сумме");
        }

        System.out.println("Итого " + sumProducts + " руб");
    }
}

