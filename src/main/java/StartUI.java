public class StartUI {


    public static void showItem(Item item) {
        if (item != null) {
            System.out.println("NAME: " + item.getName() + ", ID: " + item.getId());
        }
    }


    public static void showItems(Item[] items) {
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



    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Input items id, need to rename :");
        String name = input.askStr("Input item's new name: ");
        Item newName = new Item(name);
        if (tracker.replace(id, newName)) {
            System.out.println("Item was edited");
        }

        else {
            System.out.println("ERROR!!!! There is no item with such ID!");
        }

    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Input items id, need Delete :");
        //Item item = tracker.findById(id);
         if (tracker.delete(id)) {
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


    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new DeleteAction(),
                new EditAction(),
                new IDAction(),
                new NameAction(),
                new ShowAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }




}