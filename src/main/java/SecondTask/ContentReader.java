package SecondTask;

import FirstTask.search.FileContentReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

import static SecondTask.User.JSON;
import static SecondTask.User.TXT;


public class ContentReader implements FileContentReader {
    @Override
    public String read(File file) {
        StringJoiner result = new StringJoiner("\n");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static String deleteEmptyLines(String s){
        String[] split = s.split("\n");
        StringJoiner a = new StringJoiner("\n");
        for (int i = 0; i < split.length; i++){
            if (!split[i].trim().isEmpty()){
                a.add(split[i]);
            }
        }
        return String.valueOf(a);
    }


    public static void createUsers(ArrayList<User> users, String[] linesArray) throws IOException {
        try {
            for (int i = 1; i < linesArray.length; i++) {
                String[] buffer = linesArray[i].split(" ");
                String name = buffer[0];
                int age = Integer.parseInt(buffer[1]);
                users.add(new User(name, age));
            }
            users.trimToSize();
        } catch (RuntimeException e) {
            e.getStackTrace();
        }
    }

    private static void writeToJson(String jsonUser, File jsonFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(jsonFile))) {
            bufferedWriter.write(jsonUser);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String[] declarationStaff(){
        ContentReader contentReader = new ContentReader();
        String result = contentReader.read(new File(TXT));
        String newResult = deleteEmptyLines(result);
        String[] split = newResult.split("\n");
        return split;
    }


    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ArrayList<User> users = new ArrayList<>();
        String[] split = declarationStaff();
        createUsers(users, split);
        writeToJson(gson.toJson(users), new File(JSON));
    }
}

