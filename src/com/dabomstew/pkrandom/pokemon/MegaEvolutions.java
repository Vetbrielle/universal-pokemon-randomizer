package com.dabomstew.pkrandom.pokemon;

public class MegaEvolutions {
    private Pokemon originalBaseForm;
    private int evolution1;
    private int evolution2;
    public MegaEvolutions(int evolution1, int evolution2) {this.evolution1=evolution1;this.evolution2=evolution2;}
    public void setEvolution1 (int e1) {
        this.evolution1 = e1;
    }
    public int getEvolution1 () {
        return this.evolution1;
    }
    public void setEvolution2 (int e2) {
        this.evolution2 = e2;
    }
    public int getEvolution2 () {
        return this.evolution2;
    }
    public void setOriginalBaseForm (Pokemon pk) {
        this.originalBaseForm = pk;
    }
    public Pokemon getOriginalBaseForm () {
        return this.originalBaseForm;
    }
}
