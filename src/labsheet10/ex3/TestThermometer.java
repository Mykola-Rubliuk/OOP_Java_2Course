package labsheet10.ex3;

import javax.swing.*;
import java.awt.*;

class TestThermometer {
    public static void main(String[] args) {
        String text = "";
        Thermometer thermometer1 = new Thermometer(35);
        text += """
                *****Thermometer Testing*****
                Calling the single-argument constructor...setting the temperature of first thermometer to 35C
                First Thermometer:
                """ + thermometer1;
        Thermometer thermometer2 = new Thermometer();
        text += """
                Calling the no-argument constructor...setting the temperature of first thermometer to 0C
                Second Thermometer:
                """ + thermometer2;
        thermometer2.setTemperature(25);
        text += """
                Calling setTemperature()...setting the temperature of first thermometer to 25C
                First Thermometer:
                """ + thermometer2;

        JOptionPane.showMessageDialog(null, text);


        initArea();
        int newTemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the current temperature of the first thermometer: "));
        thermometer1.setTemperature(newTemp);
        text = String.format("""
                *****Thermometer Testing*****
                Calling setTemperature()...setting the temperature of first thermometer to %sC
                First Thermometer:
                """, newTemp) + thermometer1;

        JOptionPane.showMessageDialog(null, text);


    }

    public static void initArea() {
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
    }

}

