package com.FuzzyLogic;

public class TeamExperienceLevelFuzzifier {
    private double crisp_experience_level;

    public TeamExperienceLevelFuzzifier(double crisp_experience_level) {
        this.crisp_experience_level = crisp_experience_level;
    }

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

    public double[] getMembership() {
        double[] membership = {0, 0, 0};

        membership[0] = beginnerFuzzifier(this.crisp_experience_level);
        membership[1] = intermediateFuzzifier(this.crisp_experience_level);
        membership[2] = expertFuzzifier(this.crisp_experience_level);

        return membership;

    }
}
