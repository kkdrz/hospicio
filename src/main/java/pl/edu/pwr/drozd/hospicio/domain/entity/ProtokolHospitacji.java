package pl.edu.pwr.drozd.hospicio.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;


public class ProtokolHospitacji {
    private int id;
    private Date dataUtworzenia;
    private Hospitacja hospitacja;
    private List<Integer> oceny;
    private String komentarz;

    public List<Integer> getOceny() {
        return oceny;
    }

    public void setOceny(List<Integer> oceny) {
        this.oceny = oceny;
    }

    public String getKomentarz() {
        return komentarz;
    }

    public void setKomentarz(String komentarz) {
        this.komentarz = komentarz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public Hospitacja getHospitacja() {
        return hospitacja;
    }

    public void setHospitacja(Hospitacja hospitacja) {
        this.hospitacja = hospitacja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProtokolHospitacji that = (ProtokolHospitacji) o;

        if (id != that.id) return false;
        if (dataUtworzenia != null ? !dataUtworzenia.equals(that.dataUtworzenia) : that.dataUtworzenia != null)
            return false;
        return hospitacja != null ? hospitacja.equals(that.hospitacja) : that.hospitacja == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dataUtworzenia != null ? dataUtworzenia.hashCode() : 0);
        result = 31 * result + (hospitacja != null ? hospitacja.hashCode() : 0);
        return result;
    }
}
