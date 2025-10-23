package arrays.pepcoding;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class script {

    public static void main(String[] args) {
        String folderPath = "src/arrays/"; // <- 🔁 change this to your Java files directory
        String indexFile = "index.txt";

        try {
            // List to store file info with creation time
            List<FileInfo> fileInfos = new ArrayList<>();

            Files.walk(Paths.get(folderPath))
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> {
                        try {
                            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                            fileInfos.add(new FileInfo(path.getFileName().toString(), attr.creationTime().toMillis()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            // Sort files by creation time
            fileInfos.sort(Comparator.comparingLong(f -> f.creationTime));

            // Write to index.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(folderPath+indexFile))) {
                int counter = 1;
                for (FileInfo fileInfo : fileInfos) {
                    if(Objects.equals(fileInfo.name, "script.java")){continue;}
                    String line = String.format("%03d - %s", counter++, fileInfo.name);
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Index written to " + indexFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper class
    static class FileInfo {
        String name;
        long creationTime;

        FileInfo(String name, long creationTime) {
            this.name = name;
            this.creationTime = creationTime;
        }
    }
}
