package pl.edu.pwr.drozd.hospicio.domain.entity;

import javax.persistence.*;
import java.util.List;


public class Kurs {


    private int id;

    private Specjalizacja dziedzina;

    private Kierunek kierunek;

    private String kod;


    private String nazwa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Specjalizacja getDziedzina() {
        return dziedzina;
    }

    public void setDziedzina(Specjalizacja dziedzina) {
        this.dziedzina = dziedzina;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
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

        Kurs kurs = (Kurs) o;

        if (id != kurs.id) return false;
        if (dziedzina != null ? !dziedzina.equals(kurs.dziedzina) : kurs.dziedzina != null) return false;
        if (kierunek != null ? !kierunek.equals(kurs.kierunek) : kurs.kierunek != null) return false;
        if (!kod.equals(kurs.kod)) return false;
        return nazwa.equals(kurs.nazwa);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dziedzina != null ? dziedzina.hashCode() : 0);
        result = 31 * result + (kierunek != null ? kierunek.hashCode() : 0);
        result = 31 * result + kod.hashCode();
        result = 31 * result + nazwa.hashCode();
        return result;
    }
}
