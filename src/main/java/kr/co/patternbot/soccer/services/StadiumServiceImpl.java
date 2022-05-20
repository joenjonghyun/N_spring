package kr.co.patternbot.soccer.services;

import kr.co.patternbot.soccer.domains.Stadium;
import kr.co.patternbot.soccer.repositories.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService{
    private final StadiumRepository repository;



    @Override
    public List<Stadium> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Stadium> findAll(Sort sort) {
        return repository.findAll();
    }

    @Override
    public Page<Stadium> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Stadium stadium) {
        repository.delete(stadium);
        return "";
    }

    @Override
    public String save(Stadium stadium) {
        repository.save(stadium);
        return "";
    }

    @Override
    public Optional<Stadium> findById(String stadiumId) {
        return repository.findById(0L);
    }

    @Override
    public boolean existsById(String stadiumId) {
        return repository.existsById(0L);
    }
}
