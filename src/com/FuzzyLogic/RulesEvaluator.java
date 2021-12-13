package com.FuzzyLogic;

public class RulesEvaluator {
    private double[] project_funding, team_experience_level, risk_fuzzy_output = {0, 0, 0};

    private static final int VERY_LOW = 0;
    private static final int LOW = 1;
    private static final int MEDIUM = 2;
    private static final int HIGH = 3;

    private static final int BEGINNER = 0;
    private static final int INTERMEDIATE = 1;
    private static final int EXPERT = 2;

    public void addFuzzyInputs(double[] project_funding_membership_values, double[] experience_level_membership_values) {
        this.project_funding = project_funding_membership_values;
        this.team_experience_level = experience_level_membership_values;
    }

    private double union(double input_1, double input_2){
        return Math.max(input_1, input_2);
    }

    private double intersection(double input_1, double input_2){
        return Math.min(input_1, input_2);
    }

    public void evaluate() {
        this.risk_fuzzy_output[0] = union(this.project_funding[HIGH], this.team_experience_level[EXPERT]);
        this.risk_fuzzy_output[1] = intersection(this.project_funding[MEDIUM], union(this.team_experience_level[INTERMEDIATE], this.team_experience_level[BEGINNER]));
        this.risk_fuzzy_output[2] = union(this.project_funding[VERY_LOW], intersection(this.project_funding[LOW], this.team_experience_level[BEGINNER]));
    }

    public double[] getFuzzyOutput() {
        return this.risk_fuzzy_output;
    }
}
