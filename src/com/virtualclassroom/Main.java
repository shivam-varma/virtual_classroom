package Com.virtualclassroom;

import javax.swing.SwingUtilities;

import Com.virtualclassroom.ui.RegisterFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterFrame());
    }
}
