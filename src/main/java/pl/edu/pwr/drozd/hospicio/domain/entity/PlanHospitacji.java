package pl.edu.pwr.drozd.hospicio.domain.entity;

import java.sql.Date;
import java.util.List;


public class PlanHospitacji {

    private int id;

    private boolean zaakceptowany;

    private Date dataAkceptacji;

    private Date dataUtworzenia;

    private Kierunek kierunek;

    private String nazwa;

    private Semestr semestr;

    private List<Hospitacja> hospitacje;

    public List<Hospitacja> getHospitacje() {
        return hospitacje;
    }

    public void setHospitacje(List<Hospitacja> hospitacje) {
        this.hospitacje = hospitacje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean czyZaakceptowany() {
        return zaakceptowany;
    }

    public void setZaakceptowany(boolean zaakceptowany) {
        this.zaakceptowany = zaakceptowany;
    }

    public Date getDataAkceptacji() {
        return dataAkceptacji;
    }

    public void setDataAkceptacji(Date dataAkceptacji) {
        this.dataAkceptacji = dataAkceptacji;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Semestr getSemestr() {
        return semestr;
    }

    public void setSemestr(Semestr semestry) {
        this.semestr = semestry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanHospitacji that = (PlanHospitacji) o;

        if (id != that.id) return false;
        if (zaakceptowany != that.zaakceptowany) return false;
        if (dataAkceptacji != null ? !dataAkceptacji.equals(that.dataAkceptacji) : that.dataAkceptacji != null)
            return false;
        if (dataUtworzenia != null ? !dataUtworzenia.equals(that.dataUtworzenia) : that.dataUtworzenia != null)
            return false;
        if (kierunek != null ? !kierunek.equals(that.kierunek) : that.kierunek != null) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        return semestr != null ? semestr.equals(that.semestr) : that.semestr == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (zaakceptowany ? 1 : 0);
        result = 31 * result + (dataAkceptacji != null ? dataAkceptacji.hashCode() : 0);
        result = 31 * result + (dataUtworzenia != null ? dataUtworzenia.hashCode() : 0);
        result = 31 * result + (kierunek != null ? kierunek.hashCode() : 0);
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (semestr != null ? semestr.hashCode() : 0);
        return result;
    }

    public boolean czyZakonczony() {
        for (Hospitacja h : hospitacje) {
            if(h.getProtokol() == null) return false;
        }
        return true;
    }
}
