package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
public class Pracownik {
    private int id;
    private String imie;
    private String nazwisko;
    private int rolaid;
    private int stopiennaukowyid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "rolaid")
    public int getRolaid() {
        return rolaid;
    }

    public void setRolaid(int rolaid) {
        this.rolaid = rolaid;
    }

    @Basic
    @Column(name = "stopiennaukowyid")
    public int getStopiennaukowyid() {
        return stopiennaukowyid;
    }

    public void setStopiennaukowyid(int stopiennaukowyid) {
        this.stopiennaukowyid = stopiennaukowyid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pracownik pracownik = (Pracownik) o;

        if (id != pracownik.id) return false;
        if (rolaid != pracownik.rolaid) return false;
        if (stopiennaukowyid != pracownik.stopiennaukowyid) return false;
        if (imie != null ? !imie.equals(pracownik.imie) : pracownik.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(pracownik.nazwisko) : pracownik.nazwisko != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + rolaid;
        result = 31 * result + stopiennaukowyid;
        return result;
    }
}
