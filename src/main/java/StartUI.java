import java.util.ArrayList;
import java.util.List;

public class StartUI {


    public static void showItem (List<Item> item) {
        for (Item list : item) {

            System.out.println("NAME: " +list.getName() + ", ID: " + list.getId());

    }
    }


    public static void showItems(List<Item> item) {
        for (Item list : item) {
                StartUI.showItem(item);
            }
        }



    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();;
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction());
                actions.add(new DeleteAction());
                actions.add (new EditAction());
                actions.add (new IDAction());
                actions.add (new NameAction());
                actions.add (new ShowAction());
                actions.add(new ExitAction());

        new StartUI().init(input, tracker, actions);
    }


}