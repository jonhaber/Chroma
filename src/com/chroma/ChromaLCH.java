package com.chroma;

public class ChromaLCH extends ChromaColor {

    private double lch_L;
    private double lch_C;
    private double lch_H;

    public ChromaLCH(double lch_L_, double lch_C_, double lch_H_, double alpha_) {

        this.lch_L = lch_L_;
        this.lch_C = lch_C_;
        this.lch_H = lch_H_;
        this.alpha = alpha_;
    }

    public double[] getLCHComp() {
        return new double[] {lch_L, lch_C, lch_H};
    }

    // CONVERSION METHODS
    /////////////////////////////////////////////////////////////////////////////////////

    public ChromaRGB getChromaRGB() { return getChromaLAB().getChromaRGB();}

    public ChromaHSL getChromaHSL() { return getChromaLAB().getChromaHSL();}

    public ChromaHSV getChromaHSV() { return getChromaLAB().getChromaHSV();}

    public ChromaLAB getChromaLAB() {

        double lch_H_ = this.lch_H * Math.PI / 180;
        return new ChromaLAB(this.lch_L, Math.cos(lch_H_) * this.lch_C, Math.sin(lch_H_) * this.lch_C, this.alpha);
    }

    public ChromaLCH getChromaLCH() { return this;}

}

