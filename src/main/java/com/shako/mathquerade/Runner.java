package com.shako.mathquerade;

import com.shako.mathquerade.gui.MainWindow;

import javax.swing.SwingUtilities;

public class Runner {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
