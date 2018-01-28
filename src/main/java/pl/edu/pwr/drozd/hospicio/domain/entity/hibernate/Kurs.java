package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
public class Kurs {
    private int id;
    private int dziedzinaid;
    private int kierunekid;
    private String kod;
    private String nazwa;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dziedzinaid")
    public int getDziedzinaid() {
        return dziedzinaid;
    }

    public void setDziedzinaid(int dziedzinaid) {
        this.dziedzinaid = dziedzinaid;
    }

    @Basic
    @Column(name = "kierunekid")
    public int getKierunekid() {
        return kierunekid;
    }

    public void setKierunekid(int kierunekid) {
        this.kierunekid = kierunekid;
    }

    @Basic
    @Column(name = "kod")
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @Basic
    @Column(name = "nazwa")
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
        if (dziedzinaid != kurs.dziedzinaid) return false;
        if (kierunekid != kurs.kierunekid) return false;
        if (kod != null ? !kod.equals(kurs.kod) : kurs.kod != null) return false;
        if (nazwa != null ? !nazwa.equals(kurs.nazwa) : kurs.nazwa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + dziedzinaid;
        result = 31 * result + kierunekid;
        result = 31 * result + (kod != null ? kod.hashCode() : 0);
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }
}
