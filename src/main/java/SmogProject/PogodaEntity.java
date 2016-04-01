package SmogProject;

import javax.persistence.*;

/**
 * Created by grzeg on 02.04.2016.
 */
@Entity
@IdClass(PogodaEntityPK.class)
@javax.persistence.Table(name = "Pogoda", schema = "", catalog = "")
public class PogodaEntity {
    @Id
    private String data;

    @Basic
    @Column(name = "Data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Id
    private Integer godzina;

    @Basic
    @Column(name = "Godzina")
    public Integer getGodzina() {
        return godzina;
    }

    public void setGodzina(Integer godzina) {
        this.godzina = godzina;
    }

    private Double minPredkoscWiatrumin;

    @Basic
    @Column(name = "MinPredkoscWiatrumin")
    public Double getMinPredkoscWiatrumin() {
        return minPredkoscWiatrumin;
    }

    public void setMinPredkoscWiatrumin(Double minPredkoscWiatrumin) {
        this.minPredkoscWiatrumin = minPredkoscWiatrumin;
    }

    private Double minPredkoscWiatruavg;

    @Basic
    @Column(name = "MinPredkoscWiatruavg")
    public Double getMinPredkoscWiatruavg() {
        return minPredkoscWiatruavg;
    }

    public void setMinPredkoscWiatruavg(Double minPredkoscWiatruavg) {
        this.minPredkoscWiatruavg = minPredkoscWiatruavg;
    }

    private Double minPredkoscWiatrumax;

    @Basic
    @Column(name = "MinPredkoscWiatrumax")
    public Double getMinPredkoscWiatrumax() {
        return minPredkoscWiatrumax;
    }

    public void setMinPredkoscWiatrumax(Double minPredkoscWiatrumax) {
        this.minPredkoscWiatrumax = minPredkoscWiatrumax;
    }

    private Double avgPredkoscWiatrumin;

    @Basic
    @Column(name = "AvgPredkoscWiatrumin")
    public Double getAvgPredkoscWiatrumin() {
        return avgPredkoscWiatrumin;
    }

    public void setAvgPredkoscWiatrumin(Double avgPredkoscWiatrumin) {
        this.avgPredkoscWiatrumin = avgPredkoscWiatrumin;
    }

    private Double avgPredkoscWiatruavg;

    @Basic
    @Column(name = "AvgPredkoscWiatruavg")
    public Double getAvgPredkoscWiatruavg() {
        return avgPredkoscWiatruavg;
    }

    public void setAvgPredkoscWiatruavg(Double avgPredkoscWiatruavg) {
        this.avgPredkoscWiatruavg = avgPredkoscWiatruavg;
    }

    private Double avgPredkoscWiatrumax;

    @Basic
    @Column(name = "AvgPredkoscWiatrumax")
    public Double getAvgPredkoscWiatrumax() {
        return avgPredkoscWiatrumax;
    }

    public void setAvgPredkoscWiatrumax(Double avgPredkoscWiatrumax) {
        this.avgPredkoscWiatrumax = avgPredkoscWiatrumax;
    }

    private Double maxPredkoscWiatrumin;

    @Basic
    @Column(name = "MaxPredkoscWiatrumin")
    public Double getMaxPredkoscWiatrumin() {
        return maxPredkoscWiatrumin;
    }

    public void setMaxPredkoscWiatrumin(Double maxPredkoscWiatrumin) {
        this.maxPredkoscWiatrumin = maxPredkoscWiatrumin;
    }

    private Double maxPredkoscWiatruavg;

    @Basic
    @Column(name = "MaxPredkoscWiatruavg")
    public Double getMaxPredkoscWiatruavg() {
        return maxPredkoscWiatruavg;
    }

    public void setMaxPredkoscWiatruavg(Double maxPredkoscWiatruavg) {
        this.maxPredkoscWiatruavg = maxPredkoscWiatruavg;
    }

    private Double maxPredkoscWiatrumax;

    @Basic
    @Column(name = "MaxPredkoscWiatrumax")
    public Double getMaxPredkoscWiatrumax() {
        return maxPredkoscWiatrumax;
    }

    public void setMaxPredkoscWiatrumax(Double maxPredkoscWiatrumax) {
        this.maxPredkoscWiatrumax = maxPredkoscWiatrumax;
    }

    private Double minKierunekWiatrumin;

    @Basic
    @Column(name = "MinKierunekWiatrumin")
    public Double getMinKierunekWiatrumin() {
        return minKierunekWiatrumin;
    }

    public void setMinKierunekWiatrumin(Double minKierunekWiatrumin) {
        this.minKierunekWiatrumin = minKierunekWiatrumin;
    }

    private Double minKierunekWiatruavg;

    @Basic
    @Column(name = "MinKierunekWiatruavg")
    public Double getMinKierunekWiatruavg() {
        return minKierunekWiatruavg;
    }

    public void setMinKierunekWiatruavg(Double minKierunekWiatruavg) {
        this.minKierunekWiatruavg = minKierunekWiatruavg;
    }

    private Double minKierunekWiatrumax;

    @Basic
    @Column(name = "MinKierunekWiatrumax")
    public Double getMinKierunekWiatrumax() {
        return minKierunekWiatrumax;
    }

    public void setMinKierunekWiatrumax(Double minKierunekWiatrumax) {
        this.minKierunekWiatrumax = minKierunekWiatrumax;
    }

    private Double avgKierunekWiatrumin;

    @Basic
    @Column(name = "AvgKierunekWiatrumin")
    public Double getAvgKierunekWiatrumin() {
        return avgKierunekWiatrumin;
    }

    public void setAvgKierunekWiatrumin(Double avgKierunekWiatrumin) {
        this.avgKierunekWiatrumin = avgKierunekWiatrumin;
    }

    private Double avgKierunekWiatruavg;

    @Basic
    @Column(name = "AvgKierunekWiatruavg")
    public Double getAvgKierunekWiatruavg() {
        return avgKierunekWiatruavg;
    }

    public void setAvgKierunekWiatruavg(Double avgKierunekWiatruavg) {
        this.avgKierunekWiatruavg = avgKierunekWiatruavg;
    }

    private Double avgKierunekWiatrumax;

    @Basic
    @Column(name = "AvgKierunekWiatrumax")
    public Double getAvgKierunekWiatrumax() {
        return avgKierunekWiatrumax;
    }

    public void setAvgKierunekWiatrumax(Double avgKierunekWiatrumax) {
        this.avgKierunekWiatrumax = avgKierunekWiatrumax;
    }

    private Double maxKierunekWiatrumin;

    @Basic
    @Column(name = "MaxKierunekWiatrumin")
    public Double getMaxKierunekWiatrumin() {
        return maxKierunekWiatrumin;
    }

    public void setMaxKierunekWiatrumin(Double maxKierunekWiatrumin) {
        this.maxKierunekWiatrumin = maxKierunekWiatrumin;
    }

    private Double maxKierunekWiatruavg;

    @Basic
    @Column(name = "MaxKierunekWiatruavg")
    public Double getMaxKierunekWiatruavg() {
        return maxKierunekWiatruavg;
    }

    public void setMaxKierunekWiatruavg(Double maxKierunekWiatruavg) {
        this.maxKierunekWiatruavg = maxKierunekWiatruavg;
    }

    private Double maxKierunekWiatrumax;

    @Basic
    @Column(name = "MaxKierunekWiatrumax")
    public Double getMaxKierunekWiatrumax() {
        return maxKierunekWiatrumax;
    }

    public void setMaxKierunekWiatrumax(Double maxKierunekWiatrumax) {
        this.maxKierunekWiatrumax = maxKierunekWiatrumax;
    }

    private Double tempPowietrzamin;

    @Basic
    @Column(name = "TempPowietrzamin")
    public Double getTempPowietrzamin() {
        return tempPowietrzamin;
    }

    public void setTempPowietrzamin(Double tempPowietrzamin) {
        this.tempPowietrzamin = tempPowietrzamin;
    }

    private Double tempPowietrzaavg;

    @Basic
    @Column(name = "TempPowietrzaavg")
    public Double getTempPowietrzaavg() {
        return tempPowietrzaavg;
    }

    public void setTempPowietrzaavg(Double tempPowietrzaavg) {
        this.tempPowietrzaavg = tempPowietrzaavg;
    }

    private Double tempPowietrzamax;

    @Basic
    @Column(name = "TempPowietrzamax")
    public Double getTempPowietrzamax() {
        return tempPowietrzamax;
    }

    public void setTempPowietrzamax(Double tempPowietrzamax) {
        this.tempPowietrzamax = tempPowietrzamax;
    }

    private Double cisnieniemin;

    @Basic
    @Column(name = "Cisnieniemin")
    public Double getCisnieniemin() {
        return cisnieniemin;
    }

    public void setCisnieniemin(Double cisnieniemin) {
        this.cisnieniemin = cisnieniemin;
    }

    private Double cisnienieavg;

    @Basic
    @Column(name = "Cisnienieavg")
    public Double getCisnienieavg() {
        return cisnienieavg;
    }

    public void setCisnienieavg(Double cisnienieavg) {
        this.cisnienieavg = cisnienieavg;
    }

    private Double cisnieniemax;

    @Basic
    @Column(name = "Cisnieniemax")
    public Double getCisnieniemax() {
        return cisnieniemax;
    }

    public void setCisnieniemax(Double cisnieniemax) {
        this.cisnieniemax = cisnieniemax;
    }

    private Double tempStacjimin;

    @Basic
    @Column(name = "TempStacjimin")
    public Double getTempStacjimin() {
        return tempStacjimin;
    }

    public void setTempStacjimin(Double tempStacjimin) {
        this.tempStacjimin = tempStacjimin;
    }

    private Double tempStacjiavg;

    @Basic
    @Column(name = "TempStacjiavg")
    public Double getTempStacjiavg() {
        return tempStacjiavg;
    }

    public void setTempStacjiavg(Double tempStacjiavg) {
        this.tempStacjiavg = tempStacjiavg;
    }

    private Double tempStacjimax;

    @Basic
    @Column(name = "TempStacjimax")
    public Double getTempStacjimax() {
        return tempStacjimax;
    }

    public void setTempStacjimax(Double tempStacjimax) {
        this.tempStacjimax = tempStacjimax;
    }

    private Double wilgotnoscmin;

    @Basic
    @Column(name = "Wilgotnoscmin")
    public Double getWilgotnoscmin() {
        return wilgotnoscmin;
    }

    public void setWilgotnoscmin(Double wilgotnoscmin) {
        this.wilgotnoscmin = wilgotnoscmin;
    }

    private Double wilgotnoscavg;

    @Basic
    @Column(name = "Wilgotnoscavg")
    public Double getWilgotnoscavg() {
        return wilgotnoscavg;
    }

    public void setWilgotnoscavg(Double wilgotnoscavg) {
        this.wilgotnoscavg = wilgotnoscavg;
    }

    private Double wilgotnoscmax;

    @Basic
    @Column(name = "Wilgotnoscmax")
    public Double getWilgotnoscmax() {
        return wilgotnoscmax;
    }

    public void setWilgotnoscmax(Double wilgotnoscmax) {
        this.wilgotnoscmax = wilgotnoscmax;
    }

    private Double opadmin;

    @Basic
    @Column(name = "Opadmin")
    public Double getOpadmin() {
        return opadmin;
    }

    public void setOpadmin(Double opadmin) {
        this.opadmin = opadmin;
    }

    private Double opadavg;

    @Basic
    @Column(name = "Opadavg")
    public Double getOpadavg() {
        return opadavg;
    }

    public void setOpadavg(Double opadavg) {
        this.opadavg = opadavg;
    }

    private Double opadmax;

    @Basic
    @Column(name = "Opadmax")
    public Double getOpadmax() {
        return opadmax;
    }

    public void setOpadmax(Double opadmax) {
        this.opadmax = opadmax;
    }

    private Double opadCzasmin;

    @Basic
    @Column(name = "OpadCzasmin")
    public Double getOpadCzasmin() {
        return opadCzasmin;
    }

    public void setOpadCzasmin(Double opadCzasmin) {
        this.opadCzasmin = opadCzasmin;
    }

    private Double opadCzasavg;

    @Basic
    @Column(name = "OpadCzasavg")
    public Double getOpadCzasavg() {
        return opadCzasavg;
    }

    public void setOpadCzasavg(Double opadCzasavg) {
        this.opadCzasavg = opadCzasavg;
    }

    private Double opadCzasmax;

    @Basic
    @Column(name = "OpadCzasmax")
    public Double getOpadCzasmax() {
        return opadCzasmax;
    }

    public void setOpadCzasmax(Double opadCzasmax) {
        this.opadCzasmax = opadCzasmax;
    }

    private Double opadIntenmin;

    @Basic
    @Column(name = "OpadIntenmin")
    public Double getOpadIntenmin() {
        return opadIntenmin;
    }

    public void setOpadIntenmin(Double opadIntenmin) {
        this.opadIntenmin = opadIntenmin;
    }

    private Double opadIntenavg;

    @Basic
    @Column(name = "OpadIntenavg")
    public Double getOpadIntenavg() {
        return opadIntenavg;
    }

    public void setOpadIntenavg(Double opadIntenavg) {
        this.opadIntenavg = opadIntenavg;
    }

    private Double opadIntenmax;

    @Basic
    @Column(name = "OpadIntenmax")
    public Double getOpadIntenmax() {
        return opadIntenmax;
    }

    public void setOpadIntenmax(Double opadIntenmax) {
        this.opadIntenmax = opadIntenmax;
    }

    private Double maxOpadIntenmin;

    @Basic
    @Column(name = "MaxOpadIntenmin")
    public Double getMaxOpadIntenmin() {
        return maxOpadIntenmin;
    }

    public void setMaxOpadIntenmin(Double maxOpadIntenmin) {
        this.maxOpadIntenmin = maxOpadIntenmin;
    }

    private Double maxOpadIntenavg;

    @Basic
    @Column(name = "MaxOpadIntenavg")
    public Double getMaxOpadIntenavg() {
        return maxOpadIntenavg;
    }

    public void setMaxOpadIntenavg(Double maxOpadIntenavg) {
        this.maxOpadIntenavg = maxOpadIntenavg;
    }

    private Double maxOpadIntenmax;

    @Basic
    @Column(name = "MaxOpadIntenmax")
    public Double getMaxOpadIntenmax() {
        return maxOpadIntenmax;
    }

    public void setMaxOpadIntenmax(Double maxOpadIntenmax) {
        this.maxOpadIntenmax = maxOpadIntenmax;
    }

    private Double gradmin;

    @Basic
    @Column(name = "Gradmin")
    public Double getGradmin() {
        return gradmin;
    }

    public void setGradmin(Double gradmin) {
        this.gradmin = gradmin;
    }

    private Double gradavg;

    @Basic
    @Column(name = "Gradavg")
    public Double getGradavg() {
        return gradavg;
    }

    public void setGradavg(Double gradavg) {
        this.gradavg = gradavg;
    }

    private Double gradmax;

    @Basic
    @Column(name = "Gradmax")
    public Double getGradmax() {
        return gradmax;
    }

    public void setGradmax(Double gradmax) {
        this.gradmax = gradmax;
    }

    private Double gradCzasmin;

    @Basic
    @Column(name = "GradCzasmin")
    public Double getGradCzasmin() {
        return gradCzasmin;
    }

    public void setGradCzasmin(Double gradCzasmin) {
        this.gradCzasmin = gradCzasmin;
    }

    private Double gradCzasavg;

    @Basic
    @Column(name = "GradCzasavg")
    public Double getGradCzasavg() {
        return gradCzasavg;
    }

    public void setGradCzasavg(Double gradCzasavg) {
        this.gradCzasavg = gradCzasavg;
    }

    private Double gradCzasmax;

    @Basic
    @Column(name = "GradCzasmax")
    public Double getGradCzasmax() {
        return gradCzasmax;
    }

    public void setGradCzasmax(Double gradCzasmax) {
        this.gradCzasmax = gradCzasmax;
    }

    private Double gradIntenmin;

    @Basic
    @Column(name = "GradIntenmin")
    public Double getGradIntenmin() {
        return gradIntenmin;
    }

    public void setGradIntenmin(Double gradIntenmin) {
        this.gradIntenmin = gradIntenmin;
    }

    private Double gradIntenavg;

    @Basic
    @Column(name = "GradIntenavg")
    public Double getGradIntenavg() {
        return gradIntenavg;
    }

    public void setGradIntenavg(Double gradIntenavg) {
        this.gradIntenavg = gradIntenavg;
    }

    private Double gradIntenmax;

    @Basic
    @Column(name = "GradIntenmax")
    public Double getGradIntenmax() {
        return gradIntenmax;
    }

    public void setGradIntenmax(Double gradIntenmax) {
        this.gradIntenmax = gradIntenmax;
    }

    private Double maxGradIntenmin;

    @Basic
    @Column(name = "MaxGradIntenmin")
    public Double getMaxGradIntenmin() {
        return maxGradIntenmin;
    }

    public void setMaxGradIntenmin(Double maxGradIntenmin) {
        this.maxGradIntenmin = maxGradIntenmin;
    }

    private Double maxGradIntenavg;

    @Basic
    @Column(name = "MaxGradIntenavg")
    public Double getMaxGradIntenavg() {
        return maxGradIntenavg;
    }

    public void setMaxGradIntenavg(Double maxGradIntenavg) {
        this.maxGradIntenavg = maxGradIntenavg;
    }

    private Double maxGradIntenmax;

    @Basic
    @Column(name = "MaxGradIntenmax")
    public Double getMaxGradIntenmax() {
        return maxGradIntenmax;
    }

    public void setMaxGradIntenmax(Double maxGradIntenmax) {
        this.maxGradIntenmax = maxGradIntenmax;
    }

    private Double heatingTempmin;

    @Basic
    @Column(name = "HeatingTempmin")
    public Double getHeatingTempmin() {
        return heatingTempmin;
    }

    public void setHeatingTempmin(Double heatingTempmin) {
        this.heatingTempmin = heatingTempmin;
    }

    private Double heatingTempavg;

    @Basic
    @Column(name = "HeatingTempavg")
    public Double getHeatingTempavg() {
        return heatingTempavg;
    }

    public void setHeatingTempavg(Double heatingTempavg) {
        this.heatingTempavg = heatingTempavg;
    }

    private Double heatingTempmax;

    @Basic
    @Column(name = "HeatingTempmax")
    public Double getHeatingTempmax() {
        return heatingTempmax;
    }

    public void setHeatingTempmax(Double heatingTempmax) {
        this.heatingTempmax = heatingTempmax;
    }

    private Double heatingVoltmin;

    @Basic
    @Column(name = "HeatingVoltmin")
    public Double getHeatingVoltmin() {
        return heatingVoltmin;
    }

    public void setHeatingVoltmin(Double heatingVoltmin) {
        this.heatingVoltmin = heatingVoltmin;
    }

    private Double heatingVoltavg;

    @Basic
    @Column(name = "HeatingVoltavg")
    public Double getHeatingVoltavg() {
        return heatingVoltavg;
    }

    public void setHeatingVoltavg(Double heatingVoltavg) {
        this.heatingVoltavg = heatingVoltavg;
    }

    private Double heatingVoltmax;

    @Basic
    @Column(name = "HeatingVoltmax")
    public Double getHeatingVoltmax() {
        return heatingVoltmax;
    }

    public void setHeatingVoltmax(Double heatingVoltmax) {
        this.heatingVoltmax = heatingVoltmax;
    }

    private Double supplyVoltmin;

    @Basic
    @Column(name = "SupplyVoltmin")
    public Double getSupplyVoltmin() {
        return supplyVoltmin;
    }

    public void setSupplyVoltmin(Double supplyVoltmin) {
        this.supplyVoltmin = supplyVoltmin;
    }

    private Double supplyVoltavg;

    @Basic
    @Column(name = "SupplyVoltavg")
    public Double getSupplyVoltavg() {
        return supplyVoltavg;
    }

    public void setSupplyVoltavg(Double supplyVoltavg) {
        this.supplyVoltavg = supplyVoltavg;
    }

    private Double supplyVoltmax;

    @Basic
    @Column(name = "SupplyVoltmax")
    public Double getSupplyVoltmax() {
        return supplyVoltmax;
    }

    public void setSupplyVoltmax(Double supplyVoltmax) {
        this.supplyVoltmax = supplyVoltmax;
    }

    private Double refVoltmin;

    @Basic
    @Column(name = "RefVoltmin")
    public Double getRefVoltmin() {
        return refVoltmin;
    }

    public void setRefVoltmin(Double refVoltmin) {
        this.refVoltmin = refVoltmin;
    }

    private Double refVoltavg;

    @Basic
    @Column(name = "RefVoltavg")
    public Double getRefVoltavg() {
        return refVoltavg;
    }

    public void setRefVoltavg(Double refVoltavg) {
        this.refVoltavg = refVoltavg;
    }

    private Double refVoltmax;

    @Basic
    @Column(name = "RefVoltmax")
    public Double getRefVoltmax() {
        return refVoltmax;
    }

    public void setRefVoltmax(Double refVoltmax) {
        this.refVoltmax = refVoltmax;
    }

    private Double tempPktRosymin;

    @Basic
    @Column(name = "TempPktRosymin")
    public Double getTempPktRosymin() {
        return tempPktRosymin;
    }

    public void setTempPktRosymin(Double tempPktRosymin) {
        this.tempPktRosymin = tempPktRosymin;
    }

    private Double tempPktRosyavg;

    @Basic
    @Column(name = "TempPktRosyavg")
    public Double getTempPktRosyavg() {
        return tempPktRosyavg;
    }

    public void setTempPktRosyavg(Double tempPktRosyavg) {
        this.tempPktRosyavg = tempPktRosyavg;
    }

    private Double tempPktRosymax;

    @Basic
    @Column(name = "TempPktRosymax")
    public Double getTempPktRosymax() {
        return tempPktRosymax;
    }

    public void setTempPktRosymax(Double tempPktRosymax) {
        this.tempPktRosymax = tempPktRosymax;
    }

    private Double cisBarommin;

    @Basic
    @Column(name = "CisBarommin")
    public Double getCisBarommin() {
        return cisBarommin;
    }

    public void setCisBarommin(Double cisBarommin) {
        this.cisBarommin = cisBarommin;
    }

    private Double cisBaromavg;

    @Basic
    @Column(name = "CisBaromavg")
    public Double getCisBaromavg() {
        return cisBaromavg;
    }

    public void setCisBaromavg(Double cisBaromavg) {
        this.cisBaromavg = cisBaromavg;
    }

    private Double cisBarommax;

    @Basic
    @Column(name = "CisBarommax")
    public Double getCisBarommax() {
        return cisBarommax;
    }

    public void setCisBarommax(Double cisBarommax) {
        this.cisBarommax = cisBarommax;
    }

    private Double windchillTempmin;

    @Basic
    @Column(name = "WindchillTempmin")
    public Double getWindchillTempmin() {
        return windchillTempmin;
    }

    public void setWindchillTempmin(Double windchillTempmin) {
        this.windchillTempmin = windchillTempmin;
    }

    private Double windchillTempavg;

    @Basic
    @Column(name = "WindchillTempavg")
    public Double getWindchillTempavg() {
        return windchillTempavg;
    }

    public void setWindchillTempavg(Double windchillTempavg) {
        this.windchillTempavg = windchillTempavg;
    }

    private Double windchillTempmax;

    @Basic
    @Column(name = "WindchillTempmax")
    public Double getWindchillTempmax() {
        return windchillTempmax;
    }

    public void setWindchillTempmax(Double windchillTempmax) {
        this.windchillTempmax = windchillTempmax;
    }

    private Double heatindexTempmin;

    @Basic
    @Column(name = "HeatindexTempmin")
    public Double getHeatindexTempmin() {
        return heatindexTempmin;
    }

    public void setHeatindexTempmin(Double heatindexTempmin) {
        this.heatindexTempmin = heatindexTempmin;
    }

    private Double heatindexTempavg;

    @Basic
    @Column(name = "HeatindexTempavg")
    public Double getHeatindexTempavg() {
        return heatindexTempavg;
    }

    public void setHeatindexTempavg(Double heatindexTempavg) {
        this.heatindexTempavg = heatindexTempavg;
    }

    private Double heatindexTempmax;

    @Basic
    @Column(name = "HeatindexTempmax")
    public Double getHeatindexTempmax() {
        return heatindexTempmax;
    }

    public void setHeatindexTempmax(Double heatindexTempmax) {
        this.heatindexTempmax = heatindexTempmax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PogodaEntity that = (PogodaEntity) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (godzina != null ? !godzina.equals(that.godzina) : that.godzina != null) return false;
        if (minPredkoscWiatrumin != null ? !minPredkoscWiatrumin.equals(that.minPredkoscWiatrumin) : that.minPredkoscWiatrumin != null)
            return false;
        if (minPredkoscWiatruavg != null ? !minPredkoscWiatruavg.equals(that.minPredkoscWiatruavg) : that.minPredkoscWiatruavg != null)
            return false;
        if (minPredkoscWiatrumax != null ? !minPredkoscWiatrumax.equals(that.minPredkoscWiatrumax) : that.minPredkoscWiatrumax != null)
            return false;
        if (avgPredkoscWiatrumin != null ? !avgPredkoscWiatrumin.equals(that.avgPredkoscWiatrumin) : that.avgPredkoscWiatrumin != null)
            return false;
        if (avgPredkoscWiatruavg != null ? !avgPredkoscWiatruavg.equals(that.avgPredkoscWiatruavg) : that.avgPredkoscWiatruavg != null)
            return false;
        if (avgPredkoscWiatrumax != null ? !avgPredkoscWiatrumax.equals(that.avgPredkoscWiatrumax) : that.avgPredkoscWiatrumax != null)
            return false;
        if (maxPredkoscWiatrumin != null ? !maxPredkoscWiatrumin.equals(that.maxPredkoscWiatrumin) : that.maxPredkoscWiatrumin != null)
            return false;
        if (maxPredkoscWiatruavg != null ? !maxPredkoscWiatruavg.equals(that.maxPredkoscWiatruavg) : that.maxPredkoscWiatruavg != null)
            return false;
        if (maxPredkoscWiatrumax != null ? !maxPredkoscWiatrumax.equals(that.maxPredkoscWiatrumax) : that.maxPredkoscWiatrumax != null)
            return false;
        if (minKierunekWiatrumin != null ? !minKierunekWiatrumin.equals(that.minKierunekWiatrumin) : that.minKierunekWiatrumin != null)
            return false;
        if (minKierunekWiatruavg != null ? !minKierunekWiatruavg.equals(that.minKierunekWiatruavg) : that.minKierunekWiatruavg != null)
            return false;
        if (minKierunekWiatrumax != null ? !minKierunekWiatrumax.equals(that.minKierunekWiatrumax) : that.minKierunekWiatrumax != null)
            return false;
        if (avgKierunekWiatrumin != null ? !avgKierunekWiatrumin.equals(that.avgKierunekWiatrumin) : that.avgKierunekWiatrumin != null)
            return false;
        if (avgKierunekWiatruavg != null ? !avgKierunekWiatruavg.equals(that.avgKierunekWiatruavg) : that.avgKierunekWiatruavg != null)
            return false;
        if (avgKierunekWiatrumax != null ? !avgKierunekWiatrumax.equals(that.avgKierunekWiatrumax) : that.avgKierunekWiatrumax != null)
            return false;
        if (maxKierunekWiatrumin != null ? !maxKierunekWiatrumin.equals(that.maxKierunekWiatrumin) : that.maxKierunekWiatrumin != null)
            return false;
        if (maxKierunekWiatruavg != null ? !maxKierunekWiatruavg.equals(that.maxKierunekWiatruavg) : that.maxKierunekWiatruavg != null)
            return false;
        if (maxKierunekWiatrumax != null ? !maxKierunekWiatrumax.equals(that.maxKierunekWiatrumax) : that.maxKierunekWiatrumax != null)
            return false;
        if (tempPowietrzamin != null ? !tempPowietrzamin.equals(that.tempPowietrzamin) : that.tempPowietrzamin != null)
            return false;
        if (tempPowietrzaavg != null ? !tempPowietrzaavg.equals(that.tempPowietrzaavg) : that.tempPowietrzaavg != null)
            return false;
        if (tempPowietrzamax != null ? !tempPowietrzamax.equals(that.tempPowietrzamax) : that.tempPowietrzamax != null)
            return false;
        if (cisnieniemin != null ? !cisnieniemin.equals(that.cisnieniemin) : that.cisnieniemin != null) return false;
        if (cisnienieavg != null ? !cisnienieavg.equals(that.cisnienieavg) : that.cisnienieavg != null) return false;
        if (cisnieniemax != null ? !cisnieniemax.equals(that.cisnieniemax) : that.cisnieniemax != null) return false;
        if (tempStacjimin != null ? !tempStacjimin.equals(that.tempStacjimin) : that.tempStacjimin != null)
            return false;
        if (tempStacjiavg != null ? !tempStacjiavg.equals(that.tempStacjiavg) : that.tempStacjiavg != null)
            return false;
        if (tempStacjimax != null ? !tempStacjimax.equals(that.tempStacjimax) : that.tempStacjimax != null)
            return false;
        if (wilgotnoscmin != null ? !wilgotnoscmin.equals(that.wilgotnoscmin) : that.wilgotnoscmin != null)
            return false;
        if (wilgotnoscavg != null ? !wilgotnoscavg.equals(that.wilgotnoscavg) : that.wilgotnoscavg != null)
            return false;
        if (wilgotnoscmax != null ? !wilgotnoscmax.equals(that.wilgotnoscmax) : that.wilgotnoscmax != null)
            return false;
        if (opadmin != null ? !opadmin.equals(that.opadmin) : that.opadmin != null) return false;
        if (opadavg != null ? !opadavg.equals(that.opadavg) : that.opadavg != null) return false;
        if (opadmax != null ? !opadmax.equals(that.opadmax) : that.opadmax != null) return false;
        if (opadCzasmin != null ? !opadCzasmin.equals(that.opadCzasmin) : that.opadCzasmin != null) return false;
        if (opadCzasavg != null ? !opadCzasavg.equals(that.opadCzasavg) : that.opadCzasavg != null) return false;
        if (opadCzasmax != null ? !opadCzasmax.equals(that.opadCzasmax) : that.opadCzasmax != null) return false;
        if (opadIntenmin != null ? !opadIntenmin.equals(that.opadIntenmin) : that.opadIntenmin != null) return false;
        if (opadIntenavg != null ? !opadIntenavg.equals(that.opadIntenavg) : that.opadIntenavg != null) return false;
        if (opadIntenmax != null ? !opadIntenmax.equals(that.opadIntenmax) : that.opadIntenmax != null) return false;
        if (maxOpadIntenmin != null ? !maxOpadIntenmin.equals(that.maxOpadIntenmin) : that.maxOpadIntenmin != null)
            return false;
        if (maxOpadIntenavg != null ? !maxOpadIntenavg.equals(that.maxOpadIntenavg) : that.maxOpadIntenavg != null)
            return false;
        if (maxOpadIntenmax != null ? !maxOpadIntenmax.equals(that.maxOpadIntenmax) : that.maxOpadIntenmax != null)
            return false;
        if (gradmin != null ? !gradmin.equals(that.gradmin) : that.gradmin != null) return false;
        if (gradavg != null ? !gradavg.equals(that.gradavg) : that.gradavg != null) return false;
        if (gradmax != null ? !gradmax.equals(that.gradmax) : that.gradmax != null) return false;
        if (gradCzasmin != null ? !gradCzasmin.equals(that.gradCzasmin) : that.gradCzasmin != null) return false;
        if (gradCzasavg != null ? !gradCzasavg.equals(that.gradCzasavg) : that.gradCzasavg != null) return false;
        if (gradCzasmax != null ? !gradCzasmax.equals(that.gradCzasmax) : that.gradCzasmax != null) return false;
        if (gradIntenmin != null ? !gradIntenmin.equals(that.gradIntenmin) : that.gradIntenmin != null) return false;
        if (gradIntenavg != null ? !gradIntenavg.equals(that.gradIntenavg) : that.gradIntenavg != null) return false;
        if (gradIntenmax != null ? !gradIntenmax.equals(that.gradIntenmax) : that.gradIntenmax != null) return false;
        if (maxGradIntenmin != null ? !maxGradIntenmin.equals(that.maxGradIntenmin) : that.maxGradIntenmin != null)
            return false;
        if (maxGradIntenavg != null ? !maxGradIntenavg.equals(that.maxGradIntenavg) : that.maxGradIntenavg != null)
            return false;
        if (maxGradIntenmax != null ? !maxGradIntenmax.equals(that.maxGradIntenmax) : that.maxGradIntenmax != null)
            return false;
        if (heatingTempmin != null ? !heatingTempmin.equals(that.heatingTempmin) : that.heatingTempmin != null)
            return false;
        if (heatingTempavg != null ? !heatingTempavg.equals(that.heatingTempavg) : that.heatingTempavg != null)
            return false;
        if (heatingTempmax != null ? !heatingTempmax.equals(that.heatingTempmax) : that.heatingTempmax != null)
            return false;
        if (heatingVoltmin != null ? !heatingVoltmin.equals(that.heatingVoltmin) : that.heatingVoltmin != null)
            return false;
        if (heatingVoltavg != null ? !heatingVoltavg.equals(that.heatingVoltavg) : that.heatingVoltavg != null)
            return false;
        if (heatingVoltmax != null ? !heatingVoltmax.equals(that.heatingVoltmax) : that.heatingVoltmax != null)
            return false;
        if (supplyVoltmin != null ? !supplyVoltmin.equals(that.supplyVoltmin) : that.supplyVoltmin != null)
            return false;
        if (supplyVoltavg != null ? !supplyVoltavg.equals(that.supplyVoltavg) : that.supplyVoltavg != null)
            return false;
        if (supplyVoltmax != null ? !supplyVoltmax.equals(that.supplyVoltmax) : that.supplyVoltmax != null)
            return false;
        if (refVoltmin != null ? !refVoltmin.equals(that.refVoltmin) : that.refVoltmin != null) return false;
        if (refVoltavg != null ? !refVoltavg.equals(that.refVoltavg) : that.refVoltavg != null) return false;
        if (refVoltmax != null ? !refVoltmax.equals(that.refVoltmax) : that.refVoltmax != null) return false;
        if (tempPktRosymin != null ? !tempPktRosymin.equals(that.tempPktRosymin) : that.tempPktRosymin != null)
            return false;
        if (tempPktRosyavg != null ? !tempPktRosyavg.equals(that.tempPktRosyavg) : that.tempPktRosyavg != null)
            return false;
        if (tempPktRosymax != null ? !tempPktRosymax.equals(that.tempPktRosymax) : that.tempPktRosymax != null)
            return false;
        if (cisBarommin != null ? !cisBarommin.equals(that.cisBarommin) : that.cisBarommin != null) return false;
        if (cisBaromavg != null ? !cisBaromavg.equals(that.cisBaromavg) : that.cisBaromavg != null) return false;
        if (cisBarommax != null ? !cisBarommax.equals(that.cisBarommax) : that.cisBarommax != null) return false;
        if (windchillTempmin != null ? !windchillTempmin.equals(that.windchillTempmin) : that.windchillTempmin != null)
            return false;
        if (windchillTempavg != null ? !windchillTempavg.equals(that.windchillTempavg) : that.windchillTempavg != null)
            return false;
        if (windchillTempmax != null ? !windchillTempmax.equals(that.windchillTempmax) : that.windchillTempmax != null)
            return false;
        if (heatindexTempmin != null ? !heatindexTempmin.equals(that.heatindexTempmin) : that.heatindexTempmin != null)
            return false;
        if (heatindexTempavg != null ? !heatindexTempavg.equals(that.heatindexTempavg) : that.heatindexTempavg != null)
            return false;
        if (heatindexTempmax != null ? !heatindexTempmax.equals(that.heatindexTempmax) : that.heatindexTempmax != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (godzina != null ? godzina.hashCode() : 0);
        result = 31 * result + (minPredkoscWiatrumin != null ? minPredkoscWiatrumin.hashCode() : 0);
        result = 31 * result + (minPredkoscWiatruavg != null ? minPredkoscWiatruavg.hashCode() : 0);
        result = 31 * result + (minPredkoscWiatrumax != null ? minPredkoscWiatrumax.hashCode() : 0);
        result = 31 * result + (avgPredkoscWiatrumin != null ? avgPredkoscWiatrumin.hashCode() : 0);
        result = 31 * result + (avgPredkoscWiatruavg != null ? avgPredkoscWiatruavg.hashCode() : 0);
        result = 31 * result + (avgPredkoscWiatrumax != null ? avgPredkoscWiatrumax.hashCode() : 0);
        result = 31 * result + (maxPredkoscWiatrumin != null ? maxPredkoscWiatrumin.hashCode() : 0);
        result = 31 * result + (maxPredkoscWiatruavg != null ? maxPredkoscWiatruavg.hashCode() : 0);
        result = 31 * result + (maxPredkoscWiatrumax != null ? maxPredkoscWiatrumax.hashCode() : 0);
        result = 31 * result + (minKierunekWiatrumin != null ? minKierunekWiatrumin.hashCode() : 0);
        result = 31 * result + (minKierunekWiatruavg != null ? minKierunekWiatruavg.hashCode() : 0);
        result = 31 * result + (minKierunekWiatrumax != null ? minKierunekWiatrumax.hashCode() : 0);
        result = 31 * result + (avgKierunekWiatrumin != null ? avgKierunekWiatrumin.hashCode() : 0);
        result = 31 * result + (avgKierunekWiatruavg != null ? avgKierunekWiatruavg.hashCode() : 0);
        result = 31 * result + (avgKierunekWiatrumax != null ? avgKierunekWiatrumax.hashCode() : 0);
        result = 31 * result + (maxKierunekWiatrumin != null ? maxKierunekWiatrumin.hashCode() : 0);
        result = 31 * result + (maxKierunekWiatruavg != null ? maxKierunekWiatruavg.hashCode() : 0);
        result = 31 * result + (maxKierunekWiatrumax != null ? maxKierunekWiatrumax.hashCode() : 0);
        result = 31 * result + (tempPowietrzamin != null ? tempPowietrzamin.hashCode() : 0);
        result = 31 * result + (tempPowietrzaavg != null ? tempPowietrzaavg.hashCode() : 0);
        result = 31 * result + (tempPowietrzamax != null ? tempPowietrzamax.hashCode() : 0);
        result = 31 * result + (cisnieniemin != null ? cisnieniemin.hashCode() : 0);
        result = 31 * result + (cisnienieavg != null ? cisnienieavg.hashCode() : 0);
        result = 31 * result + (cisnieniemax != null ? cisnieniemax.hashCode() : 0);
        result = 31 * result + (tempStacjimin != null ? tempStacjimin.hashCode() : 0);
        result = 31 * result + (tempStacjiavg != null ? tempStacjiavg.hashCode() : 0);
        result = 31 * result + (tempStacjimax != null ? tempStacjimax.hashCode() : 0);
        result = 31 * result + (wilgotnoscmin != null ? wilgotnoscmin.hashCode() : 0);
        result = 31 * result + (wilgotnoscavg != null ? wilgotnoscavg.hashCode() : 0);
        result = 31 * result + (wilgotnoscmax != null ? wilgotnoscmax.hashCode() : 0);
        result = 31 * result + (opadmin != null ? opadmin.hashCode() : 0);
        result = 31 * result + (opadavg != null ? opadavg.hashCode() : 0);
        result = 31 * result + (opadmax != null ? opadmax.hashCode() : 0);
        result = 31 * result + (opadCzasmin != null ? opadCzasmin.hashCode() : 0);
        result = 31 * result + (opadCzasavg != null ? opadCzasavg.hashCode() : 0);
        result = 31 * result + (opadCzasmax != null ? opadCzasmax.hashCode() : 0);
        result = 31 * result + (opadIntenmin != null ? opadIntenmin.hashCode() : 0);
        result = 31 * result + (opadIntenavg != null ? opadIntenavg.hashCode() : 0);
        result = 31 * result + (opadIntenmax != null ? opadIntenmax.hashCode() : 0);
        result = 31 * result + (maxOpadIntenmin != null ? maxOpadIntenmin.hashCode() : 0);
        result = 31 * result + (maxOpadIntenavg != null ? maxOpadIntenavg.hashCode() : 0);
        result = 31 * result + (maxOpadIntenmax != null ? maxOpadIntenmax.hashCode() : 0);
        result = 31 * result + (gradmin != null ? gradmin.hashCode() : 0);
        result = 31 * result + (gradavg != null ? gradavg.hashCode() : 0);
        result = 31 * result + (gradmax != null ? gradmax.hashCode() : 0);
        result = 31 * result + (gradCzasmin != null ? gradCzasmin.hashCode() : 0);
        result = 31 * result + (gradCzasavg != null ? gradCzasavg.hashCode() : 0);
        result = 31 * result + (gradCzasmax != null ? gradCzasmax.hashCode() : 0);
        result = 31 * result + (gradIntenmin != null ? gradIntenmin.hashCode() : 0);
        result = 31 * result + (gradIntenavg != null ? gradIntenavg.hashCode() : 0);
        result = 31 * result + (gradIntenmax != null ? gradIntenmax.hashCode() : 0);
        result = 31 * result + (maxGradIntenmin != null ? maxGradIntenmin.hashCode() : 0);
        result = 31 * result + (maxGradIntenavg != null ? maxGradIntenavg.hashCode() : 0);
        result = 31 * result + (maxGradIntenmax != null ? maxGradIntenmax.hashCode() : 0);
        result = 31 * result + (heatingTempmin != null ? heatingTempmin.hashCode() : 0);
        result = 31 * result + (heatingTempavg != null ? heatingTempavg.hashCode() : 0);
        result = 31 * result + (heatingTempmax != null ? heatingTempmax.hashCode() : 0);
        result = 31 * result + (heatingVoltmin != null ? heatingVoltmin.hashCode() : 0);
        result = 31 * result + (heatingVoltavg != null ? heatingVoltavg.hashCode() : 0);
        result = 31 * result + (heatingVoltmax != null ? heatingVoltmax.hashCode() : 0);
        result = 31 * result + (supplyVoltmin != null ? supplyVoltmin.hashCode() : 0);
        result = 31 * result + (supplyVoltavg != null ? supplyVoltavg.hashCode() : 0);
        result = 31 * result + (supplyVoltmax != null ? supplyVoltmax.hashCode() : 0);
        result = 31 * result + (refVoltmin != null ? refVoltmin.hashCode() : 0);
        result = 31 * result + (refVoltavg != null ? refVoltavg.hashCode() : 0);
        result = 31 * result + (refVoltmax != null ? refVoltmax.hashCode() : 0);
        result = 31 * result + (tempPktRosymin != null ? tempPktRosymin.hashCode() : 0);
        result = 31 * result + (tempPktRosyavg != null ? tempPktRosyavg.hashCode() : 0);
        result = 31 * result + (tempPktRosymax != null ? tempPktRosymax.hashCode() : 0);
        result = 31 * result + (cisBarommin != null ? cisBarommin.hashCode() : 0);
        result = 31 * result + (cisBaromavg != null ? cisBaromavg.hashCode() : 0);
        result = 31 * result + (cisBarommax != null ? cisBarommax.hashCode() : 0);
        result = 31 * result + (windchillTempmin != null ? windchillTempmin.hashCode() : 0);
        result = 31 * result + (windchillTempavg != null ? windchillTempavg.hashCode() : 0);
        result = 31 * result + (windchillTempmax != null ? windchillTempmax.hashCode() : 0);
        result = 31 * result + (heatindexTempmin != null ? heatindexTempmin.hashCode() : 0);
        result = 31 * result + (heatindexTempavg != null ? heatindexTempavg.hashCode() : 0);
        result = 31 * result + (heatindexTempmax != null ? heatindexTempmax.hashCode() : 0);
        return result;
    }
}
