package cz.auderis.pennant.junit.fixture;

import cz.auderis.pennant.FeatureToggle;

public class FeatureToggleExample {

    public static final String FEATURE_NAME = "uppercase";

    public static final String ORIG_RESULT = "tokyo";
    public static final String NEW_RESULT = "TOKYO";

    public String getName() {
        final String result;
        if (isUppercaseTransformation()) {
            result = NEW_RESULT;
        } else {
            result = ORIG_RESULT;
        }
        return result;
    }

    @FeatureToggle(name = FEATURE_NAME)
    boolean isUppercaseTransformation() {
        return false;
    }

}
