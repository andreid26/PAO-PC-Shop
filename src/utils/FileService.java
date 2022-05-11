package utils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    private static FileService fileService = null;

    private FileService() {}

    public static FileService getFileService() {
        if (fileService == null) {
            fileService = new FileService();
        }
        return fileService;
    }

    public List<String> readFromCsv(String fileName) {
        List<String> lines = new ArrayList<String>();
        File file = new File("src/data/" + fileName);
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Exception - " + e);
        }
        return lines;
    }

    public void writeToFile(String fileName, String line) {
        File file = new File("src/data/" + fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.newLine();
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            System.out.println("Exception - " + e);
        }
    }

    public void logEvent(String event) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        this.writeToFile("logs.txt", event + " - " + dateTimeFormatter.format(localDateTime));
    }
}