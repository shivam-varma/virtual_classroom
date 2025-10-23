package Com.virtualclassroom.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Assignment implements Serializable {
    private String title;
    private String description;
    private LocalDate dueDate;
    private String teacherName;

    public Assignment(String title, String description, LocalDate dueDate, String teacherName) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.teacherName = teacherName;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate() { return dueDate; }
    public String getTeacherName() { return teacherName; }

    @Override
    public String toString() {
        return title + " (Due: " + dueDate + ")";
    }
}

