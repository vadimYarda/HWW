import java.util.List;

public class AdderWithOrder extends Adder {
    /*Open-closed principle - класс AdderWithOrder расширяет класс Adder.
    При необходимости добавляем методы, если мы хотим изменить логику, такие как placeBuyerOrder к примеру.
    Liskov substitution principle - класс AdderWithOrder, который расширяет класс Adder.
    Наследник выполняет все те же функции, что и родитель, и может его заменить.*/

    @Override
    public void sum(List<Catalog> list) {
        super.sum(list);
    }

    @Override
    public void viewСart(List<Catalog> list, int[] countProducts, int sumProducts) {
        super.viewСart(list, countProducts, sumProducts);
        System.out.println();
        placeBuyerOrder(list);
    }

    public void placeBuyerOrder(List<Catalog> list) {
        System.out.println("Выберите дальнейшие действия:\n" +
                "1. Заказать\n" +
                "2. Вернуться к списку товаров\n" +
                "3. Вернуться к выбору категорий\n" +
                "Ваш выбор: ");
        try {
            int actions = Launcher.scanner.nextInt();
            switch (actions) {
                case 1 -> {
                    System.out.println("Открывается страница оформления заказа ..." +
                            "\nЗаказываем товар ..." +
                            "\nПереход на страницу оплаты ..." +
                            "\nОплата прошла успешно ..." +
                            "\nОжидайте доставку \uD83D\uDE9A");
                }
                case 2 -> Launcher.selectСategoryMenu(list);
                case 3 -> Launcher.start();
            }
        } catch (NumberFormatException e) {
            System.out.println("Введена недопустимая категория. Попробуйте еще раз");
        }
    }
}


