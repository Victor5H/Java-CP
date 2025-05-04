import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;

public class script {

    public static void main(String[] args) {
        String folderPath = "src/"; // <- 🔁 change this to your Java files directory
        String indexFile = "index.txt";

        try {
            // List to store file info with creation time
            List<FileInfo> fileInfos = new ArrayList<>();

            Files.walk(Paths.get(folderPath))
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> {
                        try {
                            BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                            fileInfos.add(new FileInfo(path.getFileName().toString(), attr.creationTime().toMillis(),path.getParent()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            // Sort files by creation time
            fileInfos.sort(Comparator.comparingLong(f -> f.creationTime));

            // Write to index.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(folderPath+indexFile))) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy - HH:mm:ss - E");
                int counter = 1;
                for (FileInfo fileInfo : fileInfos) {
                    if(Objects.equals(fileInfo.name, "script.java")){continue;}
                    Date date = new Date(fileInfo.creationTime);

                   // System.out.println(sdf.format(date));
                    String line = String.format("%03d - %-35s \t -- %-15s %-10s", counter++, fileInfo.name, fileInfo.path,sdf.format(date));
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
        Path path;
        FileInfo(String name, long creationTime, Path path) {
            this.name = name;
            this.creationTime = creationTime;
            this.path = path;
        }
    }
}
