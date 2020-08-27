package pl.project.service;

import pl.project.model.City;

import java.util.Optional;

public interface CityService {

    Optional<City> setCorrectCity(String name);
}
