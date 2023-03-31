package com.geniescode.appointment;

import java.time.LocalDate;

public record Appointment(
        Integer id,
        Integer doctorId,
        Integer patientId,
        String status,
        LocalDate creationDate,
        LocalDate appointmentDate
) {
}
