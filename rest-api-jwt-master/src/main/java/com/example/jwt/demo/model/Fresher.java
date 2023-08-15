package com.example.jwt.demo.model;



import javax.persistence.*;


@Entity
@Table(name = "fresher")
public class Fresher {
    private static final long serialVersionUID = -3542589964153392334L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "diem_1")
    private float diem_1;

    @Column(name = "diem_2")
    private float diem_2;

    @Column(name = "diem_3")
    private float diem_3;

    @Column(name = "tt_code")
    private String tt_code;

    @Column(name = "id_tt")
    private String id_tt;

    @Column(name="diem_TB")
    private float diem_TB;

    public float getDiem_1() {
        return diem_1;
    }

    public void setDiem_1(float diem_1) {
        this.diem_1 = diem_1;
    }

    public float getDiem_2() {
        return diem_2;
    }

    public void setDiem_2(float diem_2) {
        this.diem_2 = diem_2;
    }

    public float getDiem_3() {
        return diem_3;
    }

    public void setDiem_3(float diem_3) {
        this.diem_3 = diem_3;
    }

    public float getDiem_TB() {
        return diem_TB;
    }

    public void setDiem_TB(float diem_TB) {
        this.diem_TB = diem_TB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_tt() {
        return id_tt;
    }

    public void setId_tt(String id_tt) {
        this.id_tt = id_tt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTt_code() {
        return tt_code;
    }

    public void setTt_code(String tt_code) {
        this.tt_code = tt_code;
    }
}
