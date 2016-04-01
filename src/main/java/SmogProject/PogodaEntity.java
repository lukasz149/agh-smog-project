package SmogProject;

import javax.persistence.*;

/**
 * Created by grzeg on 01.04.2016.
 */
@Entity
@IdClass(PogodaEntityPK.class)
@Table(name = "Pogoda", schema = "", catalog = "")
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

    private Double minPredkoscWiatruMin;

    @Basic
    @Column(name = "MinPredkoscWiatru_min")
    public Double getMinPredkoscWiatruMin() {
        return minPredkoscWiatruMin;
    }

    public void setMinPredkoscWiatruMin(Double minPredkoscWiatruMin) {
        this.minPredkoscWiatruMin = minPredkoscWiatruMin;
    }

    private Double minPredkoscWiatruAvg;

    @Basic
    @Column(name = "MinPredkoscWiatru_avg")
    public Double getMinPredkoscWiatruAvg() {
        return minPredkoscWiatruAvg;
    }

    public void setMinPredkoscWiatruAvg(Double minPredkoscWiatruAvg) {
        this.minPredkoscWiatruAvg = minPredkoscWiatruAvg;
    }

    private Double minPredkoscWiatruMax;

    @Basic
    @Column(name = "MinPredkoscWiatru_max")
    public Double getMinPredkoscWiatruMax() {
        return minPredkoscWiatruMax;
    }

    public void setMinPredkoscWiatruMax(Double minPredkoscWiatruMax) {
        this.minPredkoscWiatruMax = minPredkoscWiatruMax;
    }

    private Double avgPredkoscWiatruMin;

    @Basic
    @Column(name = "AvgPredkoscWiatru_min")
    public Double getAvgPredkoscWiatruMin() {
        return avgPredkoscWiatruMin;
    }

    public void setAvgPredkoscWiatruMin(Double avgPredkoscWiatruMin) {
        this.avgPredkoscWiatruMin = avgPredkoscWiatruMin;
    }

    private Double avgPredkoscWiatruAvg;

    @Basic
    @Column(name = "AvgPredkoscWiatru_avg")
    public Double getAvgPredkoscWiatruAvg() {
        return avgPredkoscWiatruAvg;
    }

    public void setAvgPredkoscWiatruAvg(Double avgPredkoscWiatruAvg) {
        this.avgPredkoscWiatruAvg = avgPredkoscWiatruAvg;
    }

    private Double avgPredkoscWiatruMax;

    @Basic
    @Column(name = "AvgPredkoscWiatru_max")
    public Double getAvgPredkoscWiatruMax() {
        return avgPredkoscWiatruMax;
    }

    public void setAvgPredkoscWiatruMax(Double avgPredkoscWiatruMax) {
        this.avgPredkoscWiatruMax = avgPredkoscWiatruMax;
    }

    private Double maxPredkoscWiatruMin;

    @Basic
    @Column(name = "MaxPredkoscWiatru_min")
    public Double getMaxPredkoscWiatruMin() {
        return maxPredkoscWiatruMin;
    }

    public void setMaxPredkoscWiatruMin(Double maxPredkoscWiatruMin) {
        this.maxPredkoscWiatruMin = maxPredkoscWiatruMin;
    }

    private Double maxPredkoscWiatruAvg;

    @Basic
    @Column(name = "MaxPredkoscWiatru_avg")
    public Double getMaxPredkoscWiatruAvg() {
        return maxPredkoscWiatruAvg;
    }

    public void setMaxPredkoscWiatruAvg(Double maxPredkoscWiatruAvg) {
        this.maxPredkoscWiatruAvg = maxPredkoscWiatruAvg;
    }

    private Double maxPredkoscWiatruMax;

    @Basic
    @Column(name = "MaxPredkoscWiatru_max")
    public Double getMaxPredkoscWiatruMax() {
        return maxPredkoscWiatruMax;
    }

    public void setMaxPredkoscWiatruMax(Double maxPredkoscWiatruMax) {
        this.maxPredkoscWiatruMax = maxPredkoscWiatruMax;
    }

    private Double minKierunekWiatruMin;

    @Basic
    @Column(name = "MinKierunekWiatru_min")
    public Double getMinKierunekWiatruMin() {
        return minKierunekWiatruMin;
    }

    public void setMinKierunekWiatruMin(Double minKierunekWiatruMin) {
        this.minKierunekWiatruMin = minKierunekWiatruMin;
    }

    private Double minKierunekWiatruAvg;

    @Basic
    @Column(name = "MinKierunekWiatru_avg")
    public Double getMinKierunekWiatruAvg() {
        return minKierunekWiatruAvg;
    }

    public void setMinKierunekWiatruAvg(Double minKierunekWiatruAvg) {
        this.minKierunekWiatruAvg = minKierunekWiatruAvg;
    }

    private Double minKierunekWiatruMax;

    @Basic
    @Column(name = "MinKierunekWiatru_max")
    public Double getMinKierunekWiatruMax() {
        return minKierunekWiatruMax;
    }

    public void setMinKierunekWiatruMax(Double minKierunekWiatruMax) {
        this.minKierunekWiatruMax = minKierunekWiatruMax;
    }

    private Double avgKierunekWiatruMin;

    @Basic
    @Column(name = "AvgKierunekWiatru_min")
    public Double getAvgKierunekWiatruMin() {
        return avgKierunekWiatruMin;
    }

    public void setAvgKierunekWiatruMin(Double avgKierunekWiatruMin) {
        this.avgKierunekWiatruMin = avgKierunekWiatruMin;
    }

    private Double avgKierunekWiatruAvg;

    @Basic
    @Column(name = "AvgKierunekWiatru_avg")
    public Double getAvgKierunekWiatruAvg() {
        return avgKierunekWiatruAvg;
    }

    public void setAvgKierunekWiatruAvg(Double avgKierunekWiatruAvg) {
        this.avgKierunekWiatruAvg = avgKierunekWiatruAvg;
    }

    private Double avgKierunekWiatruMax;

    @Basic
    @Column(name = "AvgKierunekWiatru_max")
    public Double getAvgKierunekWiatruMax() {
        return avgKierunekWiatruMax;
    }

    public void setAvgKierunekWiatruMax(Double avgKierunekWiatruMax) {
        this.avgKierunekWiatruMax = avgKierunekWiatruMax;
    }

    private Double maxKierunekWiatruMin;

    @Basic
    @Column(name = "MaxKierunekWiatru_min")
    public Double getMaxKierunekWiatruMin() {
        return maxKierunekWiatruMin;
    }

    public void setMaxKierunekWiatruMin(Double maxKierunekWiatruMin) {
        this.maxKierunekWiatruMin = maxKierunekWiatruMin;
    }

    private Double maxKierunekWiatruAvg;

    @Basic
    @Column(name = "MaxKierunekWiatru_avg")
    public Double getMaxKierunekWiatruAvg() {
        return maxKierunekWiatruAvg;
    }

    public void setMaxKierunekWiatruAvg(Double maxKierunekWiatruAvg) {
        this.maxKierunekWiatruAvg = maxKierunekWiatruAvg;
    }

    private Double maxKierunekWiatruMax;

    @Basic
    @Column(name = "MaxKierunekWiatru_max")
    public Double getMaxKierunekWiatruMax() {
        return maxKierunekWiatruMax;
    }

    public void setMaxKierunekWiatruMax(Double maxKierunekWiatruMax) {
        this.maxKierunekWiatruMax = maxKierunekWiatruMax;
    }

    private Double tempPowietrzaMin;

    @Basic
    @Column(name = "TempPowietrza_min")
    public Double getTempPowietrzaMin() {
        return tempPowietrzaMin;
    }

    public void setTempPowietrzaMin(Double tempPowietrzaMin) {
        this.tempPowietrzaMin = tempPowietrzaMin;
    }

    private Double tempPowietrzaAvg;

    @Basic
    @Column(name = "TempPowietrza_avg")
    public Double getTempPowietrzaAvg() {
        return tempPowietrzaAvg;
    }

    public void setTempPowietrzaAvg(Double tempPowietrzaAvg) {
        this.tempPowietrzaAvg = tempPowietrzaAvg;
    }

    private Double tempPowietrzaMax;

    @Basic
    @Column(name = "TempPowietrza_max")
    public Double getTempPowietrzaMax() {
        return tempPowietrzaMax;
    }

    public void setTempPowietrzaMax(Double tempPowietrzaMax) {
        this.tempPowietrzaMax = tempPowietrzaMax;
    }

    private Double cisnienieMin;

    @Basic
    @Column(name = "Cisnienie_min")
    public Double getCisnienieMin() {
        return cisnienieMin;
    }

    public void setCisnienieMin(Double cisnienieMin) {
        this.cisnienieMin = cisnienieMin;
    }

    private Double cisnienieAvg;

    @Basic
    @Column(name = "Cisnienie_avg")
    public Double getCisnienieAvg() {
        return cisnienieAvg;
    }

    public void setCisnienieAvg(Double cisnienieAvg) {
        this.cisnienieAvg = cisnienieAvg;
    }

    private Double cisnienieMax;

    @Basic
    @Column(name = "Cisnienie_max")
    public Double getCisnienieMax() {
        return cisnienieMax;
    }

    public void setCisnienieMax(Double cisnienieMax) {
        this.cisnienieMax = cisnienieMax;
    }

    private Double tempStacjiMin;

    @Basic
    @Column(name = "TempStacji_min")
    public Double getTempStacjiMin() {
        return tempStacjiMin;
    }

    public void setTempStacjiMin(Double tempStacjiMin) {
        this.tempStacjiMin = tempStacjiMin;
    }

    private Double tempStacjiAvg;

    @Basic
    @Column(name = "TempStacji_avg")
    public Double getTempStacjiAvg() {
        return tempStacjiAvg;
    }

    public void setTempStacjiAvg(Double tempStacjiAvg) {
        this.tempStacjiAvg = tempStacjiAvg;
    }

    private Double tempStacjiMax;

    @Basic
    @Column(name = "TempStacji_max")
    public Double getTempStacjiMax() {
        return tempStacjiMax;
    }

    public void setTempStacjiMax(Double tempStacjiMax) {
        this.tempStacjiMax = tempStacjiMax;
    }

    private Double wilgotnoscMin;

    @Basic
    @Column(name = "Wilgotnosc_min")
    public Double getWilgotnoscMin() {
        return wilgotnoscMin;
    }

    public void setWilgotnoscMin(Double wilgotnoscMin) {
        this.wilgotnoscMin = wilgotnoscMin;
    }

    private Double wilgotnoscAvg;

    @Basic
    @Column(name = "Wilgotnosc_avg")
    public Double getWilgotnoscAvg() {
        return wilgotnoscAvg;
    }

    public void setWilgotnoscAvg(Double wilgotnoscAvg) {
        this.wilgotnoscAvg = wilgotnoscAvg;
    }

    private Double wilgotnoscMax;

    @Basic
    @Column(name = "Wilgotnosc_max")
    public Double getWilgotnoscMax() {
        return wilgotnoscMax;
    }

    public void setWilgotnoscMax(Double wilgotnoscMax) {
        this.wilgotnoscMax = wilgotnoscMax;
    }

    private Double opadMin;

    @Basic
    @Column(name = "Opad_min")
    public Double getOpadMin() {
        return opadMin;
    }

    public void setOpadMin(Double opadMin) {
        this.opadMin = opadMin;
    }

    private Double opadAvg;

    @Basic
    @Column(name = "Opad_avg")
    public Double getOpadAvg() {
        return opadAvg;
    }

    public void setOpadAvg(Double opadAvg) {
        this.opadAvg = opadAvg;
    }

    private Double opadMax;

    @Basic
    @Column(name = "Opad_max")
    public Double getOpadMax() {
        return opadMax;
    }

    public void setOpadMax(Double opadMax) {
        this.opadMax = opadMax;
    }

    private Double opadCzasMin;

    @Basic
    @Column(name = "OpadCzas_min")
    public Double getOpadCzasMin() {
        return opadCzasMin;
    }

    public void setOpadCzasMin(Double opadCzasMin) {
        this.opadCzasMin = opadCzasMin;
    }

    private Double opadCzasAvg;

    @Basic
    @Column(name = "OpadCzas_avg")
    public Double getOpadCzasAvg() {
        return opadCzasAvg;
    }

    public void setOpadCzasAvg(Double opadCzasAvg) {
        this.opadCzasAvg = opadCzasAvg;
    }

    private Double opadCzasMax;

    @Basic
    @Column(name = "OpadCzas_max")
    public Double getOpadCzasMax() {
        return opadCzasMax;
    }

    public void setOpadCzasMax(Double opadCzasMax) {
        this.opadCzasMax = opadCzasMax;
    }

    private Double opadIntenMin;

    @Basic
    @Column(name = "OpadInten_min")
    public Double getOpadIntenMin() {
        return opadIntenMin;
    }

    public void setOpadIntenMin(Double opadIntenMin) {
        this.opadIntenMin = opadIntenMin;
    }

    private Double opadIntenAvg;

    @Basic
    @Column(name = "OpadInten_avg")
    public Double getOpadIntenAvg() {
        return opadIntenAvg;
    }

    public void setOpadIntenAvg(Double opadIntenAvg) {
        this.opadIntenAvg = opadIntenAvg;
    }

    private Double opadIntenMax;

    @Basic
    @Column(name = "OpadInten_max")
    public Double getOpadIntenMax() {
        return opadIntenMax;
    }

    public void setOpadIntenMax(Double opadIntenMax) {
        this.opadIntenMax = opadIntenMax;
    }

    private Double maxOpadIntenMin;

    @Basic
    @Column(name = "MaxOpadInten_min")
    public Double getMaxOpadIntenMin() {
        return maxOpadIntenMin;
    }

    public void setMaxOpadIntenMin(Double maxOpadIntenMin) {
        this.maxOpadIntenMin = maxOpadIntenMin;
    }

    private Double maxOpadIntenAvg;

    @Basic
    @Column(name = "MaxOpadInten_avg")
    public Double getMaxOpadIntenAvg() {
        return maxOpadIntenAvg;
    }

    public void setMaxOpadIntenAvg(Double maxOpadIntenAvg) {
        this.maxOpadIntenAvg = maxOpadIntenAvg;
    }

    private Double maxOpadIntenMax;

    @Basic
    @Column(name = "MaxOpadInten_max")
    public Double getMaxOpadIntenMax() {
        return maxOpadIntenMax;
    }

    public void setMaxOpadIntenMax(Double maxOpadIntenMax) {
        this.maxOpadIntenMax = maxOpadIntenMax;
    }

    private Double gradMin;

    @Basic
    @Column(name = "Grad_min")
    public Double getGradMin() {
        return gradMin;
    }

    public void setGradMin(Double gradMin) {
        this.gradMin = gradMin;
    }

    private Double gradAvg;

    @Basic
    @Column(name = "Grad_avg")
    public Double getGradAvg() {
        return gradAvg;
    }

    public void setGradAvg(Double gradAvg) {
        this.gradAvg = gradAvg;
    }

    private Double gradMax;

    @Basic
    @Column(name = "Grad_max")
    public Double getGradMax() {
        return gradMax;
    }

    public void setGradMax(Double gradMax) {
        this.gradMax = gradMax;
    }

    private Double gradCzasMin;

    @Basic
    @Column(name = "GradCzas_min")
    public Double getGradCzasMin() {
        return gradCzasMin;
    }

    public void setGradCzasMin(Double gradCzasMin) {
        this.gradCzasMin = gradCzasMin;
    }

    private Double gradCzasAvg;

    @Basic
    @Column(name = "GradCzas_avg")
    public Double getGradCzasAvg() {
        return gradCzasAvg;
    }

    public void setGradCzasAvg(Double gradCzasAvg) {
        this.gradCzasAvg = gradCzasAvg;
    }

    private Double gradCzasMax;

    @Basic
    @Column(name = "GradCzas_max")
    public Double getGradCzasMax() {
        return gradCzasMax;
    }

    public void setGradCzasMax(Double gradCzasMax) {
        this.gradCzasMax = gradCzasMax;
    }

    private Double gradIntenMin;

    @Basic
    @Column(name = "GradInten_min")
    public Double getGradIntenMin() {
        return gradIntenMin;
    }

    public void setGradIntenMin(Double gradIntenMin) {
        this.gradIntenMin = gradIntenMin;
    }

    private Double gradIntenAvg;

    @Basic
    @Column(name = "GradInten_avg")
    public Double getGradIntenAvg() {
        return gradIntenAvg;
    }

    public void setGradIntenAvg(Double gradIntenAvg) {
        this.gradIntenAvg = gradIntenAvg;
    }

    private Double gradIntenMax;

    @Basic
    @Column(name = "GradInten_max")
    public Double getGradIntenMax() {
        return gradIntenMax;
    }

    public void setGradIntenMax(Double gradIntenMax) {
        this.gradIntenMax = gradIntenMax;
    }

    private Double maxGradIntenMin;

    @Basic
    @Column(name = "MaxGradInten_min")
    public Double getMaxGradIntenMin() {
        return maxGradIntenMin;
    }

    public void setMaxGradIntenMin(Double maxGradIntenMin) {
        this.maxGradIntenMin = maxGradIntenMin;
    }

    private Double maxGradIntenAvg;

    @Basic
    @Column(name = "MaxGradInten_avg")
    public Double getMaxGradIntenAvg() {
        return maxGradIntenAvg;
    }

    public void setMaxGradIntenAvg(Double maxGradIntenAvg) {
        this.maxGradIntenAvg = maxGradIntenAvg;
    }

    private Double maxGradIntenMax;

    @Basic
    @Column(name = "MaxGradInten_max")
    public Double getMaxGradIntenMax() {
        return maxGradIntenMax;
    }

    public void setMaxGradIntenMax(Double maxGradIntenMax) {
        this.maxGradIntenMax = maxGradIntenMax;
    }

    private Double heatingTempMin;

    @Basic
    @Column(name = "HeatingTemp_min")
    public Double getHeatingTempMin() {
        return heatingTempMin;
    }

    public void setHeatingTempMin(Double heatingTempMin) {
        this.heatingTempMin = heatingTempMin;
    }

    private Double heatingTempAvg;

    @Basic
    @Column(name = "HeatingTemp_avg")
    public Double getHeatingTempAvg() {
        return heatingTempAvg;
    }

    public void setHeatingTempAvg(Double heatingTempAvg) {
        this.heatingTempAvg = heatingTempAvg;
    }

    private Double heatingTempMax;

    @Basic
    @Column(name = "HeatingTemp_max")
    public Double getHeatingTempMax() {
        return heatingTempMax;
    }

    public void setHeatingTempMax(Double heatingTempMax) {
        this.heatingTempMax = heatingTempMax;
    }

    private Double heatingVoltMin;

    @Basic
    @Column(name = "HeatingVolt_min")
    public Double getHeatingVoltMin() {
        return heatingVoltMin;
    }

    public void setHeatingVoltMin(Double heatingVoltMin) {
        this.heatingVoltMin = heatingVoltMin;
    }

    private Double heatingVoltAvg;

    @Basic
    @Column(name = "HeatingVolt_avg")
    public Double getHeatingVoltAvg() {
        return heatingVoltAvg;
    }

    public void setHeatingVoltAvg(Double heatingVoltAvg) {
        this.heatingVoltAvg = heatingVoltAvg;
    }

    private Double heatingVoltMax;

    @Basic
    @Column(name = "HeatingVolt_max")
    public Double getHeatingVoltMax() {
        return heatingVoltMax;
    }

    public void setHeatingVoltMax(Double heatingVoltMax) {
        this.heatingVoltMax = heatingVoltMax;
    }

    private Double supplyVoltMin;

    @Basic
    @Column(name = "SupplyVolt_min")
    public Double getSupplyVoltMin() {
        return supplyVoltMin;
    }

    public void setSupplyVoltMin(Double supplyVoltMin) {
        this.supplyVoltMin = supplyVoltMin;
    }

    private Double supplyVoltAvg;

    @Basic
    @Column(name = "SupplyVolt_avg")
    public Double getSupplyVoltAvg() {
        return supplyVoltAvg;
    }

    public void setSupplyVoltAvg(Double supplyVoltAvg) {
        this.supplyVoltAvg = supplyVoltAvg;
    }

    private Double supplyVoltMax;

    @Basic
    @Column(name = "SupplyVolt_max")
    public Double getSupplyVoltMax() {
        return supplyVoltMax;
    }

    public void setSupplyVoltMax(Double supplyVoltMax) {
        this.supplyVoltMax = supplyVoltMax;
    }

    private Double refVoltMin;

    @Basic
    @Column(name = "RefVolt_min")
    public Double getRefVoltMin() {
        return refVoltMin;
    }

    public void setRefVoltMin(Double refVoltMin) {
        this.refVoltMin = refVoltMin;
    }

    private Double refVoltAvg;

    @Basic
    @Column(name = "RefVolt_avg")
    public Double getRefVoltAvg() {
        return refVoltAvg;
    }

    public void setRefVoltAvg(Double refVoltAvg) {
        this.refVoltAvg = refVoltAvg;
    }

    private Double refVoltMax;

    @Basic
    @Column(name = "RefVolt_max")
    public Double getRefVoltMax() {
        return refVoltMax;
    }

    public void setRefVoltMax(Double refVoltMax) {
        this.refVoltMax = refVoltMax;
    }

    private Double tempPktRosyMin;

    @Basic
    @Column(name = "TempPktRosy_min")
    public Double getTempPktRosyMin() {
        return tempPktRosyMin;
    }

    public void setTempPktRosyMin(Double tempPktRosyMin) {
        this.tempPktRosyMin = tempPktRosyMin;
    }

    private Double tempPktRosyAvg;

    @Basic
    @Column(name = "TempPktRosy_avg")
    public Double getTempPktRosyAvg() {
        return tempPktRosyAvg;
    }

    public void setTempPktRosyAvg(Double tempPktRosyAvg) {
        this.tempPktRosyAvg = tempPktRosyAvg;
    }

    private Double tempPktRosyMax;

    @Basic
    @Column(name = "TempPktRosy_max")
    public Double getTempPktRosyMax() {
        return tempPktRosyMax;
    }

    public void setTempPktRosyMax(Double tempPktRosyMax) {
        this.tempPktRosyMax = tempPktRosyMax;
    }

    private Double cisBaromMin;

    @Basic
    @Column(name = "CisBarom_min")
    public Double getCisBaromMin() {
        return cisBaromMin;
    }

    public void setCisBaromMin(Double cisBaromMin) {
        this.cisBaromMin = cisBaromMin;
    }

    private Double cisBaromAvg;

    @Basic
    @Column(name = "CisBarom_avg")
    public Double getCisBaromAvg() {
        return cisBaromAvg;
    }

    public void setCisBaromAvg(Double cisBaromAvg) {
        this.cisBaromAvg = cisBaromAvg;
    }

    private Double cisBaromMax;

    @Basic
    @Column(name = "CisBarom_max")
    public Double getCisBaromMax() {
        return cisBaromMax;
    }

    public void setCisBaromMax(Double cisBaromMax) {
        this.cisBaromMax = cisBaromMax;
    }

    private Double windchillTempMin;

    @Basic
    @Column(name = "WindchillTemp_min")
    public Double getWindchillTempMin() {
        return windchillTempMin;
    }

    public void setWindchillTempMin(Double windchillTempMin) {
        this.windchillTempMin = windchillTempMin;
    }

    private Double windchillTempAvg;

    @Basic
    @Column(name = "WindchillTemp_avg")
    public Double getWindchillTempAvg() {
        return windchillTempAvg;
    }

    public void setWindchillTempAvg(Double windchillTempAvg) {
        this.windchillTempAvg = windchillTempAvg;
    }

    private Double windchillTempMax;

    @Basic
    @Column(name = "WindchillTemp_max")
    public Double getWindchillTempMax() {
        return windchillTempMax;
    }

    public void setWindchillTempMax(Double windchillTempMax) {
        this.windchillTempMax = windchillTempMax;
    }

    private Double heatindexTempMin;

    @Basic
    @Column(name = "HeatindexTemp_min")
    public Double getHeatindexTempMin() {
        return heatindexTempMin;
    }

    public void setHeatindexTempMin(Double heatindexTempMin) {
        this.heatindexTempMin = heatindexTempMin;
    }

    private Double heatindexTempAvg;

    @Basic
    @Column(name = "HeatindexTemp_avg")
    public Double getHeatindexTempAvg() {
        return heatindexTempAvg;
    }

    public void setHeatindexTempAvg(Double heatindexTempAvg) {
        this.heatindexTempAvg = heatindexTempAvg;
    }

    private Double heatindexTempMax;

    @Basic
    @Column(name = "HeatindexTemp_max")
    public Double getHeatindexTempMax() {
        return heatindexTempMax;
    }

    public void setHeatindexTempMax(Double heatindexTempMax) {
        this.heatindexTempMax = heatindexTempMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PogodaEntity that = (PogodaEntity) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (godzina != null ? !godzina.equals(that.godzina) : that.godzina != null) return false;
        if (minPredkoscWiatruMin != null ? !minPredkoscWiatruMin.equals(that.minPredkoscWiatruMin) : that.minPredkoscWiatruMin != null)
            return false;
        if (minPredkoscWiatruAvg != null ? !minPredkoscWiatruAvg.equals(that.minPredkoscWiatruAvg) : that.minPredkoscWiatruAvg != null)
            return false;
        if (minPredkoscWiatruMax != null ? !minPredkoscWiatruMax.equals(that.minPredkoscWiatruMax) : that.minPredkoscWiatruMax != null)
            return false;
        if (avgPredkoscWiatruMin != null ? !avgPredkoscWiatruMin.equals(that.avgPredkoscWiatruMin) : that.avgPredkoscWiatruMin != null)
            return false;
        if (avgPredkoscWiatruAvg != null ? !avgPredkoscWiatruAvg.equals(that.avgPredkoscWiatruAvg) : that.avgPredkoscWiatruAvg != null)
            return false;
        if (avgPredkoscWiatruMax != null ? !avgPredkoscWiatruMax.equals(that.avgPredkoscWiatruMax) : that.avgPredkoscWiatruMax != null)
            return false;
        if (maxPredkoscWiatruMin != null ? !maxPredkoscWiatruMin.equals(that.maxPredkoscWiatruMin) : that.maxPredkoscWiatruMin != null)
            return false;
        if (maxPredkoscWiatruAvg != null ? !maxPredkoscWiatruAvg.equals(that.maxPredkoscWiatruAvg) : that.maxPredkoscWiatruAvg != null)
            return false;
        if (maxPredkoscWiatruMax != null ? !maxPredkoscWiatruMax.equals(that.maxPredkoscWiatruMax) : that.maxPredkoscWiatruMax != null)
            return false;
        if (minKierunekWiatruMin != null ? !minKierunekWiatruMin.equals(that.minKierunekWiatruMin) : that.minKierunekWiatruMin != null)
            return false;
        if (minKierunekWiatruAvg != null ? !minKierunekWiatruAvg.equals(that.minKierunekWiatruAvg) : that.minKierunekWiatruAvg != null)
            return false;
        if (minKierunekWiatruMax != null ? !minKierunekWiatruMax.equals(that.minKierunekWiatruMax) : that.minKierunekWiatruMax != null)
            return false;
        if (avgKierunekWiatruMin != null ? !avgKierunekWiatruMin.equals(that.avgKierunekWiatruMin) : that.avgKierunekWiatruMin != null)
            return false;
        if (avgKierunekWiatruAvg != null ? !avgKierunekWiatruAvg.equals(that.avgKierunekWiatruAvg) : that.avgKierunekWiatruAvg != null)
            return false;
        if (avgKierunekWiatruMax != null ? !avgKierunekWiatruMax.equals(that.avgKierunekWiatruMax) : that.avgKierunekWiatruMax != null)
            return false;
        if (maxKierunekWiatruMin != null ? !maxKierunekWiatruMin.equals(that.maxKierunekWiatruMin) : that.maxKierunekWiatruMin != null)
            return false;
        if (maxKierunekWiatruAvg != null ? !maxKierunekWiatruAvg.equals(that.maxKierunekWiatruAvg) : that.maxKierunekWiatruAvg != null)
            return false;
        if (maxKierunekWiatruMax != null ? !maxKierunekWiatruMax.equals(that.maxKierunekWiatruMax) : that.maxKierunekWiatruMax != null)
            return false;
        if (tempPowietrzaMin != null ? !tempPowietrzaMin.equals(that.tempPowietrzaMin) : that.tempPowietrzaMin != null)
            return false;
        if (tempPowietrzaAvg != null ? !tempPowietrzaAvg.equals(that.tempPowietrzaAvg) : that.tempPowietrzaAvg != null)
            return false;
        if (tempPowietrzaMax != null ? !tempPowietrzaMax.equals(that.tempPowietrzaMax) : that.tempPowietrzaMax != null)
            return false;
        if (cisnienieMin != null ? !cisnienieMin.equals(that.cisnienieMin) : that.cisnienieMin != null) return false;
        if (cisnienieAvg != null ? !cisnienieAvg.equals(that.cisnienieAvg) : that.cisnienieAvg != null) return false;
        if (cisnienieMax != null ? !cisnienieMax.equals(that.cisnienieMax) : that.cisnienieMax != null) return false;
        if (tempStacjiMin != null ? !tempStacjiMin.equals(that.tempStacjiMin) : that.tempStacjiMin != null)
            return false;
        if (tempStacjiAvg != null ? !tempStacjiAvg.equals(that.tempStacjiAvg) : that.tempStacjiAvg != null)
            return false;
        if (tempStacjiMax != null ? !tempStacjiMax.equals(that.tempStacjiMax) : that.tempStacjiMax != null)
            return false;
        if (wilgotnoscMin != null ? !wilgotnoscMin.equals(that.wilgotnoscMin) : that.wilgotnoscMin != null)
            return false;
        if (wilgotnoscAvg != null ? !wilgotnoscAvg.equals(that.wilgotnoscAvg) : that.wilgotnoscAvg != null)
            return false;
        if (wilgotnoscMax != null ? !wilgotnoscMax.equals(that.wilgotnoscMax) : that.wilgotnoscMax != null)
            return false;
        if (opadMin != null ? !opadMin.equals(that.opadMin) : that.opadMin != null) return false;
        if (opadAvg != null ? !opadAvg.equals(that.opadAvg) : that.opadAvg != null) return false;
        if (opadMax != null ? !opadMax.equals(that.opadMax) : that.opadMax != null) return false;
        if (opadCzasMin != null ? !opadCzasMin.equals(that.opadCzasMin) : that.opadCzasMin != null) return false;
        if (opadCzasAvg != null ? !opadCzasAvg.equals(that.opadCzasAvg) : that.opadCzasAvg != null) return false;
        if (opadCzasMax != null ? !opadCzasMax.equals(that.opadCzasMax) : that.opadCzasMax != null) return false;
        if (opadIntenMin != null ? !opadIntenMin.equals(that.opadIntenMin) : that.opadIntenMin != null) return false;
        if (opadIntenAvg != null ? !opadIntenAvg.equals(that.opadIntenAvg) : that.opadIntenAvg != null) return false;
        if (opadIntenMax != null ? !opadIntenMax.equals(that.opadIntenMax) : that.opadIntenMax != null) return false;
        if (maxOpadIntenMin != null ? !maxOpadIntenMin.equals(that.maxOpadIntenMin) : that.maxOpadIntenMin != null)
            return false;
        if (maxOpadIntenAvg != null ? !maxOpadIntenAvg.equals(that.maxOpadIntenAvg) : that.maxOpadIntenAvg != null)
            return false;
        if (maxOpadIntenMax != null ? !maxOpadIntenMax.equals(that.maxOpadIntenMax) : that.maxOpadIntenMax != null)
            return false;
        if (gradMin != null ? !gradMin.equals(that.gradMin) : that.gradMin != null) return false;
        if (gradAvg != null ? !gradAvg.equals(that.gradAvg) : that.gradAvg != null) return false;
        if (gradMax != null ? !gradMax.equals(that.gradMax) : that.gradMax != null) return false;
        if (gradCzasMin != null ? !gradCzasMin.equals(that.gradCzasMin) : that.gradCzasMin != null) return false;
        if (gradCzasAvg != null ? !gradCzasAvg.equals(that.gradCzasAvg) : that.gradCzasAvg != null) return false;
        if (gradCzasMax != null ? !gradCzasMax.equals(that.gradCzasMax) : that.gradCzasMax != null) return false;
        if (gradIntenMin != null ? !gradIntenMin.equals(that.gradIntenMin) : that.gradIntenMin != null) return false;
        if (gradIntenAvg != null ? !gradIntenAvg.equals(that.gradIntenAvg) : that.gradIntenAvg != null) return false;
        if (gradIntenMax != null ? !gradIntenMax.equals(that.gradIntenMax) : that.gradIntenMax != null) return false;
        if (maxGradIntenMin != null ? !maxGradIntenMin.equals(that.maxGradIntenMin) : that.maxGradIntenMin != null)
            return false;
        if (maxGradIntenAvg != null ? !maxGradIntenAvg.equals(that.maxGradIntenAvg) : that.maxGradIntenAvg != null)
            return false;
        if (maxGradIntenMax != null ? !maxGradIntenMax.equals(that.maxGradIntenMax) : that.maxGradIntenMax != null)
            return false;
        if (heatingTempMin != null ? !heatingTempMin.equals(that.heatingTempMin) : that.heatingTempMin != null)
            return false;
        if (heatingTempAvg != null ? !heatingTempAvg.equals(that.heatingTempAvg) : that.heatingTempAvg != null)
            return false;
        if (heatingTempMax != null ? !heatingTempMax.equals(that.heatingTempMax) : that.heatingTempMax != null)
            return false;
        if (heatingVoltMin != null ? !heatingVoltMin.equals(that.heatingVoltMin) : that.heatingVoltMin != null)
            return false;
        if (heatingVoltAvg != null ? !heatingVoltAvg.equals(that.heatingVoltAvg) : that.heatingVoltAvg != null)
            return false;
        if (heatingVoltMax != null ? !heatingVoltMax.equals(that.heatingVoltMax) : that.heatingVoltMax != null)
            return false;
        if (supplyVoltMin != null ? !supplyVoltMin.equals(that.supplyVoltMin) : that.supplyVoltMin != null)
            return false;
        if (supplyVoltAvg != null ? !supplyVoltAvg.equals(that.supplyVoltAvg) : that.supplyVoltAvg != null)
            return false;
        if (supplyVoltMax != null ? !supplyVoltMax.equals(that.supplyVoltMax) : that.supplyVoltMax != null)
            return false;
        if (refVoltMin != null ? !refVoltMin.equals(that.refVoltMin) : that.refVoltMin != null) return false;
        if (refVoltAvg != null ? !refVoltAvg.equals(that.refVoltAvg) : that.refVoltAvg != null) return false;
        if (refVoltMax != null ? !refVoltMax.equals(that.refVoltMax) : that.refVoltMax != null) return false;
        if (tempPktRosyMin != null ? !tempPktRosyMin.equals(that.tempPktRosyMin) : that.tempPktRosyMin != null)
            return false;
        if (tempPktRosyAvg != null ? !tempPktRosyAvg.equals(that.tempPktRosyAvg) : that.tempPktRosyAvg != null)
            return false;
        if (tempPktRosyMax != null ? !tempPktRosyMax.equals(that.tempPktRosyMax) : that.tempPktRosyMax != null)
            return false;
        if (cisBaromMin != null ? !cisBaromMin.equals(that.cisBaromMin) : that.cisBaromMin != null) return false;
        if (cisBaromAvg != null ? !cisBaromAvg.equals(that.cisBaromAvg) : that.cisBaromAvg != null) return false;
        if (cisBaromMax != null ? !cisBaromMax.equals(that.cisBaromMax) : that.cisBaromMax != null) return false;
        if (windchillTempMin != null ? !windchillTempMin.equals(that.windchillTempMin) : that.windchillTempMin != null)
            return false;
        if (windchillTempAvg != null ? !windchillTempAvg.equals(that.windchillTempAvg) : that.windchillTempAvg != null)
            return false;
        if (windchillTempMax != null ? !windchillTempMax.equals(that.windchillTempMax) : that.windchillTempMax != null)
            return false;
        if (heatindexTempMin != null ? !heatindexTempMin.equals(that.heatindexTempMin) : that.heatindexTempMin != null)
            return false;
        if (heatindexTempAvg != null ? !heatindexTempAvg.equals(that.heatindexTempAvg) : that.heatindexTempAvg != null)
            return false;
        if (heatindexTempMax != null ? !heatindexTempMax.equals(that.heatindexTempMax) : that.heatindexTempMax != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (godzina != null ? godzina.hashCode() : 0);
        result = 31 * result + (minPredkoscWiatruMin != null ? minPredkoscWiatruMin.hashCode() : 0);
        result = 31 * result + (minPredkoscWiatruAvg != null ? minPredkoscWiatruAvg.hashCode() : 0);
        result = 31 * result + (minPredkoscWiatruMax != null ? minPredkoscWiatruMax.hashCode() : 0);
        result = 31 * result + (avgPredkoscWiatruMin != null ? avgPredkoscWiatruMin.hashCode() : 0);
        result = 31 * result + (avgPredkoscWiatruAvg != null ? avgPredkoscWiatruAvg.hashCode() : 0);
        result = 31 * result + (avgPredkoscWiatruMax != null ? avgPredkoscWiatruMax.hashCode() : 0);
        result = 31 * result + (maxPredkoscWiatruMin != null ? maxPredkoscWiatruMin.hashCode() : 0);
        result = 31 * result + (maxPredkoscWiatruAvg != null ? maxPredkoscWiatruAvg.hashCode() : 0);
        result = 31 * result + (maxPredkoscWiatruMax != null ? maxPredkoscWiatruMax.hashCode() : 0);
        result = 31 * result + (minKierunekWiatruMin != null ? minKierunekWiatruMin.hashCode() : 0);
        result = 31 * result + (minKierunekWiatruAvg != null ? minKierunekWiatruAvg.hashCode() : 0);
        result = 31 * result + (minKierunekWiatruMax != null ? minKierunekWiatruMax.hashCode() : 0);
        result = 31 * result + (avgKierunekWiatruMin != null ? avgKierunekWiatruMin.hashCode() : 0);
        result = 31 * result + (avgKierunekWiatruAvg != null ? avgKierunekWiatruAvg.hashCode() : 0);
        result = 31 * result + (avgKierunekWiatruMax != null ? avgKierunekWiatruMax.hashCode() : 0);
        result = 31 * result + (maxKierunekWiatruMin != null ? maxKierunekWiatruMin.hashCode() : 0);
        result = 31 * result + (maxKierunekWiatruAvg != null ? maxKierunekWiatruAvg.hashCode() : 0);
        result = 31 * result + (maxKierunekWiatruMax != null ? maxKierunekWiatruMax.hashCode() : 0);
        result = 31 * result + (tempPowietrzaMin != null ? tempPowietrzaMin.hashCode() : 0);
        result = 31 * result + (tempPowietrzaAvg != null ? tempPowietrzaAvg.hashCode() : 0);
        result = 31 * result + (tempPowietrzaMax != null ? tempPowietrzaMax.hashCode() : 0);
        result = 31 * result + (cisnienieMin != null ? cisnienieMin.hashCode() : 0);
        result = 31 * result + (cisnienieAvg != null ? cisnienieAvg.hashCode() : 0);
        result = 31 * result + (cisnienieMax != null ? cisnienieMax.hashCode() : 0);
        result = 31 * result + (tempStacjiMin != null ? tempStacjiMin.hashCode() : 0);
        result = 31 * result + (tempStacjiAvg != null ? tempStacjiAvg.hashCode() : 0);
        result = 31 * result + (tempStacjiMax != null ? tempStacjiMax.hashCode() : 0);
        result = 31 * result + (wilgotnoscMin != null ? wilgotnoscMin.hashCode() : 0);
        result = 31 * result + (wilgotnoscAvg != null ? wilgotnoscAvg.hashCode() : 0);
        result = 31 * result + (wilgotnoscMax != null ? wilgotnoscMax.hashCode() : 0);
        result = 31 * result + (opadMin != null ? opadMin.hashCode() : 0);
        result = 31 * result + (opadAvg != null ? opadAvg.hashCode() : 0);
        result = 31 * result + (opadMax != null ? opadMax.hashCode() : 0);
        result = 31 * result + (opadCzasMin != null ? opadCzasMin.hashCode() : 0);
        result = 31 * result + (opadCzasAvg != null ? opadCzasAvg.hashCode() : 0);
        result = 31 * result + (opadCzasMax != null ? opadCzasMax.hashCode() : 0);
        result = 31 * result + (opadIntenMin != null ? opadIntenMin.hashCode() : 0);
        result = 31 * result + (opadIntenAvg != null ? opadIntenAvg.hashCode() : 0);
        result = 31 * result + (opadIntenMax != null ? opadIntenMax.hashCode() : 0);
        result = 31 * result + (maxOpadIntenMin != null ? maxOpadIntenMin.hashCode() : 0);
        result = 31 * result + (maxOpadIntenAvg != null ? maxOpadIntenAvg.hashCode() : 0);
        result = 31 * result + (maxOpadIntenMax != null ? maxOpadIntenMax.hashCode() : 0);
        result = 31 * result + (gradMin != null ? gradMin.hashCode() : 0);
        result = 31 * result + (gradAvg != null ? gradAvg.hashCode() : 0);
        result = 31 * result + (gradMax != null ? gradMax.hashCode() : 0);
        result = 31 * result + (gradCzasMin != null ? gradCzasMin.hashCode() : 0);
        result = 31 * result + (gradCzasAvg != null ? gradCzasAvg.hashCode() : 0);
        result = 31 * result + (gradCzasMax != null ? gradCzasMax.hashCode() : 0);
        result = 31 * result + (gradIntenMin != null ? gradIntenMin.hashCode() : 0);
        result = 31 * result + (gradIntenAvg != null ? gradIntenAvg.hashCode() : 0);
        result = 31 * result + (gradIntenMax != null ? gradIntenMax.hashCode() : 0);
        result = 31 * result + (maxGradIntenMin != null ? maxGradIntenMin.hashCode() : 0);
        result = 31 * result + (maxGradIntenAvg != null ? maxGradIntenAvg.hashCode() : 0);
        result = 31 * result + (maxGradIntenMax != null ? maxGradIntenMax.hashCode() : 0);
        result = 31 * result + (heatingTempMin != null ? heatingTempMin.hashCode() : 0);
        result = 31 * result + (heatingTempAvg != null ? heatingTempAvg.hashCode() : 0);
        result = 31 * result + (heatingTempMax != null ? heatingTempMax.hashCode() : 0);
        result = 31 * result + (heatingVoltMin != null ? heatingVoltMin.hashCode() : 0);
        result = 31 * result + (heatingVoltAvg != null ? heatingVoltAvg.hashCode() : 0);
        result = 31 * result + (heatingVoltMax != null ? heatingVoltMax.hashCode() : 0);
        result = 31 * result + (supplyVoltMin != null ? supplyVoltMin.hashCode() : 0);
        result = 31 * result + (supplyVoltAvg != null ? supplyVoltAvg.hashCode() : 0);
        result = 31 * result + (supplyVoltMax != null ? supplyVoltMax.hashCode() : 0);
        result = 31 * result + (refVoltMin != null ? refVoltMin.hashCode() : 0);
        result = 31 * result + (refVoltAvg != null ? refVoltAvg.hashCode() : 0);
        result = 31 * result + (refVoltMax != null ? refVoltMax.hashCode() : 0);
        result = 31 * result + (tempPktRosyMin != null ? tempPktRosyMin.hashCode() : 0);
        result = 31 * result + (tempPktRosyAvg != null ? tempPktRosyAvg.hashCode() : 0);
        result = 31 * result + (tempPktRosyMax != null ? tempPktRosyMax.hashCode() : 0);
        result = 31 * result + (cisBaromMin != null ? cisBaromMin.hashCode() : 0);
        result = 31 * result + (cisBaromAvg != null ? cisBaromAvg.hashCode() : 0);
        result = 31 * result + (cisBaromMax != null ? cisBaromMax.hashCode() : 0);
        result = 31 * result + (windchillTempMin != null ? windchillTempMin.hashCode() : 0);
        result = 31 * result + (windchillTempAvg != null ? windchillTempAvg.hashCode() : 0);
        result = 31 * result + (windchillTempMax != null ? windchillTempMax.hashCode() : 0);
        result = 31 * result + (heatindexTempMin != null ? heatindexTempMin.hashCode() : 0);
        result = 31 * result + (heatindexTempAvg != null ? heatindexTempAvg.hashCode() : 0);
        result = 31 * result + (heatindexTempMax != null ? heatindexTempMax.hashCode() : 0);
        return result;
    }
}
