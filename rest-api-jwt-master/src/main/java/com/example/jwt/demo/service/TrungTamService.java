package com.example.jwt.demo.service;

import com.example.jwt.demo.model.TrungTam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TrungTamService {
    List<TrungTam> SearchTrungTam(String name);

    TrungTam AddTrungTam(TrungTam trungTam);

    void DeleteTrungTam(Long id);

    Optional<TrungTam> FindById(Long id);
}
