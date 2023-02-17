package ru.zaza.restappproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaza.restappproject.models.Measurement;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    List<Measurement> findMeasurementsByRainingIsTrue();
}
