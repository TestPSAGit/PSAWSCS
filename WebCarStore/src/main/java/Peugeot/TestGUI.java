/*
 * Creation : 23 avr. 2019
 */
package Peugeot;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class TestGUI {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestGUI window = new TestGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * Create the application.
     */
    public TestGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JComboBox CountryCheckBox = new JComboBox();
        CountryCheckBox.setBounds(10, 11, 204, 20);
        frame.getContentPane().add(CountryCheckBox);
        CountryCheckBox.setEditable(true);
        CountryCheckBox.addItem("<Please select a Country>");
        CountryCheckBox.addItem("France");
        CountryCheckBox.addItem("Italy");
        CountryCheckBox.addItem("Spain");
        CountryCheckBox.addItem("Belgium FR");
        CountryCheckBox.addItem("Belgium NL");
        CountryCheckBox.addItem("Germany");
        CountryCheckBox.addItem("ALL");

        JComboBox EnvironementCheckBox = new JComboBox();
        EnvironementCheckBox.setBounds(10, 42, 204, 20);
        frame.getContentPane().add(EnvironementCheckBox);
        EnvironementCheckBox.addItem("<Please select an Environement>");
        EnvironementCheckBox.addItem("Prod");
        EnvironementCheckBox.addItem("PreProd");
        EnvironementCheckBox.addItem("ALL");

        JComboBox BrandCheckBox = new JComboBox();
        BrandCheckBox.setBounds(10, 73, 204, 20);
        frame.getContentPane().add(BrandCheckBox);
        BrandCheckBox.addItem("<Please select a Brand>");
        BrandCheckBox.addItem("Peugoet");
        BrandCheckBox.addItem("Citoën");
        BrandCheckBox.addItem("DS");

        JButton TestButton = new JButton("Test");

        TestButton.setBounds(57, 157, 89, 23);
        frame.getContentPane().add(TestButton);

        JComboBox TestItemsComboBox = new JComboBox();
        TestItemsComboBox.setBounds(10, 104, 204, 20);
        frame.getContentPane().add(TestItemsComboBox);
        TestItemsComboBox.addItem("<Please select an item to test>");
        TestItemsComboBox.addItem("HomePageComponets");
        TestItemsComboBox.addItem("HomePageSerchModel");
        TestItemsComboBox.addItem("ResultPage");
        TestItemsComboBox.addItem("ProductPageLeads");

    }
}
