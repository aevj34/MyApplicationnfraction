package com.example.myapplication.model;

import java.util.List;

public class Plate {

        private String soatStart;
        private String soatEnd;
        private String soatState;
        private String citvStart;
        private String citvEnd;
        private String citvState;
        private List<PreventiveMeasure> preventiveMeasures;
        private List<Infraction> infractions;

    public String getSoatStart() {
        return soatStart;
    }

    public void setSoatStart(String soatStart) {
        this.soatStart = soatStart;
    }

    public String getSoatEnd() {
        return soatEnd;
    }

    public void setSoatEnd(String soatEnd) {
        this.soatEnd = soatEnd;
    }

    public String getSoatState() {
        return soatState;
    }

    public void setSoatState(String soatState) {
        this.soatState = soatState;
    }

    public String getCitvStart() {
        return citvStart;
    }

    public void setCitvStart(String citvStart) {
        this.citvStart = citvStart;
    }

    public String getCitvEnd() {
        return citvEnd;
    }

    public void setCitvEnd(String citvEnd) {
        this.citvEnd = citvEnd;
    }

    public String getCitvState() {
        return citvState;
    }

    public void setCitvState(String citvState) {
        this.citvState = citvState;
    }

    public List<PreventiveMeasure> getPreventiveMeasures() {
        return preventiveMeasures;
    }

    public void setPreventiveMeasures(List<PreventiveMeasure> preventiveMeasures) {
        this.preventiveMeasures = preventiveMeasures;
    }

    public List<Infraction> getInfractions() {
        return infractions;
    }

    public void setInfractions(List<Infraction> infractions) {
        this.infractions = infractions;
    }
}
