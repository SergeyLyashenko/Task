package prettyPrinter;

import java.io.IOException;

public class PrettyPrinterApp {

    public static void main(String[] args) throws IllegalArgumentException, IOException {

        if (args.length != 1) {
            throw new IllegalArgumentException("Use: PrettyPrinterApp pathToFile");
        }

        PrettyPrinter prettyPrinter = new PrettyPrinter();
        prettyPrinter.prettyPrintTable(args[0]);
    }
}
