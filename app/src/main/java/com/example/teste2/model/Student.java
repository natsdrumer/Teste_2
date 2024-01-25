package com.example.teste2.model;

public class Student {
    private long id;
    private String name;
    private Double nota1;

    private Double nota2;
    private String status;
    private Double media;

    public Student(long id, String name, Double nota1, Double nota2, Double media, String status) {
        this.id = id;
        this.name = name;
        this.nota1=nota1;
        this.nota2=nota2;

        this.media=media;
        this.status=status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
