package com.geniescode.appointment;

import com.geniescode.dao.DAOImplementation;

import java.util.function.Consumer;

public class DeleteAppointmentById implements Consumer<Integer> {
    @Override
    public void accept(Integer appointmentId) {
        if(!new AppointmentExistsById().test(appointmentId))
            throw new RuntimeException("Appointment with that " + appointmentId + " id does not exists.");

        new DAOImplementation().deleteAppointmentById(appointmentId);
    }
}
