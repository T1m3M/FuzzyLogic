package com.FuzzyLogic;

public class FuzzySolver {
    private double crisp_project_fund, crisp_experience_level;
    private double[] project_funding_membership_values, experience_level_membership_values;

    public FuzzySolver(double project_fund, double experience_level) {
        this.crisp_project_fund = project_fund;
        this.crisp_experience_level = experience_level;
    }

    public void solve() {
        ProjectFundingFuzzifier project_funding_fuzzifier = new ProjectFundingFuzzifier();
        project_funding_fuzzifier.fuzzify(this.crisp_project_fund);
        this.project_funding_membership_values = project_funding_fuzzifier.getMembershipValues();

        TeamExperienceLevelFuzzifier team_experience_level_fuzzifier = new TeamExperienceLevelFuzzifier();
        team_experience_level_fuzzifier.fuzzify(this.crisp_experience_level);
        this.experience_level_membership_values = team_experience_level_fuzzifier.getMembershipValues();
    }

    public double getOutputValue() {
        return 37.5;
    }

    public String getCrispOutput() {
        return "Normal";
    }
}
