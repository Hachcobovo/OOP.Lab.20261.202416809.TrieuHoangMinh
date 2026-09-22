import javax.swing.JOptionPane;
public class EquationSolver {
    public static void main(String[] args) {
        String[] options = {"Linear Equation", "2x2 System", "Quadratic Equation"};

        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Equation Solver", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                solveLinear();
                break;

            case 1:
                solveSystem();
                break;

            case 2:
                solveQuadratic();
                break;

            default:
                System.exit(0);
        }
    }

    static void solveLinear() {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input a: ","Input the first coefficient",JOptionPane.INFORMATION_MESSAGE));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input b: ","Input the second coefficient",JOptionPane.INFORMATION_MESSAGE));
        String strNotification;

        if (a == 0) {
            strNotification = "Not a valid linear equation!";
            JOptionPane.showMessageDialog(null, strNotification, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            double res = (-1) * (b / a);
            strNotification = "The root of " + a + "x + " + b + " = 0 is " + String.format("%.2f", res);
            JOptionPane.showMessageDialog(null, strNotification, "Show root", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    static void solveSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input a11: ","Input the first coefficient",JOptionPane.INFORMATION_MESSAGE));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input a12: ","Input the second coefficient",JOptionPane.INFORMATION_MESSAGE));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input b1: ","Input the third coefficient",JOptionPane.INFORMATION_MESSAGE));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input a21: ","Input the forth coefficient",JOptionPane.INFORMATION_MESSAGE));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input a22: ","Input the fifth coefficient",JOptionPane.INFORMATION_MESSAGE));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input b2: ","Input the sixth coefficient",JOptionPane.INFORMATION_MESSAGE));

        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - a12 * b2;
        double D2 = a11 * b2 - b1 * a21;
        final double EPS = 1e-9;

        if (Math.abs(D) > EPS) {
            double x = D1 / D;
            double y = D2 / D;

            String strNotification = "The root is\n" + "x = " + String.format("%.2f", x) + "\n" + "y = " + String.format("%.2f", y);
            JOptionPane.showMessageDialog(null, strNotification, "Show root", JOptionPane.INFORMATION_MESSAGE);

        }
        else if (Math.abs(D) <= EPS && Math.abs(D1) <= EPS && Math.abs(D2) <= EPS) {
            JOptionPane.showMessageDialog(null, "Infinitely many solutions", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "No solution", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    static void solveQuadratic() {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input a: ","Input the first coefficient",JOptionPane.INFORMATION_MESSAGE));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input b: ","Input the second coefficient",JOptionPane.INFORMATION_MESSAGE));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Please input c: ","Input the third coefficient",JOptionPane.INFORMATION_MESSAGE));
        final double EPS = 1e-9;

        double delta = b*b - 4*a*c;

        if (a == 0) {
            if (b== 0) {
                if (c != 0) {JOptionPane.showMessageDialog(null, "Invalid equation", "Error", JOptionPane.ERROR_MESSAGE);}
                else {JOptionPane.showMessageDialog(null, "Infinitely many solutions", "Error", JOptionPane.ERROR_MESSAGE);}
            }
            else {
                String strNotification = "The root is " + String.format("%.2f", (-1) * c/b);
                JOptionPane.showMessageDialog(null, strNotification, "Show root", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (delta < 0) {
            JOptionPane.showMessageDialog(null, "No real solution", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else if (delta <= EPS) {
            String strNotification = "The double root is " + String.format("%.2f", (-1) * b / (2*a));
            JOptionPane.showMessageDialog(null, strNotification, "Show double root", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            double x1 = (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2*a);
            String strNotification = "The root is: \nx1 = " + String.format("%.2f", x1) + "\nx2 = " + String.format("%.2f", x2);
            JOptionPane.showMessageDialog(null, strNotification, "Show root", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}