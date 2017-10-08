import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PrettyPrinter {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            throw new Exception("Use: PrettyPrinter pathToFile");
        }

        List<String[]> separateCells = loadFromFile(args[0]);


        int width = 0;
        for (int i = 0; i < separateCells.get(0).length; i++) {
            int cellWidth = separateCells.get(0)[i].length();
            for (String[] separateCell : separateCells) {
                if (separateCell[i].length() > cellWidth) {
                    cellWidth = separateCell[i].length();
                }
            }

            width += cellWidth + 2;

            for (String[] separateCell : separateCells) {
                if (separateCell[i].length() < cellWidth) {
                    StringBuilder indent = new StringBuilder();
                    for (int j = 0; j < cellWidth - separateCell[i].length(); j++) {
                        indent.append(" ");
                    }
                    separateCell[i] += indent;
                }
            }
        }

        StringBuilder border = new StringBuilder();
        for (int i = 0; i < width; i++) {
            border.append("-");
        }


        for (int i = 0; i < separateCells.size(); i++) {
            if (i < 2) {
                System.out.println(border);
            }
            for (String s : separateCells.get(i)) {
                System.out.print("|" + s + " ");
            }
            System.out.print("|");
            System.out.println();

        }
        System.out.println(border);
    }

    private static List<String[]> loadFromFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("Cannot find file " + path);
        }
        List<String> lines;
        List<String[]> cells = new ArrayList<>();

        lines = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));

        for (String line : lines) {
            String[] separateLine = line.split(";");
            cells.add(separateLine);
        }
        return cells;
    }


}
