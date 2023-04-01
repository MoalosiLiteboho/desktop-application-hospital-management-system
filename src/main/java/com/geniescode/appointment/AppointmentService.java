package com.geniescode.appointment;

import com.geniescode.dao.DAOImplementation;
import com.geniescode.displayMessage.DisplayMessage;

import java.util.function.Consumer;
import java.util.function.Function;

public class AppointmentService {
    private final Appointment appointment;
    private final DisplayMessage displayMessage;
    private final String authority;
    private AppointmentBookedByReceptionistPanel appointmentBookedByReceptionistPanel;
    private AppointmentBookedByPatientPanel  appointmentBookedByPatientPanel;


    public AppointmentService(Appointment appointment, String authority) {
        this.appointment = appointment;
        this.authority = authority;
        displayMessage = new DisplayMessage();
    }

    public void bookAppointment() {
        String results = areFieldsAllFilled.apply(appointment);
        bookAppointmentIfAllFieldsAreFilled(results, displayMessage);
    }

    private void bookAppointmentIfAllFieldsAreFilled(String result, Consumer<String> displayError) {
        if(!"SUCCESS".equals(result))
            displayError.accept(result);
        else {
            new DAOImplementation().bookAppointment(appointment);
            displayMessage.accept("Appointment Booked");
            if(authority.equals("Receptionist"))
                appointmentBookedByReceptionistPanel.clearFields();
            else
                appointmentBookedByPatientPanel.clearFields();
        }
    }

    public void updateAppointment() {
        if(!new AppointmentExistsById().test(appointment.id()))
            throw new RuntimeException("Appointment with that " + appointment.id() + " id does not exists.");

        String results = areFieldsAllFilled.apply(appointment);
        updateAppointmentIfAllFieldsAreFilled(results, displayMessage);
    }

    private void updateAppointmentIfAllFieldsAreFilled(String results, Consumer<String> displayError) {
        if(!"SUCCESS".equals(results))
            displayError.accept(results);
        else
            new DAOImplementation().updateAppointment(appointment);
    }

    private final Function<Appointment, String> areFieldsAllFilled = appointment -> "SUCCESS";

    public void setAppointmentBookingForReceptionistPanel(AppointmentBookedByReceptionistPanel appointmentBookedByReceptionistPanel) {
        this.appointmentBookedByReceptionistPanel = appointmentBookedByReceptionistPanel;
    }

    public void setAppointmentBookedByPatientPanel(AppointmentBookedByPatientPanel appointmentBookedByPatientPanel) {
        this.appointmentBookedByPatientPanel = appointmentBookedByPatientPanel;
    }
}
