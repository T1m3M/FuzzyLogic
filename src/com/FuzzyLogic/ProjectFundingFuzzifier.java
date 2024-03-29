package com.FuzzyLogic;

public class ProjectFundingFuzzifier {
    private double[] membership_values = {0, 0, 0, 0};

    private double veryLowFuzzifier(double crisp_project_fund) {
        if (crisp_project_fund >= 0 && crisp_project_fund <= 10)
            return 1;

        else if (crisp_project_fund >= 10 && crisp_project_fund <= 30)
            return (-1.0/20) * crisp_project_fund + (3.0/2);

        return 0;
    }

    private double lowFuzzifier(double crisp_project_fund) {
        if (crisp_project_fund >= 10 && crisp_project_fund <= 30)
            return (1.0/20) * crisp_project_fund - (1.0/2);

        else if (crisp_project_fund >= 30 && crisp_project_fund <= 40)
            return 1;

        else if (crisp_project_fund >= 40 && crisp_project_fund <= 60)
            return (-1.0/20) * crisp_project_fund + 3;

        return 0;
    }

    private double mediumFuzzifier(double crisp_project_fund) {
        if (crisp_project_fund >= 40 && crisp_project_fund <= 60)
            return (1.0/20) * crisp_project_fund - 2;

        else if (crisp_project_fund >= 60 && crisp_project_fund <= 70)
            return 1;

        else if (crisp_project_fund >= 70 && crisp_project_fund <= 90)
            return (-1.0/20) * crisp_project_fund + (9.0/2);

        return 0;
    }

    private double highFuzzifier(double crisp_project_fund) {
        if (crisp_project_fund >= 70 && crisp_project_fund <= 90)
            return (1.0/20) * crisp_project_fund - (7.0/2);

        else if (crisp_project_fund >= 90 && crisp_project_fund <= 100)
            return 1;

        return 0;
    }

    public void fuzzify(double crisp_project_fund) {
        this.membership_values[0] = veryLowFuzzifier(crisp_project_fund);
        this.membership_values[1] = lowFuzzifier(crisp_project_fund);
        this.membership_values[2] = mediumFuzzifier(crisp_project_fund);
        this.membership_values[3] = highFuzzifier(crisp_project_fund);
    }

    public double[] getMembershipValues() { return this.membership_values; }
}
