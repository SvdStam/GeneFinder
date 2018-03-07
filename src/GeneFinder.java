import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;

public class GeneFinder extends JFrame implements ActionListener {
    private JTextArea invoer1, invoer2, invoer3, uitkomst;
    private JButton calculate;
    private JComboBox dropDown;


    public static void main(String[] args) {
        GeneFinder frame = new GeneFinder();
        frame.setSize(650, 550);
        frame.setTitle("Gene Finder Beta");
        frame.createGUI();
        frame.setVisible(true);
    }

    public void createGUI() {
        this.setDefaultCloseOperation(3);
        Container window = this.getContentPane();
        window.setLayout(null);

        String[] dropList = {"overeenkomst 1, 2 & 3", "overeenkomst 1 & 2", "overeenkomst 2 & 3", "overeenkomst 1 & 3"};
        dropDown = new JComboBox(dropList);
        dropDown.setBounds(30, 300, 200, 20);
        dropDown.setSelectedIndex(3);
        dropDown.addActionListener(this);
        window.add(dropDown);

        invoer1 = new JTextArea();
        invoer1.setBounds(30, 30, 150, 250);
        window.add(invoer1);

        invoer2 = new JTextArea();
        invoer2.setBounds(200, 30, 150, 250);
        window.add(invoer2);

        invoer3 = new JTextArea();
        invoer3.setBounds(370, 30, 150, 250);
        window.add(invoer3);

        uitkomst = new JTextArea();
        uitkomst.setBounds(30, 330, 490, 100);
        window.add(uitkomst);

        calculate = new JButton("Calculate");
        calculate.setBounds(500, 290, 110, 20);
        calculate.addActionListener(this);
        window.add(calculate);
    }

    public void actionPerformed(ActionEvent event) {

        HashSet<String> overeenkomst, genes1, genes2, genes3;
        genes1 = new HashSet<String>(Arrays.asList(invoer1.getText().toUpperCase().split("\n")));
        genes2 = new HashSet<String>(Arrays.asList(invoer2.getText().toUpperCase().split("\n")));
        genes3 = new HashSet<String>(Arrays.asList(invoer3.getText().toUpperCase().split("\n")));
        String dropList = (String)dropDown.getSelectedItem();

        if (event.getSource() == calculate) {
            if (dropList.equals("overeenkomst 1, 2 & 3")) {
                overeenkomst = new HashSet<String>(genes1);
                overeenkomst.retainAll(genes2);
                overeenkomst.retainAll(genes3);
                //System.out.println(overeenkomst);
                uitkomst.setText("overeenkomstige genen tussen alle 3 de invoervelden: " + overeenkomst);
            } else if (dropList.equals("overeenkomst 1 & 2")) {
                overeenkomst = new HashSet<String>(genes1);
                overeenkomst.retainAll(genes2);
                uitkomst.setText("overeenkomstige genen tussen 1 en 2: " + overeenkomst);
            } else if (dropList.equals("overeenkomst 1 & 3")) {
                overeenkomst = new HashSet<String>(genes1);
                overeenkomst.retainAll(genes3);
                uitkomst.setText("overeenkomstige genen tussen 1 en 3: " + overeenkomst);
            } else if (dropList.equals("overeenkomst 2 & 3")) {
                overeenkomst = new HashSet<String>(genes2);
                overeenkomst.retainAll(genes3);
                uitkomst.setText("overeenkomstige genen tussen 2 en 3: " + overeenkomst);
            }

        }
    }
}
