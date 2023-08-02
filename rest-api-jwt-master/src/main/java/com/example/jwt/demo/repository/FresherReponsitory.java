package com.example.jwt.demo.repository;

import com.example.jwt.demo.model.Fresher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FresherReponsitory extends JpaRepository<Fresher, Long> {
    @Query("select f from Fresher f where f.name =:name or f.email=:email or f.tt_code=:tt_code ")
    List<Fresher>SearchModel(String name , String email, String tt_code);
    @Query("select count (f) from Fresher f where f.id_tt like id_tt")
    Long GetCountFresherTT(String id_tt);
    @Query("select count (f) from Fresher f where f.diem_TB =:diem_TB")
    Long GetCountDiemTb(float diem_TB);
}
