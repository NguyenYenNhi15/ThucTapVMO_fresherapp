package com.example.jwt.demo.controller;


import com.example.jwt.demo.dto.FresherSearchModel;
import com.example.jwt.demo.model.Fresher;
import com.example.jwt.demo.response.FresherResponse;
import com.example.jwt.demo.service.FresherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fresher")
public class FresherController {
    @Autowired
    private FresherService repo;

    @PostMapping("/add")
    public ResponseEntity<FresherResponse> saveOrUpdate(@RequestBody Fresher fresher) {
        repo.doAdd(fresher);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Thêm mới thành công", (Object) null, HttpStatus.OK));
    }

    @PutMapping("/update")
    public ResponseEntity<FresherResponse> Update(@RequestBody Fresher fresher) {
        repo.FindById(fresher.getId());
        repo.doAdd(fresher);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Cập nhật thành công", (Object) null, HttpStatus.OK));
    }

    @PostMapping("/Search")
    public ResponseEntity<FresherResponse> SearchDataModel(@RequestBody FresherSearchModel fresher) {
        List<Fresher> freshers = repo.SearchData(fresher.getName(), fresher.getEmail(), fresher.getTt_code());
        if (freshers.size() > 0) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(new FresherResponse("SUSSES", freshers, HttpStatus.OK));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Fail", freshers, HttpStatus.OK));
    }

    @GetMapping("/FresherDetail/{id}")
    public ResponseEntity<FresherResponse> DetailFresher(@PathVariable Long id) {
        Optional<Fresher> fresher = repo.FindById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("SUSSES", fresher, HttpStatus.OK));
    }

    @DeleteMapping("/DeleteFresher/{id}")
    public ResponseEntity<FresherResponse> DeleteFresher(@PathVariable Long id) {
        repo.DeleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Xóa thành công", (Object) null, HttpStatus.OK));
    }

    @PostMapping("/CountFresher")
    public ResponseEntity<FresherResponse> GetCount(@RequestBody Fresher fresher) {
        Long count = repo.GetCount(fresher.getId_tt());
        if (count > 0) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(new FresherResponse("Susses", count, HttpStatus.OK));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("FAIL", count, HttpStatus.OK));
    }

    @PostMapping("/CountFresherDTB")
    public ResponseEntity<FresherResponse> GetCountDTB(@RequestBody Fresher fresher) {
        Long count = repo.CountDiemTB(fresher.getDiem_TB());
        if (count > 0) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(new FresherResponse("Susses", count, HttpStatus.OK));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("FAIL", count, HttpStatus.OK));
    }


}
