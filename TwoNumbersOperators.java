import javax.swing.JOptionPane;
public class TwoNumbersOperators {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double dif = num1 - num2;
        double prod = num1 * num2;

        strNotification = "The sum of " + strNum1 + " and " + strNum2 + " is: " + String.format("%.2f", sum);
        JOptionPane.showMessageDialog(null, strNotification, "Show sum", JOptionPane.INFORMATION_MESSAGE);
        
        strNotification = "The difference of " + strNum1 + " and " + strNum2 + " is: " + String.format("%.2f", dif);
        JOptionPane.showMessageDialog(null, strNotification, "Show difference", JOptionPane.INFORMATION_MESSAGE);

        strNotification = "The product of " + strNum1 + " and " + strNum2 + " is: " + String.format("%.2f", prod);
        JOptionPane.showMessageDialog(null, strNotification, "Show product", JOptionPane.INFORMATION_MESSAGE);

        if (num2 == 0) {
            strNotification = "Cannot divide by zero";
            JOptionPane.showMessageDialog(null, strNotification, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            strNotification = "The quotient of " + strNum1 + " and " + strNum2 + " is " + String.format("%.2f", num1 / num2);
            JOptionPane.showMessageDialog(null, strNotification, "Show quotient", JOptionPane.INFORMATION_MESSAGE);
        }

        System.exit(0);
    }
}