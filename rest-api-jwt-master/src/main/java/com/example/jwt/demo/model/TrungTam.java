package com.example.jwt.demo.model;


import javax.persistence.*;

@Entity

@Table(name = "trung_tam")
public class TrungTam {
    private static final long serialVersionUID = -3542589964153392334L;
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "ten_trung_tam")
    private String ten_trung_tam;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTen_trung_tam() {
        return ten_trung_tam;
    }

    public void setTen_trung_tam(String ten_trung_tam) {
        this.ten_trung_tam = ten_trung_tam;
    }
}
