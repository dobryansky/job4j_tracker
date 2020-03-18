import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NameActionTest {

    @Test
    public void executeNameAction() {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream def = System.out;
            System.setOut(new PrintStream(out));
            Tracker tracker = new Tracker();
            Item item1 = new Item("BOX");
            tracker.add(item1);
            Item item2 = new Item("BAG");
            tracker.add(item2);

            NameAction action =new NameAction();
            action.execute(new StubInput(new String[] {"BOX"}), tracker);

            String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                    .add("NAME: " + item1.getName() + ", ID: " + item1.getId())
                                       .toString();

            assertThat(new String(out.toByteArray()), is(expect));
        }
    }

