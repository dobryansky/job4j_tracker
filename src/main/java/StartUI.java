public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        Item item;
        String id, name;
        Item[] items;
        while (run) {
            this.showMenu();
            String msg="Select :";
            int select = input.askInt(msg);
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                msg="Input Item name :";
                name = input.askStr(msg);
                item = new Item(name);
                tracker.add(item);
            }

            else if (select == 1) {
                System.out.println("=== Showing all items ====");
                items = tracker.findAll();
                for (Item value : items) {
                    System.out.println("name- " + value.getName() + " | id- " + value.getId());
                }

            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                msg="Input items id, need to replace :";

                id = input.askStr(msg);
                item =tracker.findById(id);
                if (item!=null){
                    System.out.print("Input item's new name: ");
                    name = input.askStr(msg);
                    item.setName(name);
                    tracker.replace(item.getId(), item);
                }

            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                msg="Input items id, need Delete :";
                id = input.askStr(msg);
                item =tracker.findById(id);
                String needDelete=item.getId();
                tracker.delete(needDelete);


            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                msg="Input items id, need to Find";
                id = input.askStr(msg);
                item =tracker.findById(id);
                if (item != null) {
                    showItem(item);
                }


            } else if (select == 5) {
                System.out.println("=== Find item by name ===");
                msg="Input items' name: ";
                name = input.askStr(msg);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}