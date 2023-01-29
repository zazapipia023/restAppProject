package ru.zaza.restappproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Temperature value should not be empty")
    @Size(min = -100, max = 100, message = "Temperature value should be between -100-100")
    private int value;

    @Column(name = "raining")
    @NotEmpty(message = "raining value should not be empty")
    private boolean isRaining;

    @Column(name = "measure_time")
    private LocalDateTime measureTime;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    @NotEmpty(message = "Sensor should not be empty")
    private Sensor sensor;

    public Measurement() {

    }

    public Measurement(int id, int value, boolean isRaining, Sensor sensor) {
        this.id = id;
        this.value = value;
        this.isRaining = isRaining;
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
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
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
