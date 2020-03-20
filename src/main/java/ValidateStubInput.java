public class ValidateStubInput extends ValidateInput {
    private String[] data;
    private int position;

    public ValidateStubInput(String[] data) {
        this.data = data;
    }

    @Override
    public String askStr(String question) {
        return data[position++];
    }

    @Override
    public int askInt(String question, int max) {
        int select = super.askInt(question, max);
           return select;
    }
}