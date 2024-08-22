import java.util.List;

public class Filter {
    /*Single-responsibility principle - класс Filter, у класса есть своя отдельная функция - фильтровать товары*/

    public void filterPrice(List<Catalog> list, int price) {
        list.stream()
                .filter(p -> p.getPrice() < price)
                .forEach(System.out::println);
    }

    public void filterName(List<Catalog> list, String name) {
        list.stream()
                .filter(n -> n.getName().toLowerCase().contains(name.toLowerCase()))
                .forEach(System.out::println);
    }
}
