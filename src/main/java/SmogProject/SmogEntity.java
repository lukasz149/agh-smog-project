package SmogProject;

import javax.persistence.*;

/**
 * Created by grzeg on 16.03.2016.
 */
@Entity
@IdClass(SmogEntityPK.class)
@Table(name = "Smog", schema = "", catalog = "")
public class SmogEntity {
    @Id
    private String data;
    @Id
    private Integer godzina;
    private Integer stacja;
    private Double pylZawieszonyPm10;
    private Double tlenekWegla;
    private Double dwutlenekAzotu;
    private Double tlenekAzotu;
    private Double tlenkiAzotu;
    private Double pylZawieszonyPm25;
    private Double tlenekWegla8H;
    private Double benzen;
    private Double dwutlenekSiarki;
    private Double ozon;
    private Double ozon8H;

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
    @Column(name = "Stacja")
    public Integer getStacja() {
        return stacja;
    }

    public void setStacja(Integer stacja) {
        this.stacja = stacja;
    }

    @Basic
    @Column(name = "PylZawieszonyPM10")
    public Double getPylZawieszonyPm10() {
        return pylZawieszonyPm10;
    }

    public void setPylZawieszonyPm10(Double pylZawieszonyPm10) {
        this.pylZawieszonyPm10 = pylZawieszonyPm10;
    }

    @Basic
    @Column(name = "TlenekWegla")
    public Double getTlenekWegla() {
        return tlenekWegla;
    }

    public void setTlenekWegla(Double tlenekWegla) {
        this.tlenekWegla = tlenekWegla;
    }

    @Basic
    @Column(name = "DwutlenekAzotu")
    public Double getDwutlenekAzotu() {
        return dwutlenekAzotu;
    }

    public void setDwutlenekAzotu(Double dwutlenekAzotu) {
        this.dwutlenekAzotu = dwutlenekAzotu;
    }

    @Basic
    @Column(name = "TlenekAzotu")
    public Double getTlenekAzotu() {
        return tlenekAzotu;
    }

    public void setTlenekAzotu(Double tlenekAzotu) {
        this.tlenekAzotu = tlenekAzotu;
    }

    @Basic
    @Column(name = "TlenkiAzotu")
    public Double getTlenkiAzotu() {
        return tlenkiAzotu;
    }

    public void setTlenkiAzotu(Double tlenkiAzotu) {
        this.tlenkiAzotu = tlenkiAzotu;
    }

    @Basic
    @Column(name = "PylZawieszonyPM25")
    public Double getPylZawieszonyPm25() {
        return pylZawieszonyPm25;
    }

    public void setPylZawieszonyPm25(Double pylZawieszonyPm25) {
        this.pylZawieszonyPm25 = pylZawieszonyPm25;
    }

    @Basic
    @Column(name = "TlenekWegla8h")
    public Double getTlenekWegla8H() {
        return tlenekWegla8H;
    }

    public void setTlenekWegla8H(Double tlenekWegla8H) {
        this.tlenekWegla8H = tlenekWegla8H;
    }

    @Basic
    @Column(name = "Benzen")
    public Double getBenzen() {
        return benzen;
    }

    public void setBenzen(Double benzen) {
        this.benzen = benzen;
    }

    @Basic
    @Column(name = "DwutlenekSiarki")
    public Double getDwutlenekSiarki() {
        return dwutlenekSiarki;
    }

    public void setDwutlenekSiarki(Double dwutlenekSiarki) {
        this.dwutlenekSiarki = dwutlenekSiarki;
    }

    @Basic
    @Column(name = "Ozon")
    public Double getOzon() {
        return ozon;
    }

    public void setOzon(Double ozon) {
        this.ozon = ozon;
    }

    @Basic
    @Column(name = "Ozon8h")
    public Double getOzon8H() {
        return ozon8H;
    }

    public void setOzon8H(Double ozon8H) {
        this.ozon8H = ozon8H;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmogEntity that = (SmogEntity) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (godzina != null ? !godzina.equals(that.godzina) : that.godzina != null) return false;
        if (stacja != null ? !stacja.equals(that.stacja) : that.stacja != null) return false;
        if (pylZawieszonyPm10 != null ? !pylZawieszonyPm10.equals(that.pylZawieszonyPm10) : that.pylZawieszonyPm10 != null)
            return false;
        if (tlenekWegla != null ? !tlenekWegla.equals(that.tlenekWegla) : that.tlenekWegla != null) return false;
        if (dwutlenekAzotu != null ? !dwutlenekAzotu.equals(that.dwutlenekAzotu) : that.dwutlenekAzotu != null)
            return false;
        if (tlenekAzotu != null ? !tlenekAzotu.equals(that.tlenekAzotu) : that.tlenekAzotu != null) return false;
        if (tlenkiAzotu != null ? !tlenkiAzotu.equals(that.tlenkiAzotu) : that.tlenkiAzotu != null) return false;
        if (pylZawieszonyPm25 != null ? !pylZawieszonyPm25.equals(that.pylZawieszonyPm25) : that.pylZawieszonyPm25 != null)
            return false;
        if (tlenekWegla8H != null ? !tlenekWegla8H.equals(that.tlenekWegla8H) : that.tlenekWegla8H != null)
            return false;
        if (benzen != null ? !benzen.equals(that.benzen) : that.benzen != null) return false;
        if (dwutlenekSiarki != null ? !dwutlenekSiarki.equals(that.dwutlenekSiarki) : that.dwutlenekSiarki != null)
            return false;
        if (ozon != null ? !ozon.equals(that.ozon) : that.ozon != null) return false;
        if (ozon8H != null ? !ozon8H.equals(that.ozon8H) : that.ozon8H != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (godzina != null ? godzina.hashCode() : 0);
        result = 31 * result + (stacja != null ? stacja.hashCode() : 0);
        result = 31 * result + (pylZawieszonyPm10 != null ? pylZawieszonyPm10.hashCode() : 0);
        result = 31 * result + (tlenekWegla != null ? tlenekWegla.hashCode() : 0);
        result = 31 * result + (dwutlenekAzotu != null ? dwutlenekAzotu.hashCode() : 0);
        result = 31 * result + (tlenekAzotu != null ? tlenekAzotu.hashCode() : 0);
        result = 31 * result + (tlenkiAzotu != null ? tlenkiAzotu.hashCode() : 0);
        result = 31 * result + (pylZawieszonyPm25 != null ? pylZawieszonyPm25.hashCode() : 0);
        result = 31 * result + (tlenekWegla8H != null ? tlenekWegla8H.hashCode() : 0);
        result = 31 * result + (benzen != null ? benzen.hashCode() : 0);
        result = 31 * result + (dwutlenekSiarki != null ? dwutlenekSiarki.hashCode() : 0);
        result = 31 * result + (ozon != null ? ozon.hashCode() : 0);
        result = 31 * result + (ozon8H != null ? ozon8H.hashCode() : 0);
        return result;
    }
}

