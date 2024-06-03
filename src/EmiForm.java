import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EmiForm extends JFrame{
    private JPanel mainPanel;
    private JLabel P;
    private JLabel N;
    private JLabel R;
    private JSpinner principal;
    private JSpinner period;
    private JSlider rate;
    private JButton calculateEMIButton;

    public EmiForm(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        setContentPane(mainPanel);
        setTitle("EMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        setResizable(false);
        principal.setModel(new SpinnerNumberModel(0.00, 0.00, 50000000, 0.01));
        period.setModel(new SpinnerNumberModel(0.00, 0.00, 10.00, 0.01));
        setVisible(true);
        calculateEMIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double p =(double) principal.getValue();
                double n =(double) period.getValue();
                double r = rate.getValue();
                n = n*12;
                r = r/(1200);
                double x = Math.pow(1+r,n);
                double emi = p*r*x/(x-1);
                String output = String.format("EMI Calculated is %.2f INR",emi);
                JOptionPane.showMessageDialog(EmiForm.this,output);
            }
        });
    }

    public static void main(String[] args){
        FlatDarkLaf.setup();
        new EmiForm();
    }
}
