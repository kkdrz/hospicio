package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.*;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
@Table(name = "pracownik_specjalizacja", schema = "hospicio", catalog = "")
@IdClass(PracownikSpecjalizacjaPK.class)
public class PracownikSpecjalizacja {
    private int specjalizacjaid;
    private int pracownikid;

    @Id
    @Column(name = "specjalizacjaid")
    public int getSpecjalizacjaid() {
        return specjalizacjaid;
    }

    public void setSpecjalizacjaid(int specjalizacjaid) {
        this.specjalizacjaid = specjalizacjaid;
    }

    @Id
    @Column(name = "pracownikid")
    public int getPracownikid() {
        return pracownikid;
    }

    public void setPracownikid(int pracownikid) {
        this.pracownikid = pracownikid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracownikSpecjalizacja that = (PracownikSpecjalizacja) o;

        if (specjalizacjaid != that.specjalizacjaid) return false;
        if (pracownikid != that.pracownikid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = specjalizacjaid;
        result = 31 * result + pracownikid;
        return result;
    }
}
