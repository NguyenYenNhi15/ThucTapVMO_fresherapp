package com.example.jwt.demo.service.impl;

import com.example.jwt.demo.model.Fresher;
import com.example.jwt.demo.repository.FresherReponsitory;
import com.example.jwt.demo.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FresherImpl implements FresherService {
    @Autowired
    private FresherReponsitory fresherReponsitory;

    @Override
    public Fresher doAdd(Fresher fresher) {
        fresher.setDiem_TB((fresher.getDiem_1() + fresher.getDiem_2() + fresher.getDiem_3()) / 3);
        return fresherReponsitory.save(fresher);
    }

    @Override
    public List<Fresher> SearchData(String name, String email, String tt_code) {
        if (email == null && tt_code == null && name == null) {
            return fresherReponsitory.findAll();
        } else {
            return fresherReponsitory.SearchModel(name, email, tt_code);
        }
    }

    @Override
    public Optional<Fresher> FindById(Long id) {
        return fresherReponsitory.findById(id);
    }

    @Override
    public void DeleteById(Long id) {
        fresherReponsitory.deleteById(id);
    }


    @Override
    public Long GetCount(String id) {
        return fresherReponsitory.GetCountFresherTT(id);
    }

    @Override
    public Long CountDiemTB(float diem_TB) {
        return fresherReponsitory.GetCountDiemTb(diem_TB);
    }

}
