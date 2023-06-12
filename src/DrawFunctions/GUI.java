package DrawFunctions;

import jserver.*;
import plotter.Graphic;
import plotter.Plotter;
import utils.InputUnitD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private Graphic graphic = new Graphic("Zeichen von Funktionen");
    private Plotter plotter = graphic.getPlotter();
    private JLabel formula = new JLabel();
    private double  range = 2 * Math.PI;

private InputUnitD paramA = new InputUnitD(graphic, "Parameter a:", 1.0, "south");
private  InputUnitD paramB = new InputUnitD(graphic, "Parameter b:", 1.0, "south");

    public GUI() {
        setup();
    }

    private void setup() {
        graphic.setTitle("Zeichnen von Funktionen");

        addButtons();

        plotter.setRange(-1 * range, range);
        graphic.pack();
    }

    private void addButtons() {
        JButton sinusButton = new JButton("Sinus");
        JButton cosinusButton = new JButton("Cosinus");
        JButton arcsinButton = new JButton("Arcus-Sinus");
        JButton arccosButton = new JButton("Arcus-Cosinus");
        JButton deleteButton = new JButton("Löschen");

        sinusButton.addActionListener(this);
        cosinusButton.addActionListener(this);
        arcsinButton.addActionListener(this);
        arccosButton.addActionListener(this);
        deleteButton.addActionListener(this);

        graphic.addEastComponent(sinusButton);
        graphic.addEastComponent(cosinusButton);
        graphic.addEastComponent(arcsinButton);
        graphic.addEastComponent(arccosButton);
        graphic.addEastComponent(deleteButton);
    }

    private void drawSinus() {
        plotter.removeAll();

        double a = paramA.getValue();
        double b = paramB.getValue();

        for (double x = -1 * range; x < range; x+= 0.05) {
            plotter.add(x, a * Math.sin(x * b));
        }

        graphic.repaint();
    }
    private void drawCosinus() {
        plotter.removeAll();

        double a = paramA.getValue();
        double b = paramB.getValue();

        for (double x = -1 * range; x < range; x+= 0.05) {
            plotter.add(x, a * Math.cos(x * b));
        }

        graphic.repaint();
    }
    private void drawArcsin() {
        plotter.removeAll();

        double a = paramA.getValue();
        double b = paramB.getValue();

        for (double x = -1 * range; x < range; x+= 0.05) {
            plotter.add(x, a * Math.asin(x * b));
        }

        graphic.repaint();
    }
    private void drawArccos() {
        plotter.removeAll();

        double a = paramA.getValue();
        double b = paramB.getValue();

        for (double x = -1 * range; x < range; x+= 0.05) {
            plotter.add(x, a * Math.acos(x * b));
        }

        graphic.repaint();
    }
    private void clearPlotter() {
        plotter.removeAll();
        graphic.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println("cmd" + cmd);
        if (cmd.equals("Sinus")) {
            drawSinus();
        } else if (cmd.equals("Cosinus")) {
            drawCosinus();
        } else if (cmd.equals("Arcus-Sinus")) {
            drawArcsin();
        } else if (cmd.equals("Arcus-Cosinus")) {
            drawArccos();
        } else if (cmd.equals("Löschen")) {
            clearPlotter();
        }
    }
}
