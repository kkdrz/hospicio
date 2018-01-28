package pl.edu.pwr.drozd.hospicio.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;


public class Zajecia {

    private int id;
    private Time czasRozpoczecia;
    private Time czasZakonczenia;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    private String kod;
    private Kurs kurs;
    private Pracownik prowadzacy;
    private String sala;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getCzasRozpoczecia() {
        return czasRozpoczecia;
    }

    public void setCzasRozpoczecia(Time czasRozpoczecia) {
        this.czasRozpoczecia = czasRozpoczecia;
    }

    public Time getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public void setCzasZakonczenia(Time czasZakonczenia) {
        this.czasZakonczenia = czasZakonczenia;
    }

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Pracownik getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(Pracownik prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

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
        if (czasRozpoczecia != null ? !czasRozpoczecia.equals(zajecia.czasRozpoczecia) : zajecia.czasRozpoczecia != null)
            return false;
        if (czasZakonczenia != null ? !czasZakonczenia.equals(zajecia.czasZakonczenia) : zajecia.czasZakonczenia != null)
            return false;
        if (dataRozpoczecia != null ? !dataRozpoczecia.equals(zajecia.dataRozpoczecia) : zajecia.dataRozpoczecia != null)
            return false;
        if (dataZakonczenia != null ? !dataZakonczenia.equals(zajecia.dataZakonczenia) : zajecia.dataZakonczenia != null)
            return false;
        if (kod != null ? !kod.equals(zajecia.kod) : zajecia.kod != null) return false;
        if (kurs != null ? !kurs.equals(zajecia.kurs) : zajecia.kurs != null) return false;
        if (prowadzacy != null ? !prowadzacy.equals(zajecia.prowadzacy) : zajecia.prowadzacy != null) return false;
        return sala != null ? sala.equals(zajecia.sala) : zajecia.sala == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (czasRozpoczecia != null ? czasRozpoczecia.hashCode() : 0);
        result = 31 * result + (czasZakonczenia != null ? czasZakonczenia.hashCode() : 0);
        result = 31 * result + (dataRozpoczecia != null ? dataRozpoczecia.hashCode() : 0);
        result = 31 * result + (dataZakonczenia != null ? dataZakonczenia.hashCode() : 0);
        result = 31 * result + (kod != null ? kod.hashCode() : 0);
        result = 31 * result + (kurs != null ? kurs.hashCode() : 0);
        result = 31 * result + (prowadzacy != null ? prowadzacy.hashCode() : 0);
        result = 31 * result + (sala != null ? sala.hashCode() : 0);
        return result;
    }
}
