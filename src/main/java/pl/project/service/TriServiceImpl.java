package pl.project.service;

import org.springframework.stereotype.Service;
import pl.project.exception.TrisNotFoundException;
import pl.project.model.City;
import pl.project.model.Tri;
import pl.project.repository.TriRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TriServiceImpl implements TriService {
    private TriRepository triRepository;
    private CityService cityService;

    public TriServiceImpl(TriRepository triRepository, CityService cityService) {
        this.triRepository = triRepository;
        this.cityService = cityService;
    }

    @Override
    public List<Tri> getTriathlons() {
        List<Tri> tris = triRepository.findAll();
        if (tris.isEmpty()) {
            throw new TrisNotFoundException();
        }
        return tris;
    }

    @Override
    public Tri addTri(Tri tri) {
        Optional<City> city = cityService.setCorrectCity(tri.getCity().getName());
        city.ifPresent(tri::setCity);
        return triRepository.save(tri);
    }
}
