package pl.edu.pwr.drozd.hospicio.domain.entity;


public class Hospitacja {

    private int id;

    private KomisjaHospitacyjna komisja;

    private Kurs kurs;

    private Pracownik hospitowany;

    private ProtokolHospitacji protokol;

    public ProtokolHospitacji getProtokol() {
        return protokol;
    }

    public void setProtokol(ProtokolHospitacji protokol) {
        this.protokol = protokol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KomisjaHospitacyjna getKomisja() {
        return komisja;
    }

    public void setKomisja(KomisjaHospitacyjna komisja) {
        this.komisja = komisja;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Pracownik getHospitowany() {
        return hospitowany;
    }

    public void setHospitowany(Pracownik hospitowany) {
        this.hospitowany = hospitowany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hospitacja that = (Hospitacja) o;

        if (id != that.id) return false;
        if (komisja != null ? !komisja.equals(that.komisja) : that.komisja != null) return false;
        if (kurs != null ? !kurs.equals(that.kurs) : that.kurs != null) return false;
        return hospitowany != null ? hospitowany.equals(that.hospitowany) : that.hospitowany == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (komisja != null ? komisja.hashCode() : 0);
        result = 31 * result + (kurs != null ? kurs.hashCode() : 0);
        result = 31 * result + (hospitowany != null ? hospitowany.hashCode() : 0);
        return result;
    }
}
