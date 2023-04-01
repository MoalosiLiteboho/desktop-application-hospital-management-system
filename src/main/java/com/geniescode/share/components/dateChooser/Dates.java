package com.geniescode.share.components.dateChooser;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public final class Dates extends JPanel {

    private Event event;
    private final int MONTH;
    private final int YEAR;
    private final int DAY;
    private int m;
    private int y;
    private int selectDay = 0;
    private int startDate;
    private int max_of_month;

    public Dates() {
        initComponents();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        DAY = Integer.parseInt(toDay.split("-")[0]);
        MONTH = Integer.parseInt(toDay.split("-")[1]);
        YEAR = Integer.parseInt(toDay.split("-")[2]);
    }

    public void showDate(int month, int year, SelectedDate select) {
        m = month;
        y = year;
        // selectDay = 0;
        Calendar cd = Calendar.getInstance();
        cd.set(year, month - 1, 1);
        int start = cd.get(Calendar.DAY_OF_WEEK);
        max_of_month = cd.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (start == 1) {
            start += 7;
        }
        clear();
        start += 5;
        startDate = start;
        for (int i = 1; i <= max_of_month; i++) {
            Button cmd = (Button) getComponent(start);
            cmd.setColorSelected(getForeground());
            cmd.setText(i + "");
            if (i == DAY && month == MONTH && year == YEAR) {
                cmd.setBackground(new Color(224, 214, 229));
            } else {
                cmd.setBackground(Color.WHITE);
            }
            if (i == select.getDay() && month == select.getMonth() && year == select.getYear()) {
                cmd.setBackground(getForeground());
                cmd.setForeground(new Color(255, 255, 255));
            }
            start++;
        }
    }

    private void clear() {
        for (int i = 7; i < getComponentCount(); i++) {
            ((JButton) getComponent(i)).setText("");
        }
    }

    public void clearSelected() {
        for (int i = 7; i < getComponentCount(); i++) {
            JButton cmd = (JButton) getComponent(i);
            if (MONTH == m && y == YEAR && !cmd.getText().equals("") && Integer.parseInt(cmd.getText()) == DAY) {
                cmd.setBackground(new Color(224, 214, 229));
                cmd.setForeground(new Color(75, 75, 75));
            } else {
                cmd.setBackground(Color.WHITE);
                cmd.setForeground(new Color(75, 75, 75));
            }
        }
        selectDay = 0;
    }

    private void addEvent() {
        for (int index = 7; index < getComponentCount(); index++)
            ((Button) getComponent(index)).setEvent(event);
    }

    public void setSelected(int index) {
        selectDay = index;
    }

    private void initComponents() {
        setBackground(Color.white);
        setLayout(new GridLayout(7, 7));

        addDayNames();
        addSpaceDay(2);
        addDays();
        addSpaceDay(9);
    }

    private void addDayNames() {
        String[] dayNames = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
        for (int index = 0; index < 7; index++) {
            Button dayButton = new Button();
            dayButton.setBorder(BorderFactory.createEmptyBorder(1, 1, 5, 1));
            dayButton.setText(dayNames[index]);

            if("Su".equals(dayNames[index])) dayButton.setForeground(Color.red);
            else dayButton.setForeground(Color.gray);

            add(dayButton);
        }
    }

    private void addDays() {
        for (int index = 0; index < 31; index++) {
            Button dayButton = new Button();
            dayButton.setBackground(Color.white);
            dayButton.setForeground(Color.gray);
            dayButton.setText(String.valueOf(index + 1));
            dayButton.setName("day");
            add(dayButton);
        }
    }

    private void addSpaceDay(int numberOfSpace) {
        for (int index = 0; index < numberOfSpace; index++) {
            Button spaceDay = new Button();
            spaceDay.setBackground(Color.white);
            spaceDay.setForeground(Color.gray);
            spaceDay.setName("day");
            add(spaceDay);
        }
    }

    public void setEvent(Event event) {
        this.event = event;
        addEvent();
    }

    public void next() {
        if (selectDay == max_of_month) {
            selectDay = 0;
        }
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay + 1);
        String n = cmd.getText();
        if (!n.equals("") && Integer.parseInt(n) <= max_of_month) {
            selectDay++;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void back() {
        if (selectDay <= 1) {
            selectDay = max_of_month + 1;
        }
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay - 1);
        String n = cmd.getText();
        if (!n.equals("") && cmd.getName() != null) {
            selectDay--;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void up() {
        JButton cmd = (JButton) getComponent(startDate - 1 + selectDay - 7);
        String n = cmd.getText();
        if (!n.equals("") && cmd.getName() != null) {
            selectDay -= 7;
            event.execute(null, selectDay);
            cmd.setBackground(new Color(206, 110, 245));
        }
    }

    public void down() {
        if (getComponents().length > startDate - 1 + selectDay + 7) {
            JButton cmd = (JButton) getComponent(startDate - 1 + selectDay + 7);
            String n = cmd.getText();
            if (!n.equals("") && cmd.getName() != null) {
                selectDay += 7;
                event.execute(null, selectDay);
                cmd.setBackground(new Color(206, 110, 245));
            }
        }
    }

}
