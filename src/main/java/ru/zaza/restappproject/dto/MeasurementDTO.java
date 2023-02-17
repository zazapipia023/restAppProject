package ru.zaza.restappproject.dto;

import org.hibernate.validator.constraints.Range;
import ru.zaza.restappproject.models.Sensor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MeasurementDTO {

    @NotNull(message = "Temperature value should not be null")
    @Range(min = -100, max = 100, message = "Temperature value should be between -100-100")
    private int value;

    @NotNull(message = "raining value should not be null")
    private boolean raining;

    @NotNull(message = "Sensor should not be null")
    private Sensor sensor;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
