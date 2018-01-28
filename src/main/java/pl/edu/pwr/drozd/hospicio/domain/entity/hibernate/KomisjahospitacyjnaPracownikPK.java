package pl.edu.pwr.drozd.hospicio.domain.entity.hibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Konrad on 28.01.2018.
 */
public class KomisjahospitacyjnaPracownikPK implements Serializable {
    private int pracownikid;
    private int komisjahospitacyjnaid;

    @Column(name = "pracownikid")
    @Id
    public int getPracownikid() {
        return pracownikid;
    }

    public void setPracownikid(int pracownikid) {
        this.pracownikid = pracownikid;
    }

    @Column(name = "komisjahospitacyjnaid")
    @Id
    public int getKomisjahospitacyjnaid() {
        return komisjahospitacyjnaid;
    }

    public void setKomisjahospitacyjnaid(int komisjahospitacyjnaid) {
        this.komisjahospitacyjnaid = komisjahospitacyjnaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KomisjahospitacyjnaPracownikPK that = (KomisjahospitacyjnaPracownikPK) o;

        if (pracownikid != that.pracownikid) return false;
        if (komisjahospitacyjnaid != that.komisjahospitacyjnaid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pracownikid;
        result = 31 * result + komisjahospitacyjnaid;
        return result;
    }
}
