package com.example.lab2spring.service;

import com.example.lab2spring.entity.ElectronicEntity;
import com.example.lab2spring.exception.ElectronicAlreadyExistException;
import com.example.lab2spring.exception.ElectronicAreEmptyException;
import com.example.lab2spring.exception.ElectronicNotFoundException;
import com.example.lab2spring.repository.ElectronicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectronicService {

    @Autowired
    private ElectronicRepo electronicRepo;

    public void addElectronic(ElectronicEntity electronic) throws Exception {
        if (electronicRepo.findByNameModel(electronic.getNameModel()) != null) {
            throw new ElectronicAlreadyExistException("Электроника с таким названием модели уже существует!");
        }
        if (electronic.getNameModel() == null || electronic.getNameCompany() == null || electronic.getCost() == null)
            throw new ElectronicAreEmptyException("Данные не могут иметь пустых значений");
        electronicRepo.save(electronic);
    }

    public Optional<ElectronicEntity> getElectronic(Long id) throws ElectronicNotFoundException {
        var electronic = electronicRepo.findById(id);
        if (electronic.isEmpty()) {
            throw new ElectronicNotFoundException("Электроника не была найдена");
        }
        return electronic;
    }

    public List<ElectronicEntity> getElectronics() {
        List<ElectronicEntity> electronics = (List<ElectronicEntity>) electronicRepo.findAll();
        return electronics;
    }

    public Long deleteElectronic(Long id) throws  ElectronicNotFoundException {
        electronicRepo.deleteById(id);
        return id;
    }

    public ElectronicEntity updateElectronic(Long id, ElectronicEntity electronic) throws ElectronicNotFoundException {
        var oldElectronic = electronicRepo.findById(id);
        if (oldElectronic.isEmpty()) {
            throw new ElectronicNotFoundException("Электроника не была найдена");
        } else {
            electronic.setId(oldElectronic.get().getId());
            return electronicRepo.save(electronic);
        }
    }
}
