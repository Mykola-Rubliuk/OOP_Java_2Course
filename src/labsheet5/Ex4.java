package labsheet5;

import javax.swing.JOptionPane;

public class Ex4 {
    public static void main(String[] args) {
        float x1, y1, radius, x2, y2;
        x1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Please enter the x co-ordinate of the circle's centre"));
        y1 = Float.parseFloat(JOptionPane.showInputDialog(null, "Please enter the y co-ordinate of the circle's centre"));
        radius = Float.parseFloat(JOptionPane.showInputDialog(null, "Please enter the radius of the circle"));
        x2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Please enter the x co-ordinate of the second point"));
        y2 = Float.parseFloat(JOptionPane.showInputDialog(null, "Please enter the y co-ordinate of the second point"));
        JOptionPane.showMessageDialog(null, String.format("The second point is located %s the circle", pointLocator(x1, y1, radius, x2, y2)));

    }

    private static String pointLocator(float x1, float y1, float r, float x2, float y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (distance > r) {
            return "outside";
        } else if (distance < r) {
            return "inside";
        }
        return "on";
    }
}
