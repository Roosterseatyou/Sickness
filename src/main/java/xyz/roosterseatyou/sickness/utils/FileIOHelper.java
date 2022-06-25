package xyz.roosterseatyou.sickness.utils;

import xyz.roosterseatyou.sickness.Sickness;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOHelper {

    public static File createYMLFile(String fileName, String firstPath) {
        File resourceFolder = Sickness.getInstance().getDataFolder();
        File file = new File(resourceFolder, fileName);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(firstPath);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sickness.logger().info("Creating file: " + file.getPath());
        if (!file.exists()) {
            try {
                file.createNewFile();
                Sickness.logger().info("File created: " + file.getAbsolutePath());
            } catch (IOException e) {
                Sickness.logger().error("Could not create file: " + fileName);
            }
        } else {
            Sickness.logger().info("File already exists: " + fileName);
        }
        return file;
    }
}
