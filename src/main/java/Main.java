import java.io.*;
import java.util.Scanner;

/**
 * Main class with base logic of app
 */

public class Main {

    String mode;
    String data;
    Integer key;
    String input;
    String output;
    String algoritm;

    /**
     * Starter of app
     */

    public void starter(String[] args) {
        parserCommandLine(args);
        setDefaultValues();
        chooserModeOfWork();
    }

    /**
     * method for parse Command line
     */

    private void parserCommandLine(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-in")) {
                input = args[i + 1];
            } else if (args[i].equals("-out")) {
                output = args[i + 1];
            } else if (args[i].equals("-alg")) {
                algoritm = args[i + 1];
            }
        }
    }

    /**
     * Method for setting default values
     */

    private void setDefaultValues() {
        if (mode == null) {
            mode = "enc";
        }
        if (algoritm == null) {
            algoritm = "shift";
        }
        if (data == null & input == null) {
            data = "";
        } else if (data == null & input != null) {
            getterInputFile();
        }
    }

    /**
     * Method for get data from file
     */

    private void getterInputFile() {
        try (Scanner scanner = new Scanner(new File(input))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
            data = stringBuilder.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method for choose current mode of work
     */

    private void chooserModeOfWork() {
        char[] inArr = data.toCharArray();
        if (mode.equals("enc") && algoritm.equals("shift")) {
            new TypesOfWork().encModeByShift(inArr, key);
        }
        if (mode.equals("enc") && algoritm.equals("unicode")) {
            new TypesOfWork().encModeByUnicode(inArr, key);
        } else if (mode.equals("dec") && algoritm.equals("unicode")) {
            new TypesOfWork().decModeByUnicode(inArr, key);
        } else if (mode.equals("dec") && algoritm.equals("shift")) {
            new TypesOfWork().decModeByShift(inArr, key);
        }
    }

    /**
     * Method for writing date to file
     */

    private void writer(String output, String data) {
        try (PrintWriter printWriter = new PrintWriter(output)) {
            printWriter.write(data);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method for print or write result set
     */

    public void comeOutResults(char[] inArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : inArr) {
            if (c != ',') {
                stringBuilder.append(c);
            }
        }
        if (output == null) {
            System.out.println(stringBuilder);
        } else {
            new Main().writer(output, stringBuilder.toString());
        }
    }
}


