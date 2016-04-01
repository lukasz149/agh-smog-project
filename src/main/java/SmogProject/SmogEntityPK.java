package SmogProject;

import java.io.Serializable;

public class SmogEntityPK implements Serializable {
    protected String data;
    protected Integer godzina;

    public SmogEntityPK() {}

    public SmogEntityPK(String data, Integer godzina) {
        this.data = data;
        this.godzina = godzina;
    }
    // equals, hashCode

    @Override
    public int hashCode() {
        return 31 * data.hashCode() + godzina.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PogodaEntityPK that = (PogodaEntityPK) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (godzina != null ? !godzina.equals(that.godzina) : that.godzina != null) return false;

        return true;
    }
}
