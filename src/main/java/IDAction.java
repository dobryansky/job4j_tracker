public class IDAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Input items id, need to Find");
        Item item = tracker.findById(id);
        if (item != null) {
            StartUI.showItem(item);
        } else {
            System.out.println("ERROR!!!! There is no item with such ID!");
        }

        return true;
    }
}
