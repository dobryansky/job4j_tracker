public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Input items id, need to rename :");
        String name = input.askStr("Input item's new name: ");
        Item newName = new Item(name);
        if (tracker.replace(id, newName)) {
            System.out.println("Item was edited");
        }

        else {
            System.out.println("ERROR!!!! There is no item with such ID!");
        }
        return true;
    }
}
