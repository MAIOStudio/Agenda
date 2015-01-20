import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Clock extends JFrame implements ActionListener {

    private JLabel clockLabel;

    private Calendar calendar = Calendar.getInstance(); //Get calendar using this machine's current local
//	private int hour, minute, second;
    private int day;
    private String currentDate;

    public static void main(String[] args) {
        new Clock();
    }

    public Clock() {
        updateTime();
        clockLabel = new JLabel(currentDate); // + " " + hour + ":" + minute + ":" + second);

        add(clockLabel, BorderLayout.CENTER);

        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        new Timer(1000, this).start(); //Update every 1s, let this class listen
    }

    private void updateTime() {
        calendar.setTimeInMillis(System.currentTimeMillis()); //Update the calendar's time
//		hour = calendar.get( 11 ); //Calendar field 11 is hours
//		minute = calendar.get( 12 ); //Field 12
//		second = calendar.get( 13 ); //Field 13
        day = Calendar.DAY_OF_WEEK;
        currentDate = calendar.getTime().toString();
//                currentDate = Calendar.getInstance(Locale.ENGLISH).toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) { //A tick happened
        updateTime(); //Update time
        clockLabel.setText(currentDate); // + " " + hour + ":" + minute + ":" + second ); //Update label text
        repaint(); //Update gui
    }
}
