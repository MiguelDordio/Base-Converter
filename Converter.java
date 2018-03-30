import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame{

    JButton button1;
    JLabel label1, label2, label3, label4;
    JTextField textField1, textField2, textField3;
    JTextArea textArea;
    int num, base, baseTo;


    public Main(){
        this.setSize(150, 275);
        this.setTitle("Base Converter");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        button1 = new JButton("Calculate");
        label1 = new JLabel("Number");
        label2 = new JLabel("Base");
        label3 = new JLabel("New Base");
        label4 = new JLabel("Result");
        textField1 = new JTextField("", 10);
        textField2 = new JTextField("", 10);
        textField3 = new JTextField("", 10);
        textArea = new JTextArea();

        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);

        panel.add(button1);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textArea);

        this.add(panel);
        this.setVisible(true);

    }

    private class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button1) {
                try {
                    num = Integer.parseInt(textField1.getText());
                    base = Integer.parseInt(textField2.getText());
                    baseTo = Integer.parseInt(textField3.getText());
                } catch (NumberFormatException excep) {
                    JOptionPane.showMessageDialog(Main.this, "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                if(base == 10){
                    textArea.setText(convertBase10(num, baseTo));
                }else{
                    char[] chars = ("" + num).toCharArray();
                    int tmp = convertoToBase10(chars ,base);
                    textArea.setText(convertBase10(tmp, baseTo));
                }
            }
        }
    }

    public static void main(String[] args){

        new Main();
    }

    private static String convertBase10(int num, int base){
        char[] trans = new char[8];
        int i = trans.length-1;
        while(num != 0){
            trans[i] = (char)(num % base + '0');
            num /= base;
            i--;
        }
        return String.valueOf(trans);
    }

    private static int convertoToBase10(char[] num, int base){
        double result = 0;
        int size = num.length-1;
        for(int i = 0; i < num.length; i++){
            result += Math.pow(base, size)*Integer.parseInt(String.valueOf(num[i]));
            size--;
        }
        return (int) Math.round(result);
    }
}
