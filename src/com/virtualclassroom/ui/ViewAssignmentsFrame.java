package Com.virtualclassroom.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Com.virtualclassroom.data.AssignmentManager;
import Com.virtualclassroom.model.Assignment;
import Com.virtualclassroom.model.User;

public class ViewAssignmentsFrame extends JFrame {

    public ViewAssignmentsFrame(User student) {
        setTitle("Available Assignments");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Assignment> assignments = AssignmentManager.loadAssignments();

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Assignment a : assignments) {
            model.addElement(a.toString());
        }

        JList<String> list = new JList<>(model);
        add(new JScrollPane(list), BorderLayout.CENTER);

        setVisible(true);
    }
}
