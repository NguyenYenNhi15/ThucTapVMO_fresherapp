package com.example.jwt.demo.service;

import com.example.jwt.demo.model.Fresher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FresherService {
    Fresher doAdd(Fresher fresher);
    List<Fresher>SearchData(String name,String email,String tt_code);
    Optional<Fresher> FindById(Long id);
    void DeleteById(Long Id);
    Long GetCount(String id);
    Long CountDiemTB(float diem_TB);
}
