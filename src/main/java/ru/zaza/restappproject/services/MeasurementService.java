package ru.zaza.restappproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zaza.restappproject.models.Measurement;
import ru.zaza.restappproject.repositories.MeasurementRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAll();
    }

    public Measurement findOne(int id) {
        Optional<Measurement> measurement = measurementRepository.findById(id);
        return measurement.orElseThrow(); // TODO: make MeasurementNotFoundException
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public void enrichMeasurement(Measurement measurement) {
        measurement.setMeasureTime(LocalDateTime.now());
    }
}
