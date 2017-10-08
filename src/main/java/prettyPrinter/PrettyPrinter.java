package prettyPrinter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PrettyPrinter {
    private int tableWidth;

    public void prettyPrintTable(String path) throws IOException {
        List<String[]> table = loadFromFile(path);
        alignTheTableToTheWidth(table);
        printTable(table);

    }

    //separate all file by cells
    private List<String[]> loadFromFile(String path) throws IOException {
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

    private void alignTheTableToTheWidth(List<String[]> table) {
        tableWidth = 0;
        for (int i = 0; i < table.get(0).length; i++) {
            int cellWidth = table.get(0)[i].length();
            for (String[] separateCell : table) {
                if (separateCell[i].length() > cellWidth) {
                    cellWidth = separateCell[i].length();
                }
            }
            tableWidth += cellWidth + 2;
            for (String[] separateCell : table) {
                if (separateCell[i].length() < cellWidth) {
                    StringBuilder indent = new StringBuilder();
                    for (int j = 0; j < cellWidth - separateCell[i].length(); j++) {
                        indent.append(" ");
                    }
                    separateCell[i] += indent;
                }
            }
        }
    }

    private void printTable(List<String[]> table) {
        //horizon border of the table
        StringBuilder border = new StringBuilder();
        for (int i = 0; i < tableWidth; i++) {
            border.append("-");
        }

        //pretty print
        for (int i = 0; i < table.size(); i++) {
            if (i < 2) {
                System.out.println(border);
            }
            for (String s : table.get(i)) {
                System.out.print("|" + s + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(border);
    }
}
