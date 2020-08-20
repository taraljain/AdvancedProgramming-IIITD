package APRefresher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Assignment {
    HashMap<Date, List<Patient>> record;
    JFrame frame;
    JLabel instructions, date, towerSelect;
    JTextField textField;
    JCheckBox tower1, tower2, tower3, tower4;

    public Assignment() {
        record = new HashMap<>();
        record.put(new Date(2020, 4, 1), new ArrayList<>());
        record.get(new Date(2020, 4, 1)).add(new Patient("Flora", 6, "A", new Date(2020, 4,22)));
        record.get(new Date(2020, 4, 1)).add(new Patient("Denys", 24, "B", new Date(2020, 4,22)));

        record.put(new Date(2020, 5, 18), new ArrayList<>());
        record.get(new Date(2020, 5, 18)).add(new Patient("Jim", 42, "C", new Date(2020, 6, 8 )));

        record.put(new Date(2020, 6, 23), new ArrayList<>());
        record.get(new Date(2020, 6, 23)).add(new Patient("Hazel", 87, "D", new Date(2020, 7,14)));

        record.put(new Date(2020, 6, 1), new ArrayList<>());
        record.get(new Date(2020, 6, 1)).add(new Patient("Caery", 72, "A", new Date(2020,6,22)));
        record.get(new Date(2020, 6, 1)).add(new Patient("John", 95, "D",new Date(2020, 6, 22)));

        record.put(new Date(2020, 6, 14), new ArrayList<>());
        record.get(new Date(2020, 6, 14)).add(new Patient("David", 7, "B", new Date(2020, 7,5)));

        record.put(new Date(2020, 6, 5), new ArrayList<>());
        record.get(new Date(2020, 6, 5)).add(new Patient("Kevim", 37, "D", new Date(2020, 6,26)));

        record.put(new Date(2020, 6, 20), new ArrayList<>());
        record.get(new Date(2020, 6, 20)).add(new Patient("Tom", 67, "D", new Date(2020, 7, 11)));

        record.put(new Date(2020, 7, 4), new ArrayList<>());
        record.get(new Date(2020, 7, 4)).add(new Patient("Bob", 74, "A", new Date(2020, 7,25)));

        record.put(new Date(2020, 7, 24), new ArrayList<>());
        record.get(new Date(2020, 7, 24)).add(new Patient("Rachel", 48, "C", new Date(2020,8,14)));

        record.put(new Date(2020, 6, 11), new ArrayList<>());
        record.get(new Date(2020, 6, 11)).add(new Patient("Thomas", 21, "C", new Date(2020,7,2)));

        record.put(new Date(2020, 6, 21), new ArrayList<>());
        record.get(new Date(2020, 6, 21)).add(new Patient("Mary", 17, "D", new Date(2020, 7,12)));

        record.put(new Date(2020, 8, 7), new ArrayList<>());
        record.get(new Date(2020, 8, 7)).add(new Patient("Smith", 89, "A", new Date(2020,8,28)));

        record.put(new Date(2020, 6, 4), new ArrayList<>());
        record.get(new Date(2020, 6, 4)).add(new Patient("Pearson", 47, "B", new Date(2020,6, 25)));

        record.put(new Date(2020, 7, 27), new ArrayList<>());
        record.get(new Date(2020, 7, 27)).add(new Patient("Anderson", 62, "B", new Date(2020, 8, 17)));

        record.put(new Date(2020, 8, 1), new ArrayList<>());
        record.get(new Date(2020, 8, 1)).add(new Patient("Johnson", 10, "D", new Date(2020, 8, 22)));

        record.put(new Date(2020, 8, 9), new ArrayList<>());
        record.get(new Date(2020, 8, 9)).add(new Patient("Robertz", 50, "A", new Date(2020,8,30)));

        record.put(new Date(2020, 5, 2), new ArrayList<>());
        record.get(new Date(2020, 5, 2)).add(new Patient("Julie", 86, "B", new Date(2020, 5, 23)));

        record.put(new Date(2020, 6, 7), new ArrayList<>());
        record.get(new Date(2020, 6, 7)).add(new Patient("Edith", 42, "D", new Date(2020, 6, 28)));


        frame = new JFrame("Coronavirus Record Tracker");
        instructions = new JLabel("PRESS ENTER AFTER FILLING DATE");
        textField = new JTextField();
        date = new JLabel("DATE:");
        towerSelect = new JLabel("SELECT THE TOWER (ONE AT A TIME)");
        tower1 = new JCheckBox("Tower A");
        tower2 = new JCheckBox("Tower B");
        tower3 = new JCheckBox("Tower C");
        tower4 = new JCheckBox("Tower D");

        instructions.setBounds(205,290,400,50);
        tower1.setBounds(100,70,100,50);
        tower2.setBounds(100,110, 100,50);
        tower3.setBounds(100,150, 100,50);
        tower4.setBounds(100,190, 100,50);
        towerSelect.setBounds(50,5,250,100);
        textField.setBounds(100,260,150,30);
        date.setBounds(50,260, 80,30);

        frame.add(date);
        frame.add(instructions);
        frame.add(towerSelect);
        frame.add(textField);
        frame.add(tower1); frame.add(tower2); frame.add(tower3); frame.add(tower4);
        final String[] dateEntry = {""};

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateEntry[0] = textField.getText();

                try {
                    String date[] = dateEntry[0].split("/");
                    Date d = new Date(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));

                    if(tower1.isSelected()){
                        printDetails(d, "A");
                    }
                    else if(tower2.isSelected()){
                        printDetails(d, "B");
                    }
                    else if(tower3.isSelected()){
                        printDetails(d, "C");
                    }
                    else if(tower4.isSelected()){
                        printDetails(d, "D");
                    }
                }
                catch(Exception ex){
                     JOptionPane.showMessageDialog(frame, "ERROR DETECTED IN DATE INPUT");
                }
            }
        });

        frame.setLayout(null);
        frame.setSize(350,350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    class Patient {
        private String name;
        private int age;
        private String tower;
        private Date recoveryDate;

        Patient(String _name, int _age, String _tower, Date _recoveryDate) {
            this.name = _name;
            this.age = _age;
            this.tower = _tower;
            this.recoveryDate = _recoveryDate;
        }
    }

    public void printDetails(Date d, String t) {

        if (d.getDate()<0 || d.getDate()>31 || d.getMonth() < 4 || d.getMonth() > 8 || d.getYear() != 2020) {
            JOptionPane.showMessageDialog(null, "DATES MUST BE BETWEEN (1 APRIL 2020 - 31 AUGUST 2020)", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            int active = 0;
            int activeOverall = 0;
            int recovered = 0;
            int recoveredOverall = 0;

            List<Patient> resultData = new ArrayList<>();
            for(Date date2 : record.keySet()){
                if(date2.compareTo(d)<=0){
                    List<Patient> list = record.get(date2);
                    for (Patient p : list) {
                        int factor = d.compareTo(p.recoveryDate);
                        if (p.tower.equals(t)) {
                            resultData.add(p);
                            if (factor >= 0) recovered++;
                            else active++;
                        }
                    }
                }
            }
            if(resultData.size()==0){
                JOptionPane.showMessageDialog(frame, "NO PATIENT AVAILABLE FOR DISPLAY");
            }
            else{
                String[][] result = new String[resultData.size()][5];
                for (int i = 0; i < resultData.size(); i++) {
                    result[i][0] = (resultData.get(i).recoveryDate.compareTo(d)<=0) ? "Recovered" : "Active";
                    result[i][1] = resultData.get(i).name;
                    result[i][2] = String.valueOf(resultData.get(i).age);
                    result[i][3] = resultData.get(i).recoveryDate.getDate() + "/" + resultData.get(i).recoveryDate.getMonth() + "/" + resultData.get(i).recoveryDate.getYear();
                    result[i][4] = t;
                }

                String[] column = {"STATUS", "NAME", "AGE", "RECOVERY DATE", "TOWER"};
                JFrame frameResult = new JFrame("RESULT");
                JTable jt = new JTable(result, column);
                jt.setBounds(10, 10, 200, 200);
                JScrollPane sp = new JScrollPane(jt);
                frameResult.setSize(600, 300);
                frameResult.add(sp);
                frameResult.setVisible(true);
            }

            for (List<Patient> l : record.values()) {
                for (Patient p : l) {
                    int factor = d.compareTo(p.recoveryDate);
                    if (factor >= 0) recoveredOverall++;
                    else activeOverall++;
                }
            }
            JOptionPane.showMessageDialog(frame, "TOTAL ACTIVE CASES IN SELECTED TOWER: " + active + "\nTOTAL RECOVERED CASES IN SELECTED TOWER: " + recovered + "\nTOTAL ACTIVE CASES IN ALL TOWERS: " + activeOverall + "\nTOTAL RECOVERED CASES IN ALL TOWERS: " + recoveredOverall);
        }
    }

    public static void main(String[] args) {
        new Assignment();
    }
}