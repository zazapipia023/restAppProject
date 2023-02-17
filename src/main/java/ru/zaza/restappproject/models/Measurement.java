package ru.zaza.restappproject.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NotNull(message = "Temperature value should not be null")
    @Range(min = -100, max = 100, message = "Temperature value should be between -100-100")
    private int value;

    @Column(name = "raining")
    @NotNull(message = "raining value should not be empty")
    private boolean raining;

    @Column(name = "measure_time")
    private LocalDateTime measureTime;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    @NotNull(message = "Sensor should not be null")
    private Sensor sensor;

    public Measurement() {

    }

    public Measurement(int id, int value, boolean raining, Sensor sensor) {
        this.id = id;
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public LocalDateTime getMeasureTime() {
        return measureTime;
    }

    public void setMeasureTime(LocalDateTime measureTime) {
        this.measureTime = measureTime;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
