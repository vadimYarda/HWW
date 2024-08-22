
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Launcher {
    /*Dependency inversion principle - класс Launcher. Метод selectСategoryMenu.
    Oбъект Adder adder = new AdderWithOrder() - мы можем также сделать через CatalogAdder summator = new AdderWithOrder()
    и тогда у нас все будет доступно через интерфейс CatalogAdder.

    DRY - класс Launcher, метод selectСategoryMenu
    Можем создать список с абсолютно другим каталогом чего - либо. Передать новый лист в метод и он будет отрабатывать также.
    Тоже самое касаемо метода filterMenu. При необходимости можем отфильтровать иной каталог товаров.
*/

    public static final Scanner scanner = new Scanner(System.in);

    public static final List<Catalog> laptopsList = new ArrayList<>();
    public static final List<Catalog> phonesList = new ArrayList<>();

    public static void main(String[] args) {

        laptopsList.add(new MacBook("Apple MacBook Air (M1, 2020) 8 ГБ, 256 ГБ SSD", 99_990, 8.0));
        laptopsList.add(new MacBook("Apple MacBook Air 13 (M2, 8C CPU/8C GPU, 2022), 8 ГБ, 256 ГБ SSD", 134_990, 8.5));
        laptopsList.add(new MacBook("Apple MacBook Air 13 (M2, 8C CPU/10C GPU, 2022), 8 ГБ, 512 ГБ SSD", 166_990, 9.0));
        laptopsList.add(new MacBook("Apple MacBook Air 15 (M2, 8C CPU/10C GPU, 2023), 8 ГБ, 256 ГБ SSD", 159_990, 9.5));
        laptopsList.add(new MacBook("Apple MacBook Pro 16 (M2 Max 12C CPU, 38C GPU, 2023) 32 ГБ, 2 ТБ SSD", 585_990, 10.0));

        phonesList.add(new IPhone("Apple iPhone 13, 256 ГБ", 95_990));
        phonesList.add(new IPhone("Apple iPhone 14 Plus SIM 512 ГБ", 139_990));
        phonesList.add(new IPhone("Apple iPhone 15 dual-SIM 512 ГБ", 169_990));
        phonesList.add(new IPhone("Apple iPhone 15 Pro dual-SIM 1 ТБ", 249_990));
        phonesList.add(new IPhone("Apple iPhone 15 Pro Max dual-SIM 1 ТБ", 269_990));

        start();
    }

    public static void start() {
        selectСategory(laptopsList, phonesList);
    }

    public static void selectСategory(List<Catalog> laptopsList, List<Catalog> phonesList) {
        System.out.println("\nВыберите категорию товаров:\n" +
                "1. Laptops\n" +
                "2. Phones\n" +
                "Ваш выбор: ");
        try {
            int category = scanner.nextInt();
            switch (category) {
                case 1 -> selectСategoryMenu(laptopsList);
                case 2 -> selectСategoryMenu(phonesList);
                default -> System.out.println("Такой категории не существует. :(");
            }
        } catch (InputMismatchException e) {
            System.out.println("Такой категории не существует. :(");
        }
    }

    public static void selectСategoryMenu(List<Catalog> list) {
        System.out.println("Выберите раздел:\n" +
                "1. Показать наличие товара\n" +
                "2. Применить фильтр по цене или наименованию\n" +
                "Ваш выбор: ");
        try {
            int category = scanner.nextInt();
            switch (category) {
                case 1 -> {
                    productMenu(list);
                    Adder adder = new AdderWithOrder();
                    adder.sum(list);
                }
                case 2 -> filterMenu(list);
            }
        } catch (NumberFormatException e) {
            System.out.println("Введена недопустимая категория. Попробуйте еще раз");
        }
    }

    private static void productMenu(List<Catalog> list) {
        System.out.println("\nВыберите товар и количество через пробел, для просмотра корзины нажмите end:\n" +
                "Список товара\n" +
                "Ваш выбор: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i).getName() + " цена " + list.get(i).getPrice());
        }
    }

    private static void filterMenu(List<Catalog> list) {
        System.out.println("\nВыберите необходимый фильтр:\n" +
                "1. Фильтр по цене\n" +
                "2. Фильтр по наименованию\n" +
                "Ваш выбор: ");
        try {
            int filter = scanner.nextInt();
            switch (filter) {
                case 1 -> {
                    System.out.println("Введите максимальную цену: ");
                    int maxPrice = scanner.nextInt();
                    Filter price = new Filter();
                    price.filterPrice(list, maxPrice);
                    System.out.println("Для возврата в меню нажмите '1'");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        selectСategoryMenu(list);
                    }
                }
                case 2 -> {
                    System.out.println("Введите наименование модели: ");
                    Scanner nameScanner = new Scanner(System.in);
                    String name = nameScanner.nextLine();
                    Filter productName = new Filter();
                    productName.filterName(list, name);
                    System.out.println("\nВозвращаемся к меню: ");
                    selectСategoryMenu(list);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Введено неверное значение. Попробуйте еще раз");
        }
    }
}
