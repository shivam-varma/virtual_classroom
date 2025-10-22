package com.virtualclassroom;

import com.virtualclassroom.ui.RegisterFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterFrame());
    }
}
