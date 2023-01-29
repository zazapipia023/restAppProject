package ru.zaza.restappproject.dto;

import ru.zaza.restappproject.models.Sensor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MeasurementDTO {

    @NotEmpty(message = "Temperature value should not be empty")
    @Size(min = -100, max = 100, message = "Temperature value should be between -100-100")
    private int value;

    @NotEmpty(message = "raining value should not be empty")
    private boolean isRaining;

    @NotEmpty(message = "Sensor should not be empty")
    private Sensor sensor;

}
