package com.FuzzyLogic;

import java.util.Arrays;

public class FuzzySolver {
    private double crisp_project_fund, crisp_experience_level;
    private double[] project_funding_membership_values, experience_level_membership_values, fuzzy_risk_output;
    private double output_value;
    private String crisp_output;

    public FuzzySolver(double project_fund, double experience_level) {
        this.crisp_project_fund = project_fund;
        this.crisp_experience_level = experience_level;
    }

    public void solve() {

        // fuzzifying input crisp values
        ProjectFundingFuzzifier project_funding_fuzzifier = new ProjectFundingFuzzifier();
        project_funding_fuzzifier.fuzzify(this.crisp_project_fund);
        this.project_funding_membership_values = project_funding_fuzzifier.getMembershipValues();

        TeamExperienceLevelFuzzifier team_experience_level_fuzzifier = new TeamExperienceLevelFuzzifier();
        team_experience_level_fuzzifier.fuzzify(this.crisp_experience_level);
        this.experience_level_membership_values = team_experience_level_fuzzifier.getMembershipValues();

        // Bahaa part: evaluation of rules (from membership values to 3 values of risks)
        RulesEvaluator rules_evaluator = new RulesEvaluator();
        rules_evaluator.addFuzzyInputs(this.project_funding_membership_values, this.experience_level_membership_values);
        rules_evaluator.evaluate();
        this.fuzzy_risk_output = rules_evaluator.getFuzzyOutput();


        // Tawaty part: Defuzzification (from 3 values of risks to risk value and crisp output)
    }

    public double getOutputValue() {
        return this.output_value; // e.g. 37.5
    }

    public String getCrispOutput() {
        return this.crisp_output; // e.g. "Normal"
    }
}
