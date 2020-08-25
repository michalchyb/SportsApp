package pl.project.service;

import org.springframework.stereotype.Service;
import pl.project.model.Tri;
import pl.project.repository.TriRepository;

import java.util.List;

@Service
public class TriServiceImpl implements TriService {
    private TriRepository triRepository;

    public TriServiceImpl(TriRepository triRepository) {
        this.triRepository = triRepository;
    }

    @Override
    public List<Tri> getTriathlons() {
        return triRepository.findAll();
    }

    @Override
    public Tri addTri(Tri tri) {
        return triRepository.save(tri);
    }
}
