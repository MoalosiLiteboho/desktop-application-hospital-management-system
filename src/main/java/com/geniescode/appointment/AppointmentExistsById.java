package com.geniescode.appointment;

import com.geniescode.dao.DAOImplementation;

import java.util.function.Predicate;

public class AppointmentExistsById implements Predicate<Integer> {
    @Override
    public boolean test(Integer appointmentId) {
        return new DAOImplementation().findAllAppointment()
                .stream()
                .anyMatch(appointment -> appointment.id().equals(appointmentId));
    }
}
