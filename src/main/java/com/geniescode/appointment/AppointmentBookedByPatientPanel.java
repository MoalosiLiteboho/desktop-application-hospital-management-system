package com.geniescode.appointment;

import com.geniescode.share.components.buttons.Button;
import com.geniescode.share.components.comboBox.ComboBox;
import com.geniescode.share.components.dateChooser.DateChooserField;
import com.geniescode.share.components.panel.Panel;
import com.geniescode.user.GetUserListByAuthority;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class AppointmentBookedByPatientPanel extends Panel {
    private final List<String> doctorList = new GetUserListByAuthority().apply("Doctor");
    private final int patientId;
    private ComboBox<String> doctorComboBox;
    private DateChooserField appointmentDate;
    private Button reset;
    private Button bookAppointment;

    public AppointmentBookedByPatientPanel() {
        patientId = 3185922;
        initComponents();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("Booking Appointment");
        doctorComboBox = new ComboBox<>("Available Doctors", Color.green);
        appointmentDate = new DateChooserField("Appointment Date (yyyy-mm-dd)", Color.green);
        bookAppointment = new Button("Book Appointment");
        reset= new Button("Reset");

        doctorComboBox.addModels(doctorList);
        doctorComboBox.setSelectedIndex(-1);

        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setForeground(Color.green);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 20px");
        add(doctorComboBox, "width 60%, gap left 20%, gap top 25px");
        add(appointmentDate, "width 60%, gap left 20%, gap top 5px");
        add(bookAppointment, "width 30%, height 35px, gap left 35%, gap top 20px");
        add(reset, "width 30%, height 35px, gap left 35%, gap top 6px");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
        addController.accept(this);
    }

    private final Consumer<AppointmentBookedByPatientPanel> addController = AppointmentBookedByPatientController::new;

    public void addAppointmentBookingController(AppointmentBookedByPatientController controller) {
        bookAppointment.addActionListener(controller);
        reset.addActionListener(controller);
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDoctors() {
        return doctorComboBox.getSelectedIndex() != -1 || doctorComboBox.getSelectedItem() != null?
                Objects.requireNonNull(doctorComboBox.getSelectedItem())
                        .toString() : null;

    }

    public LocalDate getAppointmentDate() {
        return appointmentDate.getText().equals("") ?
                LocalDate.now() : LocalDate.parse(appointmentDate.getText());

    }

    public void clearFields() {
        doctorComboBox.setSelectedIndex(-1);
        appointmentDate.setText(null);
    }

    public Button getReset() {
        return reset;
    }

    public Button getBookAppointment() {
        return bookAppointment;
    }
}
