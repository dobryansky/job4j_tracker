

import java.util.Scanner;
public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        Item item;
        String id, name;
        Item[] items;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                 name = scanner.nextLine();
                 item = new Item(name);
                tracker.add(item);
            }

            else if (select == 1) {
                System.out.println("=== Showing all items ====");
                items = tracker.findAll();
                for (int i=0; i<items.length; i++){
                    System.out.println("name- " + items[i].getName() + " | id- " +items[i].getId() );
                }

            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Input items id, need to replace ");
                id = scanner.nextLine();
                item =tracker.findById(id);
                if (item!=null){
                    System.out.print("Input item's new name: ");
                    name = scanner.nextLine();
                    item.setName(name);
                    tracker.replace(item.getId(), item);
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Input items id, need Delete ");
                id = scanner.nextLine();
                item =tracker.findById(id);
                String needDelete=item.getId();
                tracker.delete(needDelete);


            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Input items id, need to Find ");
                id = scanner.nextLine();
                item =tracker.findById(id);
                if (item != null) {
                    showItem(item);
                }


            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                System.out.print("Input items' name: ");
                name = scanner.nextLine();
                items = tracker.findByName(name);
                if (items != null) {
                    showItems(items);
                }


            } else if (select == 6) {
                run = false;
            }
            // if
        }
    }

    private void showMenu() {
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");

        // добавить остальные пункты меню.
    }
    private void showItem(Item item) {
        if (item != null) {
            System.out.println("NAME: " + item.getName() + ", ID: " + item.getId());
        }
    }

    private void showItems(Item[] items) {
        if (items.length > 0) {
            for (Item item: items) {
                this.showItem(item);
            }
        } else {
            System.out.println("No items");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);


    }
}


