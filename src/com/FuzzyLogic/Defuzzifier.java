package com.FuzzyLogic;

public class Defuzzifier {
    private double[] fuzzy_set;
    private double output_value;
    String crisp_output;

    private static final int LOW = 0;
    private static final int NORMAL = 1;
    private static final int HIGH = 2;

    private static final int LOW_CENTROID = (0 + 25 + 50) / 3;
    private static final int NORMAL_CENTROID = (25 + 50 + 75) / 3;
    private static final int HIGH_CENTROID = (50 + 100 + 100) / 3;

    public void addFuzzySet(double[] fuzzy_risk_output) {
        this.fuzzy_set = fuzzy_risk_output;
    }

    private double calculateWeightedMean(){
        double output;

        output = this.fuzzy_set[LOW] * LOW_CENTROID;
        output += this.fuzzy_set[NORMAL] * NORMAL_CENTROID;
        output += this.fuzzy_set[HIGH] * HIGH_CENTROID;
        output /= (this.fuzzy_set[LOW] + this.fuzzy_set[NORMAL] + this.fuzzy_set[HIGH]);

        return output;
    }

    private int getMaxValueIndex(){
        int max_index = 0;

        for(int i = 0; i < this.fuzzy_set.length; i++) {
            if(this.fuzzy_set[i] > this.fuzzy_set[max_index])
                max_index = i;
        }

        return max_index;
    }

    private String getCrispRisk() {
        int max_risk_index = getMaxValueIndex();

        if (max_risk_index == LOW) return "Low";
        else if (max_risk_index == NORMAL) return "Normal";
        else if (max_risk_index == HIGH) return "High";
        else return "UNKNOWN";
    }

    public void defuzzify() {
        this.output_value = calculateWeightedMean();
        this.crisp_output = getCrispRisk();

    }

    public double getDefuzzifiedValue() {
        return this.output_value;
    }

    public String getDefuzzifiedCrisp() {
        return this.crisp_output;
    }
}
