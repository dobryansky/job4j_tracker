
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;

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
        ArrayList<Item> item = new ArrayList<>();
        item.add(new Item("test1"));

        ArrayList<Item> result = new ArrayList<>();
        result.add(item.get(0));
        assertThat(item.get(0), is("test1"));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        ArrayList<Item> item = new ArrayList<>();
        item.add(new Item("test1")) ;
        item.add(new Item("test2")) ;
        tracker.add(item.get(0));
        tracker.add(item.get(1));
        List<Item> result = tracker.findAll();
        assertThat(result, is(item));
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
/*
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        ArrayList<Item> item = new ArrayList<>();
        ArrayList<Item> item = new ArrayList<>();
        Item item1 =         new Item("test 1");
        Item willbedeleted = new Item("will be deleted");
        Item item2 =         new Item("test 2");

        tracker.add(item1);
        tracker.add(willbedeleted);
        tracker.add(item2);

       String needDelete=willbedeleted.getId();
       tracker.delete(needDelete);
        Item[] result = tracker.findAll();

        assertThat(result[1].getName(), is("test 2"));
    }*/




}
