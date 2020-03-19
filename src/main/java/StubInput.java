
    public class StubInput implements Input {
        private String[] answers;
        private int position = 0;
        private String id;


        public StubInput(String[] answers) {
            this.answers = answers;
        }

        public StubInput(String id) {
            this.id = id;
        }



        @Override
        public String askStr(String question) {
            return answers[position++];
        }

        @Override
        public int askInt(String question) {
            return Integer.valueOf(askStr(question));
        }

        @Override
        public int askInt(String question, int max) {
            return askInt(question);
        }
    }
