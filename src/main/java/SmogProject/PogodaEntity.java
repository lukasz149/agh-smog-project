package SmogProject;

import javax.persistence.*;

/**
 * Created by grzeg on 16.03.2016.
 */
@Entity
@IdClass(PogodaEntityPK.class)
@Table(name = "Pogoda", schema = "", catalog = "")
public class PogodaEntity {
    @Id
    private String data;
    @Id
    private Integer godzina;
    private Integer temperatura;
    private String kierunek;
    private Integer predkosc;
    private Integer zachmurzenie;
    private Integer wilgotnosc;

    @Basic
    @Column(name = "Data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Basic
    @Column(name = "Godzina")
    public Integer getGodzina() {
        return godzina;
    }

    public void setGodzina(Integer godzina) {
        this.godzina = godzina;
    }

    @Basic
    @Column(name = "Temperatura")
    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    @Basic
    @Column(name = "Kierunek")
    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    @Basic
    @Column(name = "Predkosc")
    public Integer getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(Integer predkosc) {
        this.predkosc = predkosc;
    }

    @Basic
    @Column(name = "Zachmurzenie")
    public Integer getZachmurzenie() {
        return zachmurzenie;
    }

    public void setZachmurzenie(Integer zachmurzenie) {
        this.zachmurzenie = zachmurzenie;
    }

    @Basic
    @Column(name = "Wilgotnosc")
    public Integer getWilgotnosc() {
        return wilgotnosc;
    }

    public void setWilgotnosc(Integer wilgotnosc) {
        this.wilgotnosc = wilgotnosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PogodaEntity that = (PogodaEntity) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (godzina != null ? !godzina.equals(that.godzina) : that.godzina != null) return false;
        if (temperatura != null ? !temperatura.equals(that.temperatura) : that.temperatura != null) return false;
        if (kierunek != null ? !kierunek.equals(that.kierunek) : that.kierunek != null) return false;
        if (predkosc != null ? !predkosc.equals(that.predkosc) : that.predkosc != null) return false;
        if (zachmurzenie != null ? !zachmurzenie.equals(that.zachmurzenie) : that.zachmurzenie != null) return false;
        if (wilgotnosc != null ? !wilgotnosc.equals(that.wilgotnosc) : that.wilgotnosc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (godzina != null ? godzina.hashCode() : 0);
        result = 31 * result + (temperatura != null ? temperatura.hashCode() : 0);
        result = 31 * result + (kierunek != null ? kierunek.hashCode() : 0);
        result = 31 * result + (predkosc != null ? predkosc.hashCode() : 0);
        result = 31 * result + (zachmurzenie != null ? zachmurzenie.hashCode() : 0);
        result = 31 * result + (wilgotnosc != null ? wilgotnosc.hashCode() : 0);
        return result;
    }
}
