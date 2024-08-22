# Задача Магазин

## Описание
Это финальная задача! В этом задании попрактикуемся с правилами чистого кода и принципами SOLID.

Нужно написать программу-магазин, в которой пользователи заказывают товары. Вам предоставляется свобода в продумывании функциональности вашей программы, как и в проектировании её структуры. В процессе реализации вы должны применить принцип избегания магических чисел, DRY и как минимум 4 из 5 принципов SOLID, причём явно комментариями в коде или при отправке решения указать по одному примеру применения каждого принципа в вашем решении со ссылками на конкретные места кода на гитхабе.

Примеры возможностей программы:
* Вывод доступных для покупки товаров
* Фильтрация товаров по ключевым словам, ценам, производителям
* Составление продуктовой корзины пользователя
* Трекинг заказа в системе доставки
* Возврат заказа, повтороение заказа
* Система рейтинга для товаров
* Простая рекомендательная система для покупок

## Реализация
1. Продумайте и зафиксируйте список возможностей вашей программы.
2. Продумайте консольный интерфейс взаимодействия пользователя с вашей программой.
3. Продумайте систему классов, которые вам понадобятся для реализации вашей программы.
4. Напишите вашу программу, явно применив вышеперечисленные принципы хорошего кода.
5. При отправке решения укажите, в чём именно было применение каждого этого принципа (по одному примеру) со ссылками на конкретные места кода на гитхабе.
6. Протестируйте работу программы. Не забывайте про правила форматирования кода (для автоформата можете выделить код в идее и нажать **Ctrl+Alt+L**).

### DRY - класс Launcher, метод selectСategoryMenu
    Можем создать список с абсолютно другим каталогом чего - либо. Передать новый лист в метод и 
    он будет отрабатывать также. Тоже самое касаемо метода filterMenu. 
    При необходимости можем отфильтровать иной каталог товаров.
* [Ссылка на класс Launcher и метод selectСategoryMenu](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/f2c2fbfed7683abe65e48e530a4a9785585a15c5/src/main/java/Launcher.java#L60)
* [Ссылка на класс Launcher и метод filterMenu](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/f2c2fbfed7683abe65e48e530a4a9785585a15c5/src/main/java/Launcher.java#L89)
## SOLID

### 1. Single-responsibility principle - класс Filter 
    У класса есть своя отдельная функция - фильтровать товары
    
  * [Ссылка на класс Filter](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/main/src/main/java/Filter.java)
    
### 2. Open-closed principle - класс AdderWithOrder расширяет класс Adder.
    При необходимости добавляем методы, если мы хотим изменить логику, такие как placeBuyerOrder к примеру.
  * [Ссылка на класс AdderWithOrder и метод placeBuyerOrder](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/f2c2fbfed7683abe65e48e530a4a9785585a15c5/src/main/java/AdderWithOrder.java#L21)
  
### 3. Liskov substitution principle - Класс AdderWithOrder, который расширяет класс Adder.
    Наследник выполняет все те же функции, что и родитель, и может его заменить.
  * [Ссылка на класс AdderWithOrder](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/main/src/main/java/AdderWithOrder.java)

### 4. Interface segregation principle - классы Laptop и Phone 
    Класс Laptop, который имплиментирует 2 разных интерфейса, которые "применимы" к ноутам.
    а класс Phone имплиментирует только те интерфейсы, которые относятся к телефонам.
  * [Ссылка на класс Laptop](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/main/src/main/java/Laptop.java)
  * [Ссылка на класс Phone](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/main/src/main/java/Phone.java)

### 5. Dependency inversion principle - класс Launcher. Метод selectСategoryMenu.
    Oбъект Adder adder = new AdderWithOrder() - мы можем также сделать через 
    CatalogAdder summator = new AdderWithOrder() и тогда у нас все будет доступно 
    через интерфейс CatalogAdder.
  * [Ссылка на класс Launcher и метод selectСategoryMenu](https://github.com/ischeglov/HW_Magics_DRY_SOLID/blob/f2c2fbfed7683abe65e48e530a4a9785585a15c5/src/main/java/Launcher.java#L70)
