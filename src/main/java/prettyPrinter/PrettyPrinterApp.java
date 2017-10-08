package prettyPrinter;

public class PrettyPrinterApp {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            throw new Exception("Use: PrettyPrinterApp pathToFile");
        }

        PrettyPrinter prettyPrinter = new PrettyPrinter();
        prettyPrinter.prettyPrintTable(args[0]);
    }
}
