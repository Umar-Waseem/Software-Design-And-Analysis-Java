// file handler

import java.io.*;
import java.util.Scanner;

// a class that handles file handling operations
class FileHandler {
    // a method that creates a file
    static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    // a method that writes to a file
    static void writeToFile(String fileName, String data) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(data);
            fileWriter.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    // a method that reads from a file
    static String readFromFile(String fileName) {
        String data = "";
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                data += fileReader.nextLine();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return data;
    }

    // a method that appends to a file
    static void appendToFile(String fileName, String data) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(data);
            fileWriter.close();
            System.out.println("Successfully appended to the file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    // a method that deletes a file
    static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    // a method that renames a file
    static void renameFile(String fileName, String newFileName) {
        File file = new File(fileName);
        File newFile = new File(newFileName);
        if (file.renameTo(newFile)) {
            System.out.println("File renamed successfully");
        } else {
            System.out.println("Failed to rename the file");
        }
    }

    // a method that checks if a file exists
    static boolean fileExists(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    // a method that checks if a file is empty
    static boolean fileIsEmpty(String fileName) {
        File file = new File(fileName);
        if (file.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // a method that returns the size of a file
    static long fileSize(String fileName) {
        File file = new File(fileName);
        return file.length();
    }

    // a method that returns the absolute path of a file
    static String absolutePath(String fileName) {
        File file = new File(fileName);
        return file.getAbsolutePath();
    }

    // a method that returns the canonical path of a file
    static String canonicalPath(String fileName) {
        File file = new File(fileName);
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return null;
    }

}