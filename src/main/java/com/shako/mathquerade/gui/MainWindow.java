package com.shako.mathquerade.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static com.shako.mathquerade.R.MATHQUERADE_TITLE;

public class MainWindow extends JFrame {

    private BorderLayoutFactory layoutFactory = BorderLayoutFactory.create();
    private CanvasFactory canvasFactory = CanvasFactory.get();
    private LabelFactory labelFactory = LabelFactory.get();
    private PanelFactory panelFactory = PanelFactory.get();

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(700, 500, 500, 500);
        setTitle(MATHQUERADE_TITLE);

        Label label = LabelFactory.label().text("mathquerade").build();
        getContentPane().add(label);
        setVisible(true);
    }
}

class BorderLayoutFactory {

    private BorderLayout layout;

    private BorderLayoutFactory() {
        layout = new BorderLayout();
    }
    static BorderLayoutFactory create() {
        return new BorderLayoutFactory();
    }

    BorderLayoutFactory hgap(int hgap) {
        layout.setHgap(hgap);
        return this;
    }

    BorderLayoutFactory vgap(int vgap) {
        layout.setVgap(vgap);
        return this;
    }

    BorderLayoutFactory center(Component component) {
        layout.addLayoutComponent(component, BorderLayout.CENTER);
        return this;
    }

    BorderLayoutFactory north(Component component) {
        layout.addLayoutComponent(component, BorderLayout.NORTH);
        return this;
    }

    BorderLayout build() {
        return layout;
    }
}

class CanvasFactory {

    private static CanvasFactory canvasFactory = new CanvasFactory();
    private static Map<String, Canvas> data = new HashMap<>();
    private static int count = 0;

    static CanvasFactory get() {
        return canvasFactory;
    }

    CanvasFactory canvas() {
        data.put(String.valueOf(++count), new Canvas());
        return canvasFactory;
    }

    Canvas build() {
        return data.get(String.valueOf(count));
    }
}

class Canvas extends JComponent {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.GREEN);
        g2d.drawRect(100, 100, 80, 20);
        g2d.setPaint(Color.RED);
        g2d.drawString("mathquerade", 150, 150);
        g2d.setPaint(Color.BLUE);
        g2d.fillOval(200, 50, 50, 20);

        super.repaint();
    }
}

class PanelFactory {

    private static PanelFactory panelFactory = new PanelFactory();
    private static Map<String, Panel> data = new HashMap<>();
    private static int count = 0;

    private PanelFactory() {

    }

    static PanelFactory get() {
        return panelFactory;
    }

    PanelFactory panel() {
        data.put(String.valueOf(++count), Panel.create());
        return panelFactory;
    }

    Panel build() {
        return data.get(String.valueOf(count));
    }
}

class Panel extends JPanel {

    private static Panel panel;

    private Panel() {

    }

    static Panel create() {
        panel = new Panel();
        return panel;
    }

    static Panel background(Color color) {
        return panel;
    }
}

class LabelFactory {

    private static LabelFactory labelFactory = new LabelFactory();
    private static Map<String, Label> data = new HashMap<>();
    private static int count = 0;

    private LabelFactory(){

    }

    static LabelFactory get() {
        return labelFactory;
    }

    static LabelFactory text(String text) {
        data.get(String.valueOf(count)).setText(text);
        return labelFactory;
    }

    static LabelFactory label() {
        data.put(String.valueOf(++count), Label.build());
        return labelFactory;
    }

    static Label build() {
        return data.get(String.valueOf(count));
    }
}

class Label extends JLabel {

    static Label build() {
        return new Label();
    }
}