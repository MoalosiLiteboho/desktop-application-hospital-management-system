package com.geniescode.appointment;

import com.geniescode.dao.DAOImplementation;
import com.geniescode.displayMessage.DisplayMessage;

import java.util.function.Consumer;
import java.util.function.Function;

public class AppointmentService {
    private final Appointment appointment;
    private final DisplayMessage displayMessage;

    public AppointmentService(Appointment appointment) {
        this.appointment = appointment;
        displayMessage = new DisplayMessage();
    }

    public void bookAppointment() {
        String results = areFieldsAllFilled.apply(appointment);
        bookAppointmentIfAllFieldsAreFilled(results, displayMessage);
    }

    private void bookAppointmentIfAllFieldsAreFilled(String result, Consumer<String> displayError) {
        if(!"SUCCESS".equals(result))
            displayError.accept(result);
        else
            new DAOImplementation().bookAppointment(appointment);
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
}
