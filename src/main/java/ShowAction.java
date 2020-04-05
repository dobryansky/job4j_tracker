import java.util.List;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "===Show all Items===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
       StartUI.showItems(items);
        return true;
    }
}
