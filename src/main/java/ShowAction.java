public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "===Show all Items===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
               StartUI.showItem(item);
            }
        } else {
            System.out.println("No items");
        }
        return true;
    }
}
