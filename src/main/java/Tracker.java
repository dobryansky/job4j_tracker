

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position] = item;
        this.position++;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    /**
     * Метод находит все заполненые заявки.
     *
     * @return возвращает массив заявок без null элементов.
     */
    public Item[] findAll(){
        return Arrays.copyOf(items, position);
    }
    /**
     * Метод находит все заявки с заданным именем заявки.
     *
     * @return возвращает массив заявок с заданным именем без null элементов.
     */

    public Item[] findByName(String key){
        Item[] itemsCopy = new Item[100];
        int counter = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                itemsCopy[counter] = this.items[i];
                counter++;
            }
        }

        return Arrays.copyOf(itemsCopy, counter);
    }
    /**
     * Метод ищет заявки с заданным именем id.
     *
     * @return возвращает массив заявок с заданным id без null элементов.
     */
    public Item findById(String id) {
        Item item = null;
        for (int index = 0; index < position; index++) {
            Item current = items[index];
            if (current.getId().equals(id)) {
                item = current;
                break;
            }
        }
        return item;
    }

}

