public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "===EXIT PROGRAM===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("You really want to EXIT :Press Y/N? - ");
        boolean result=true;
        if (name.equals("Y")||name.equals("y")){
            result=false;
        }
        return result;
    }
}
