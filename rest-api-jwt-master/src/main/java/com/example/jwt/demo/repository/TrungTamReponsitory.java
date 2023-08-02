package com.example.jwt.demo.repository;

import com.example.jwt.demo.model.TrungTam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrungTamReponsitory extends JpaRepository<TrungTam, Long> {
    @Query("select T from TrungTam T where T.ten_trung_tam =:name")
    List<TrungTam> SearchData(String name);
}
