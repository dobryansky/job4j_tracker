

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
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items[index] : null;
    }
    /**
     * Метод , который возвращает index по id.
     *
     * @return rsl
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
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
            result = true;

            item.setId(id);
            items[index] = item;
        }

        return result;

    }
    /**
     * Метод  удаления заявок из массива
     *
     * @return result
     */
  public boolean delete(String id) {
      boolean result =false;

      int index=indexOf(id);

      for (int i = 0; i < position; i++) {
          if (index!=-1) {
              result = true;
              items[indexOf(id)] = null;

              int start = index + 1;
              int distPos = index;
              int size = position - index;
              System.arraycopy(items, start, items, distPos, size);
              break;
          }
      }

      items[position - 1] = null;
      position--;
return result;
    }




}

