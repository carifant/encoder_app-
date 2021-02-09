

public class TypesOfWork {

    int MIN_VALUE_OF_UPPER_LETTER_IN_ASCII = 65;
    int MAX_VALUE_OF_UPPER_LETTER_IN_ASCII = 90;
    int MIN_VALUE_OF_LOWER_LETTER_IN_ASCII = 97;
    int MAX_VALUE_OF_LOWER_LETTER_IN_ASCII = 122;
    int MIN_VALUE_OF_CHARS_IN_ASCII = 32;
    int MAX_VALUE_OF_CHARS_IN_ASCII = 126;

    /**
     * Method for encryption only letters
     */

    public void encModeByShift(char[] inArr, int key) {
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i] >= MIN_VALUE_OF_UPPER_LETTER_IN_ASCII &&
                  inArr[i] <= MAX_VALUE_OF_UPPER_LETTER_IN_ASCII) {
                if (!(inArr[i] + key > MAX_VALUE_OF_UPPER_LETTER_IN_ASCII)) {
                    int temp = inArr[i] + key;
                    inArr[i] = (char) temp;
                } else {
                    inArr[i] = (char) (inArr[i] + key - MAX_VALUE_OF_UPPER_LETTER_IN_ASCII +
                          MIN_VALUE_OF_UPPER_LETTER_IN_ASCII - 1);
                }
            }
            if (inArr[i] >= MIN_VALUE_OF_LOWER_LETTER_IN_ASCII &&
                  inArr[i] <= MAX_VALUE_OF_LOWER_LETTER_IN_ASCII) {
                if (!(inArr[i] + key > MAX_VALUE_OF_LOWER_LETTER_IN_ASCII)) {
                    int temp = inArr[i] + key;
                    inArr[i] = (char) temp;
                } else {
                    inArr[i] = (char) (inArr[i] + key - MAX_VALUE_OF_LOWER_LETTER_IN_ASCII +
                          MIN_VALUE_OF_LOWER_LETTER_IN_ASCII - 1);
                }
            }
        }
        new Main().comeOutResults(inArr);
    }

    /**
     * Method for encryption characters
     */

    public void encModeByUnicode(char[] inArr, int key) {
        for (int i = 0; i < inArr.length; i++) {
            if (!(inArr[i] + key > MAX_VALUE_OF_CHARS_IN_ASCII)) {
                int temp = inArr[i] + key;
                inArr[i] = (char) temp;
            } else {
                inArr[i] =
                      (char) (MAX_VALUE_OF_CHARS_IN_ASCII - inArr[i] + MIN_VALUE_OF_CHARS_IN_ASCII);
            }
        }
        new Main().comeOutResults(inArr);
    }


    /**
     * Method for decryption characters
     */

    public void decModeByUnicode(char[] inArr, int key) {
        for (int i = 0; i < inArr.length; i++) {
            if (!(inArr[i] - key < MIN_VALUE_OF_CHARS_IN_ASCII)) {
                inArr[i] = (char) (inArr[i] - key);
            } else {
                inArr[i] = (char) (MAX_VALUE_OF_CHARS_IN_ASCII -
                      (MIN_VALUE_OF_CHARS_IN_ASCII - (inArr[i] - key)));
            }
        }
        new Main().comeOutResults(inArr);
    }

    /**
     * Method for decryption only letters
     */

    public void decModeByShift(char[] inArr, int key) {
        for (int i = 0; i < inArr.length; i++) {
            if (inArr[i] >= MIN_VALUE_OF_UPPER_LETTER_IN_ASCII &&
                  inArr[i] <= MAX_VALUE_OF_UPPER_LETTER_IN_ASCII) {
                if (!(inArr[i] - key < MIN_VALUE_OF_UPPER_LETTER_IN_ASCII)) {
                    inArr[i] = (char) (inArr[i] - key);
                } else {
                    inArr[i] = (char) (MAX_VALUE_OF_UPPER_LETTER_IN_ASCII -
                          (MIN_VALUE_OF_UPPER_LETTER_IN_ASCII - (inArr[i] - key + 1)));
                }
            }
            if (inArr[i] >= MIN_VALUE_OF_LOWER_LETTER_IN_ASCII &&
                  inArr[i] <= MAX_VALUE_OF_LOWER_LETTER_IN_ASCII) {
                if (!(inArr[i] - key < MIN_VALUE_OF_LOWER_LETTER_IN_ASCII)) {
                    inArr[i] = (char) (inArr[i] - key);
                } else {
                    inArr[i] = (char) (MAX_VALUE_OF_LOWER_LETTER_IN_ASCII -
                          (MIN_VALUE_OF_LOWER_LETTER_IN_ASCII - (inArr[i] - key + 1)));
                }
            }
        }
        new Main().comeOutResults(inArr);
    }
}
