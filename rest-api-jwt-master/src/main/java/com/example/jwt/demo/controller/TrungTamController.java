package com.example.jwt.demo.controller;

import com.example.jwt.demo.model.TrungTam;
import com.example.jwt.demo.response.FresherResponse;
import com.example.jwt.demo.service.TrungTamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/TrungTam")
public class TrungTamController {
    @Autowired
    private TrungTamService repo;

    @PostMapping("/Search")
    ResponseEntity<FresherResponse> SearchData(@RequestBody TrungTam trungTam) {
        List<TrungTam> trungTams = repo.SearchTrungTam(trungTam.getTen_trung_tam());
        if (trungTams.size() > 0) {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(new FresherResponse("SUSSES", trungTams, HttpStatus.OK));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Fail", (Object) null, HttpStatus.OK));
    }

    @PostMapping("/add")
    ResponseEntity<FresherResponse> AddTrungTam(@RequestBody TrungTam trungTam) {
        repo.AddTrungTam(trungTam);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Thêm mới thành công", (Object) null, HttpStatus.OK));

    }
    @PutMapping("/Update")
    ResponseEntity<FresherResponse> UpdateTrungTam(@RequestBody TrungTam trungTam) {
        repo.FindById(trungTam.getId());
        repo.AddTrungTam(trungTam);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Cập nhật thành công", (Object) null, HttpStatus.OK));

    }

    @GetMapping("/GetDetail/{id}")
    ResponseEntity<FresherResponse> GetDeTailTrungTam(@PathVariable Long id) {
        Optional<TrungTam> trungTam = repo.FindById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("SUSSES", trungTam, HttpStatus.OK));
    }

    @DeleteMapping("DeleteTrungTam/{id}")
    ResponseEntity<FresherResponse> DeleteTrungTam(@PathVariable Long id) {
        repo.DeleteTrungTam(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(new FresherResponse("Xóa thành công", (Object) null, HttpStatus.OK));
    }
}
