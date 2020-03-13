public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;

        while (run) {
            this.showMenu();
            String msg = "Select :";
            int select = input.askInt(msg);
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findByID(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
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
    }

    private static void showItem(Item item) {
        if (item != null) {
            System.out.println("NAME: " + item.getName() + ", ID: " + item.getId());
        }
    }

    private static void showItems(Item[] items) {
        if (items.length > 0) {
            for (Item item : items) {
                showItem(item);
            }
        } else {
            System.out.println("No items");
        }

    }


    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Input Item name :");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Input input, Tracker tracker) {
        System.out.println("=== Showing all items ====");
        Item[] items = tracker.findAll();
        for (Item value : items) {
            System.out.println("name- " + value.getName() + " | id- " + value.getId());
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Input items id, need to rename :");

        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.askStr("Input item's new name: ");
            item.setName(name);
            tracker.replace(item.getId(), item);
        } else {
            System.out.println("ERROR!!!! There is no item with such ID!");
        }



       /* String name = input.askStr("Input item's new name: ");
        Item newName = new Item(name);
        if (tracker.replace(id, newName)) {
            System.out.println("Item was edited");

        }

        else {
            System.out.println("ERROR!!!! There is no item with such ID!");
        }

        */
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Input items id, need Delete :");
        Item item = tracker.findById(id);
        if (item != null) {
            String needDelete = item.getId();
            tracker.delete(needDelete);
            System.out.println("Item was deleted successfully");
        } else {
            System.out.println("ERROR!!!! There is no item with such ID!");
        }
    }

    public static void findByID(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr("Input items id, need to Find");
        Item item = tracker.findById(id);
        if (item != null) {
            showItem(item);
        } else {
            System.out.println("ERROR!!!! There is no item with such ID!");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ===");
        String name = input.askStr("Input items' name: ");
        Item[] items = tracker.findByName(name);
        showItems(items);

    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}