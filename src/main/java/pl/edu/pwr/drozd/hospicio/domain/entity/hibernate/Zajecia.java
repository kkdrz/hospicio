package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Konrad on 28.01.2018.
 */
@Entity
public class Zajecia {
    private int id;
    private Time czasrozpoczecia;
    private Time czaszakonczenia;
    private Date datarozpoczecia;
    private Date datazakonczenia;
    private String kod;
    private int kursid;
    private int pracownikid;
    private String sala;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "czasrozpoczecia")
    public Time getCzasrozpoczecia() {
        return czasrozpoczecia;
    }

    public void setCzasrozpoczecia(Time czasrozpoczecia) {
        this.czasrozpoczecia = czasrozpoczecia;
    }

    @Basic
    @Column(name = "czaszakonczenia")
    public Time getCzaszakonczenia() {
        return czaszakonczenia;
    }

    public void setCzaszakonczenia(Time czaszakonczenia) {
        this.czaszakonczenia = czaszakonczenia;
    }

    @Basic
    @Column(name = "datarozpoczecia")
    public Date getDatarozpoczecia() {
        return datarozpoczecia;
    }

    public void setDatarozpoczecia(Date datarozpoczecia) {
        this.datarozpoczecia = datarozpoczecia;
    }

    @Basic
    @Column(name = "datazakonczenia")
    public Date getDatazakonczenia() {
        return datazakonczenia;
    }

    public void setDatazakonczenia(Date datazakonczenia) {
        this.datazakonczenia = datazakonczenia;
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
    @Column(name = "kursid")
    public int getKursid() {
        return kursid;
    }

    public void setKursid(int kursid) {
        this.kursid = kursid;
    }

    @Basic
    @Column(name = "pracownikid")
    public int getPracownikid() {
        return pracownikid;
    }

    public void setPracownikid(int pracownikid) {
        this.pracownikid = pracownikid;
    }

    @Basic
    @Column(name = "sala")
    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zajecia zajecia = (Zajecia) o;

        if (id != zajecia.id) return false;
        if (kursid != zajecia.kursid) return false;
        if (pracownikid != zajecia.pracownikid) return false;
        if (czasrozpoczecia != null ? !czasrozpoczecia.equals(zajecia.czasrozpoczecia) : zajecia.czasrozpoczecia != null)
            return false;
        if (czaszakonczenia != null ? !czaszakonczenia.equals(zajecia.czaszakonczenia) : zajecia.czaszakonczenia != null)
            return false;
        if (datarozpoczecia != null ? !datarozpoczecia.equals(zajecia.datarozpoczecia) : zajecia.datarozpoczecia != null)
            return false;
        if (datazakonczenia != null ? !datazakonczenia.equals(zajecia.datazakonczenia) : zajecia.datazakonczenia != null)
            return false;
        if (kod != null ? !kod.equals(zajecia.kod) : zajecia.kod != null) return false;
        if (sala != null ? !sala.equals(zajecia.sala) : zajecia.sala != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (czasrozpoczecia != null ? czasrozpoczecia.hashCode() : 0);
        result = 31 * result + (czaszakonczenia != null ? czaszakonczenia.hashCode() : 0);
        result = 31 * result + (datarozpoczecia != null ? datarozpoczecia.hashCode() : 0);
        result = 31 * result + (datazakonczenia != null ? datazakonczenia.hashCode() : 0);
        result = 31 * result + (kod != null ? kod.hashCode() : 0);
        result = 31 * result + kursid;
        result = 31 * result + pracownikid;
        result = 31 * result + (sala != null ? sala.hashCode() : 0);
        return result;
    }
}
