package com.geniescode.appointment;

import com.geniescode.user.GetUserIdByNameAndSurnameAndAuthority;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AppointmentBookedByReceptionistController implements ActionListener {
    private final AppointmentBookedByReceptionistPanel appointmentBookedByReceptionistPanel;

    public AppointmentBookedByReceptionistController(AppointmentBookedByReceptionistPanel appointmentBookedByReceptionistPanel) {
        this.appointmentBookedByReceptionistPanel = appointmentBookedByReceptionistPanel;
        this.appointmentBookedByReceptionistPanel.addAppointmentForReceptionistController(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == appointmentBookedByReceptionistPanel.getReset())
            appointmentBookedByReceptionistPanel.clearFields();
        if(event.getSource() == appointmentBookedByReceptionistPanel.getBookAppointment())
            bookAppointment();
    }

    private void bookAppointment() {
        AppointmentService appointmentService = new AppointmentService(
                new Appointment(
                        0,
                        new GetUserIdByNameAndSurnameAndAuthority().apply("Doctor", appointmentBookedByReceptionistPanel.getDoctors()),
                        new GetUserIdByNameAndSurnameAndAuthority().apply("Patient", appointmentBookedByReceptionistPanel.getPatient()),
                        "Pending",
                        LocalDate.now(),
                        appointmentBookedByReceptionistPanel.getAppointmentDate()
                ),
                "Receptionist");
        appointmentService.setAppointmentBookingForReceptionistPanel(appointmentBookedByReceptionistPanel);
        appointmentService.bookAppointment();
    }
}
