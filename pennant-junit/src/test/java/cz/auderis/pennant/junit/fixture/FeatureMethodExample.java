package cz.auderis.pennant.junit.fixture;

import cz.auderis.pennant.FeatureMethod;

public class FeatureMethodExample {

    public static final String FEATURE_NAME = "townName";
    public static final String ORIG_RESULT = "Himeji";
    public static final String NEW_RESULT = "Onomichi";


    public String getTownName() {
        return getNameInternal();
    }

    @FeatureMethod(name = FEATURE_NAME, flagValue = false)
    private String getNameInternal() {
        return ORIG_RESULT;
    }

    @FeatureMethod(name = FEATURE_NAME, flagValue = true)
    private String getNameInternalNew() {
        return NEW_RESULT;
    }

}
