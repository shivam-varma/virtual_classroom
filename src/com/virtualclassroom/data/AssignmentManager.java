package Com.virtualclassroom.data;

import java.io.*;
import java.util.*;
import Com.virtualclassroom.model.Assignment;

public class AssignmentManager {
    private static final String FILE_PATH = "assignments.dat";

    public static void saveAssignment(Assignment assignment) {
        List<Assignment> list = loadAssignments();
        list.add(assignment);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Assignment> loadAssignments() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Assignment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
