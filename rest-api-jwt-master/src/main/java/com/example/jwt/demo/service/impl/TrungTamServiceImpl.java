package com.example.jwt.demo.service.impl;

import com.example.jwt.demo.model.TrungTam;
import com.example.jwt.demo.repository.TrungTamReponsitory;
import com.example.jwt.demo.service.TrungTamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrungTamServiceImpl implements TrungTamService {
    @Autowired
    private TrungTamReponsitory trungTamReponsitory;

    @Override
    public List<TrungTam> SearchTrungTam(String name) {
        if (name == null) {
            return trungTamReponsitory.findAll();
        }
        return trungTamReponsitory.SearchData(name);
    }

    @Override
    public TrungTam AddTrungTam(TrungTam trungTam) {
        return trungTamReponsitory.save(trungTam);
    }

    @Override
    public void DeleteTrungTam(Long id) {
        trungTamReponsitory.deleteById(id);
    }

    @Override
    public Optional<TrungTam> FindById(Long id) {
        return trungTamReponsitory.findById(id);
    }
}
