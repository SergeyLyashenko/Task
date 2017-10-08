package prettyPrinter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PrettyPrinter {

    public void prettyPrintTable(String path) throws IOException {
        List<String[]> table = loadFromFile(path);
        List<Integer> columnsWidth = determineTheWidthOfColumns(table);
        printTable(table, columnsWidth);

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

    private List<Integer> determineTheWidthOfColumns(List<String[]> table) {
        List<Integer> columnsWidth = new ArrayList<>();
        for (int i = 0; i < table.get(0).length; i++) {
            int columnWidth = table.get(0)[i].length();
            for (String[] separateCell : table) {
                if (separateCell[i].length() > columnWidth) {
                    columnWidth = separateCell[i].length();
                }
            }
            columnsWidth.add(columnWidth);
        }
        return columnsWidth;
    }

    private void printTable(List<String[]> table, List<Integer> columnsWidth) {
        int tableWidth = 2*columnsWidth.size();
        for (Integer integer : columnsWidth) {
            tableWidth +=integer;
        }

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
            for (int j = 0; j < table.get(i).length ; j++) {
                StringBuilder indent = new StringBuilder(" ");
                for (int k = 0; k < columnsWidth.get(j) - table.get(i)[j].length(); k++) {
                    indent.append(" ");
                }
                System.out.print("|" + table.get(i)[j] + indent);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(border);
    }
}
