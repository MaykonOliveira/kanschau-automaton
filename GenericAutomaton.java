public class GenericAutomaton {
    static int[] acceptanceStates = {6, 9};
    static int[][] transitionTable = {{1, 2, 12, 6}, {0, 8, 12, 12}, {12, 12, 3, 12}, {12, 4, 12, 12}, {12, 12, 5, 12},
            {12, 2, 12, 6}, {12, 12, 12, 7}, {12, 12, 12, 6}, {12, 12, 9, 12}, {12, 10, 12, 7}, {12, 12, 11, 12},
            {12, 8, 12, 12}, {12, 12, 12, 12}};
    static int initialState = 0;



    public static void main(String args[]) {
        String input = args[0];
        int state = initialState;
        int position = 0;

        while (position < input.length()) {
            char element = input.charAt(position);
            int elementInt = returnMatchingInteger(element);
            state = transitionTable[state][elementInt];
            position ++;
        }

        boolean accepted = false;
        for (int i : acceptanceStates) {
            if (state == i) {
                accepted = true;
            }
        }

        if (accepted) {
            System.out.println("Accepted!");
        } else {
            System.out.println("Rejected!");
        }
    }

    public static int returnMatchingInteger(char element) {
        if (element == 'a') {
            return 0;
        } else if (element == 'b') {
            return 1;
        } else if (element == 'c') {
            return 2;
        } else {
            return 3;
        }
    }
}