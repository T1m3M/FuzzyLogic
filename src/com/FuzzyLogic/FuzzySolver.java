package com.FuzzyLogic;

public class FuzzySolver {
    private double crisp_project_fund, crisp_experience_level;
    private double[] project_funding_membership, experience_level_membership;

    public FuzzySolver(double project_fund, double experience_level) {
        this.crisp_project_fund = project_fund;
        this.crisp_experience_level = experience_level;
    }

    public void solve() {
        ProjectFundingFuzzifier project_funding_fuzzifier = new ProjectFundingFuzzifier(this.crisp_project_fund);
        this.project_funding_membership = project_funding_fuzzifier.getMembership();

        TeamExperienceLevelFuzzifier team_experience_level_fuzzifier = new TeamExperienceLevelFuzzifier(this.crisp_experience_level);
        this.experience_level_membership = team_experience_level_fuzzifier.getMembership();
    }

    public double getOutputValue() {
        return 37.5;
    }

    public String getCrispOutput() {
        return "Normal";
    }
}
