package pl.edu.pwr.drozd.hospicio.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Semestr {
    private int id;
    private RodzajSemestru rodzajSemestru;
    private int rok1;
    private int rok2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RodzajSemestru getRodzajSemestru() {
        return rodzajSemestru;
    }

    public void setRodzajSemestru(RodzajSemestru rodzajSemestru) {
        this.rodzajSemestru = rodzajSemestru;
    }

    public int getRok1() {
        return rok1;
    }

    public void setRok1(int rok1) {
        this.rok1 = rok1;
    }

    public int getRok2() {
        return rok2;
    }

    public void setRok2(int rok2) {
        this.rok2 = rok2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semestr semestr = (Semestr) o;

        if (rok1 != semestr.rok1) return false;
        if (rok2 != semestr.rok2) return false;
        return rodzajSemestru.equals(semestr.rodzajSemestru);
    }

    @Override
    public int hashCode() {
        int result = rodzajSemestru.hashCode();
        result = 31 * result + rok1;
        result = 31 * result + rok2;
        return result;
    }

    @Override
    public String toString() {
        return getRok1()+"/"+getRok2() + "  " + getRodzajSemestru().getNazwa();
    }
}
