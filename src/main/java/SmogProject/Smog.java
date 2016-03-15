package SmogProject;

import java.util.List;

/**
 * Created by lukas on 15.03.2016.
 */
public class Smog {
    private final List<String> czas;
    private final List<String> pylZawieszonyPM10;
    private final List<String> tlenekWegla;
    private final List<String> dwutlenekAzotu;
    private final List<String> tlenekAzotu;
    private final List<String> tlenkiAzotu;
    private final List<String> pylZawieszonyPM25;
    private final List<String> tlenekWegla8h;
    private final List<String> benzen;
    private final List<String> dwutlenekSiarki;
    private final List<String> ozon;
    private final List<String> ozon8h;


    public Smog(List<String> czas, List<String> pylZawieszonyPM10, List<String> tlenekWegla, List<String> dwutlenekAzotu, List<String> tlenekAzotu, List<String> tlenkiAzotu, List<String> pylZawieszonyPM25, List<String> tlenekWegla8h, List<String> benzen, List<String> dwutlenekSiarki, List<String> ozon, List<String> ozon8h) {
        this.czas = czas;
        this.pylZawieszonyPM10 = pylZawieszonyPM10;
        this.tlenekWegla = tlenekWegla;
        this.dwutlenekAzotu = dwutlenekAzotu;
        this.tlenekAzotu = tlenekAzotu;
        this.tlenkiAzotu = tlenkiAzotu;
        this.pylZawieszonyPM25 = pylZawieszonyPM25;
        this.tlenekWegla8h = tlenekWegla8h;
        this.benzen = benzen;
        this.dwutlenekSiarki = dwutlenekSiarki;
        this.ozon = ozon;
        this.ozon8h = ozon8h;
    }

    public List<String> getCzas() {
        return czas;
    }

    public List<String> getPylZawieszonyPM10() {
        return pylZawieszonyPM10;
    }

    public List<String> getTlenekWegla() {
        return tlenekWegla;
    }

    public List<String> getDwutlenekAzotu() {
        return dwutlenekAzotu;
    }

    public List<String> getTlenekAzotu() {
        return tlenekAzotu;
    }

    public List<String> getTlenkiAzotu() {
        return tlenkiAzotu;
    }

    public List<String> getPylZawieszonyPM25() {
        return pylZawieszonyPM25;
    }

    public List<String> getTlenekWegla8h() {
        return tlenekWegla8h;
    }

    public List<String> getBenzen() {
        return benzen;
    }

    public List<String> getDwutlenekSiarki() {
        return dwutlenekSiarki;
    }

    public List<String> getOzon() {
        return ozon;
    }

    public List<String> getOzon8h() {
        return ozon8h;
    }
}
