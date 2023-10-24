import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class TabPanel extends JFrame implements ActionListener{
    JTextField textField;
    JButton[] numberedButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Comic Sans",Font.BOLD, 30);
    double num1=0, num2=0, result=0;
    char operator;
    TabPanel() {
        // Set the frame
        JFrame frame = new JFrame("Tab Panel");
        frame.setLayout(new GridLayout(1,1));

        // Initialize the tabbed panel
        JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);

        frame.add(tab); // Adding the tabbed panel

        // Adding new panel for each task
        JPanel panel1 = new JPanel();

        String itemsOpt[] = {"Vanilla", "Chocolate", "Strawberry", "Matcha"};
        JComboBox dropdown = new JComboBox(itemsOpt);
        panel1.add(dropdown);

        JPanel panel2 = new JPanel();

        String rows[][] = { {"1", "Alpha", "20"},
                {"2", "Beta", "38"},
                {"3", "Gamma", "17"},
                {"4", "Delta", "25"},
                {"5", "Epsilon", "28"},
                {"6", "Zeta", "31"},
                {"7", "Eta", "33"}};
        String column[] = {"No", "Title" ,"Count"};
        JTable table = new JTable(rows, column);

        panel2.add(new JScrollPane(table));

        //panel3 calculator
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        panel3.add(textField, BorderLayout.NORTH);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberedButtons[i] = new JButton(String.valueOf(i));
            numberedButtons[i].addActionListener(this);
            numberedButtons[i].setFont(myFont);
            numberedButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 75, 50);
        delButton.setBounds(130, 430, 107, 50);
        clrButton.setBounds(240, 430, 108, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberedButtons[1]);
        panel.add(numberedButtons[2]);
        panel.add(numberedButtons[3]);
        panel.add(addButton);
        panel.add(numberedButtons[4]);
        panel.add(numberedButtons[5]);
        panel.add(numberedButtons[6]);
        panel.add(subButton);
        panel.add(numberedButtons[7]);
        panel.add(numberedButtons[8]);
        panel.add(numberedButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberedButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        panel3.add(panel, BorderLayout.CENTER);
        panel3.add(negButton, BorderLayout.WEST);
        panel3.add(delButton, BorderLayout.SOUTH);
        panel3.add(clrButton, BorderLayout.EAST);

        tab.addTab("Panel 1", panel1);
        tab.addTab("Panel 2", panel2);
        tab.addTab("Panel 3", panel3);

        frame.setSize(500,550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        setLayout(null);
    }

    public static void main(String[] args) {
        new TabPanel();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<10; i++){
            if(e.getSource() == numberedButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
