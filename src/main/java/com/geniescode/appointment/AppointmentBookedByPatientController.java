package com.geniescode.appointment;

import com.geniescode.user.GetUserIdByNameAndSurnameAndAuthority;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AppointmentBookedByPatientController implements ActionListener {
    private final AppointmentBookedByPatientPanel appointmentBookedByPatientPanel;

    public AppointmentBookedByPatientController(AppointmentBookedByPatientPanel appointmentBookedByPatientPanel) {
        this.appointmentBookedByPatientPanel = appointmentBookedByPatientPanel;
        this.appointmentBookedByPatientPanel.addAppointmentBookingController(this);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == appointmentBookedByPatientPanel.getReset())
            appointmentBookedByPatientPanel.clearFields();
        if(event.getSource() == appointmentBookedByPatientPanel.getBookAppointment())
            bookingAppointment();
    }

    private void bookingAppointment() {
        AppointmentService appointmentService = new AppointmentService(new Appointment(
                null,
                new GetUserIdByNameAndSurnameAndAuthority().apply("Doctor", appointmentBookedByPatientPanel.getDoctors()),
                appointmentBookedByPatientPanel.getPatientId(),
                "Pending",
                LocalDate.now(),
                appointmentBookedByPatientPanel.getAppointmentDate()
        ),
                "Patient");
        appointmentService.setAppointmentBookedByPatientPanel(appointmentBookedByPatientPanel);
        appointmentService.bookAppointment();

    }
}
