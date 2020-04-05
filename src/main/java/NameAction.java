import java.util.List;

public class NameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===" ;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Input items' name: ");
        List<Item> items = tracker.findByName(name);
        StartUI.showItems(items);
        return true;
    }
}


