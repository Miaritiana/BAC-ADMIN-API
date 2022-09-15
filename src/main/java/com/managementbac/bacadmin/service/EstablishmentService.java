package com.managementbac.bacadmin.service;

import com.managementbac.bacadmin.model.Establishment;
import com.managementbac.bacadmin.repository.EstablishmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstablishmentService {
    private final EstablishmentRepository establishmentRepository;

    public List<Establishment> getAllEstablishment(){
        return establishmentRepository.findAll();
    }

    public List<Establishment> addEstablishments(List<Establishment> establishments){
        return establishmentRepository.saveAll(establishments);
    }

    public Establishment updateEstablishment(int id, Map<String,String> newEstablishment){
        Optional<Establishment> establishment = establishmentRepository.findById(id);
        if(establishment.isPresent()){
            establishment.get().setEstablishment(newEstablishment.get("establishment"));
            return establishmentRepository.save(establishment.get());
        } else {
            return null;
        }
    }
}
