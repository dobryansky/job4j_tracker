

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private  List<Item> items = new ArrayList<>();

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
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
    public List<Item> findAll(){
        return items;
    }
    /**
     * Метод находит все заявки с заданным именем заявки.
     *
     * @return возвращает массив заявок с заданным именем без null элементов.
     */

    public List<Item> findByName(String key) {
        List<Item> item = new ArrayList<>();
        for (Item index : items) {
            if (index.getName().equals(key)) {
                item.add(index);
            }
        }
        return item;
    }
    /**
     * Метод ищет заявки с заданным именем id.
     *
     * @return возвращает массив заявок с заданным id без null элементов.
     */
    public Item findById(String id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null

        return index != -1 ? items.get(index) : null;
    }
    /**
     * Метод , который возвращает index по id.
     *
     * @return rsl
     */
    private int indexOf(String id) {
        int rsl = -1;
        int index = 0;
        for (Item check : items) {
            if (check.getId().equals(id)) {
                rsl = index;
            }
            index++;

        }
        return rsl;
    }

    /**
     * Метод , который заменяет заявки по имени, но id остается тот же самый.
     *
     * @return result
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index= indexOf(id);
        if (index!=-1) {
            item.setId(items.get(index).getId());
            items.set(index, item);
            result=true;
        }
        return result;

    }
    /**
     * Метод  удаления заявок из массива
     *
     * @return result
     */
  public boolean delete(String id) {

      boolean result = false;
      int index = indexOf(id);
      if (index != -1) {
          items.remove(index);
          result = true;
      }
      return result;
  }
}

