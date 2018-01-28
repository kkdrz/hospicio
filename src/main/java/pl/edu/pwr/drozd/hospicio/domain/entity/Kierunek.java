package pl.edu.pwr.drozd.hospicio.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class Kierunek {
    private int id;
    private String nazwa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kierunek kierunek = (Kierunek) o;

        return nazwa.equals(kierunek.nazwa);
    }

    @Override
    public int hashCode() {
        return nazwa.hashCode();
    }
}
