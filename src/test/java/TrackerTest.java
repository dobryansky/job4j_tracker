
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item[] result = tracker.findByName("test1");
        assertThat(result[0].getName(), is("test1"));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("test1"));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item item = new Item("Need to replace");
        tracker.add(item);
        String id = item.getId();
        Item replaced = new Item("Already replaced");
        tracker.replace(id, replaced);
        assertThat(tracker.findById(id).getName(), is("Already replaced"));
    }


}
