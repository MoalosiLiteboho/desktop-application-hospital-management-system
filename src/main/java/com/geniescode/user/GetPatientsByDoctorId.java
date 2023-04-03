package com.geniescode.user;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetPatientsByDoctorId implements Function<Integer, List<User>> {
    @Override
    public List<User> apply(Integer doctorId) {
        return new FindAllUsers().get().stream()
                .filter(user -> user.id() == doctorId)
                .collect(Collectors.toList());
    }
}
