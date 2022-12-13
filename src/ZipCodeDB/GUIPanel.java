package ZipCodeDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPanel extends JPanel {
    private JTextField zipcode;
    private JButton submit;
    private JButton northest;
    private JTextArea output;

    private Database db;

    public GUIPanel() {
        this.zipcode = new JTextField("",7);
        this.add(this.zipcode);

        this.submit = new JButton("Submit");
        this.add(this.submit);
        this.submit.addActionListener(new SubmitButtonListener());

        this.northest = new JButton("Northernmost");
        this.add(this.northest);
        this.northest.addActionListener(new NorthernmostButtonListener());

        this.output = new JTextArea(15, 60);
        this.add(this.output);

        this.db = new Database(); // load the zipcodes
    }

    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // get the zipcode out of the text field
            final String code = zipcode.getText();

            ZipCode zc = db.search(code);
            output.setText(zc.getWeatherData().toString());
        }
    }

    class NorthernmostButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ZipCode zc = db.getNorthern();
            output.setText(zc.toString());
        }
    }
}
