public class NameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===" ;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Input items' name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                if (item != null) {
                    System.out.println("NAME: " + item.getName() + ", ID: " + item.getId());
                }
            }
        } else {
            System.out.println("No items");
        }
        return true;
    }
}
