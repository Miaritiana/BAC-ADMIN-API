package com.managementbac.bacadmin.service;

import com.managementbac.bacadmin.model.Serie;
import com.managementbac.bacadmin.repository.SerieRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class SerieService {
    private final SerieRepository serieRepository;

    public List<Serie> getAllSeries(){
        return serieRepository.findAll();
    }

    public List<Serie> addSeries(List<Serie> serie){
        return serieRepository.saveAll(serie);
    }

    public Optional<Serie> getSerieById(int id){
        return serieRepository.findById(id);
    }

    public Serie updateSerie(int id, Serie serieObj){
        Optional<Serie> serie = serieRepository.findById(id);
        if (serie.isPresent()){
            serie.get().setSerieName(serieObj.getSerieName());
            return serieRepository.save(serie.get());
        } else {
            return null;
        }
    }

    public void deleteSerieById(int id){
        serieRepository.deleteById(id);
    }
}
