public class Main {

    public static void main(String[] args) {

        String[][] strings = {  {"11", "12", "13", "14"},
                                {"21", "22", "23", "24"},
                                {"31", "32", "33", "34"},
                                {"41", "42", "43", "44"}};

        int sumOfstrings;

        try {

            sumOfstrings = sumOfArray(strings);

            System.out.println("Sum = " + sumOfstrings);
        }
        catch (MyArraySizeException e) {

            e.printStackTrace();
        }
        catch (MyArrayDataException e) {

            e.printStackTrace();
        }
    }

    private static int sumOfArray(String[][] array) throws MyArraySizeException {

        if (array.length != 4) throw new MyArraySizeException();

        for (String[] row : array) {

            if (row.length != 4) throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            String [] row = array[i];

            for (int j = 0; j < row.length; j++) {

                int cell;

                try {
                    cell = Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {

                    MyArrayDataException myE = new MyArrayDataException(
                            "NumberFormatException in cell with indexes [i][j] = [" + (i+1) + "][" + (j+1) + "]");

                    myE.setStackTrace(e.getStackTrace());

                    throw myE;
                }

                sum = sum + cell;
            }
        }

        return sum;
    }
}
