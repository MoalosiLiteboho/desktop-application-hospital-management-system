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

public class AppointmentBookedByReceptionistPanel extends Panel {
    private final List<String> patientList = new GetUserListByAuthority().apply("Patient");
    private final List<String> doctorList = new GetUserListByAuthority().apply("Doctor");
    private ComboBox<String> patient;
    private ComboBox<String> doctors;
    private DateChooserField appointmentDate;
    private Button reset;
    private Button bookAppointment;

    public AppointmentBookedByReceptionistPanel() {
        initComponents();
    }

    private void initComponents() {
        JLabel tittle = new JLabel("Booking Appointment");
        doctors = new ComboBox<>("Available Doctors", Color.green);
        patient = new ComboBox<>("Available Patients", Color.green);
        appointmentDate = new DateChooserField("Appointment Date (yyyy-mm-dd)", Color.green);
        bookAppointment = new Button("Book Appointment");
        reset= new Button("Reset");

        patient.addModels(patientList);
        patient.setSelectedIndex(-1);

        doctors.addModels(doctorList);
        doctors.setSelectedIndex(-1);

        tittle.setFont(tittle.getFont().deriveFont(Font.PLAIN, 25));
        tittle.setHorizontalAlignment(SwingConstants.CENTER);
        tittle.setForeground(Color.green);

        setLayout(new MigLayout("inset 0, gap 0, wrap"));
        add(tittle, "width 100%, gap top 20px");
        add(patient, "width 60%, gap left 20%");
        add(doctors, "width 60%, gap left 20%, gap top 5px");
        add(appointmentDate, "width 60%, gap left 20%, gap top 5px");
        add(bookAppointment, "width 30%, height 35px, gap left 35%, gap top 20px");
        add(reset, "width 30%, height 35px, gap left 35%, gap top 6px");
        setFont(new Font("sanserif", Font.PLAIN, 15));
        setBackground(Color.white);
        addController.accept(this);
    }

    private final Consumer<AppointmentBookedByReceptionistPanel> addController = AppointmentBookedByReceptionistController::new;

    public void addAppointmentForReceptionistController(AppointmentBookedByReceptionistController controller) {
        reset.addActionListener(controller);
        bookAppointment.addActionListener(controller);
    }

    public String getPatient() {
        return patient.getSelectedIndex() != -1 || patient.getSelectedItem() != null?
                Objects.requireNonNull(patient.getSelectedItem())
                        .toString() : null;
    }

    public String getDoctors() {
        return doctors.getSelectedIndex() != -1 || doctors.getSelectedItem() != null?
                Objects.requireNonNull(doctors.getSelectedItem())
                        .toString() : null;

    }

    public LocalDate getAppointmentDate() {
        return appointmentDate.getText().equals("") ?
                LocalDate.now() : LocalDate.parse(appointmentDate.getText());

    }

    public Button getReset() {
        return reset;
    }

    public Button getBookAppointment() {
        return bookAppointment;
    }

    public void clearFields() {
        doctors.setSelectedIndex(-1);
        patient.setSelectedIndex(-1);
        appointmentDate.setText(null);
    }
}
