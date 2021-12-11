package com.FuzzyLogic;

public class FuzzySolver {
    double crisp_project_fund, crisp_experience_level;

    public FuzzySolver(double project_fund, double experience_level) {
        this.crisp_project_fund = project_fund;
        this.crisp_experience_level = experience_level;
    }

    public void solve() {
    }

    public double getOutputValue() {
        return 37.5;
    }

    public String getCrispOutput() {
        return "Normal";
    }
}
