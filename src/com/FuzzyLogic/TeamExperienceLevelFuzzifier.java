package com.FuzzyLogic;

public class TeamExperienceLevelFuzzifier {
    private double[] membership_values = {0, 0, 0};

    private double beginnerFuzzifier(double crisp_experience_level) {
        if (crisp_experience_level >= 0 && crisp_experience_level <= 15)
            return (1.0/15) * crisp_experience_level;

        else if (crisp_experience_level >= 15 && crisp_experience_level <= 30)
            return (-1.0/15) * crisp_experience_level + 2;

        return 0;
    }

    private double intermediateFuzzifier(double crisp_experience_level) {
        if (crisp_experience_level >= 15 && crisp_experience_level <= 30)
            return (1.0/15) * crisp_experience_level - 1;

        else if (crisp_experience_level >= 30 && crisp_experience_level <= 45)
            return (-1.0/15) * crisp_experience_level + 3;

        return 0;
    }

    private double expertFuzzifier(double crisp_experience_level) {
        if (crisp_experience_level >= 30 && crisp_experience_level <= 60)
            return (1.0/30) * crisp_experience_level - 1;

        return 0;
    }

    public void fuzzify(double crisp_experience_level) {
        this.membership_values[0] = beginnerFuzzifier(crisp_experience_level);
        this.membership_values[1] = intermediateFuzzifier(crisp_experience_level);
        this.membership_values[2] = expertFuzzifier(crisp_experience_level);
    }

    public double[] getMembershipValues() {
        return this.membership_values;
    }
}
