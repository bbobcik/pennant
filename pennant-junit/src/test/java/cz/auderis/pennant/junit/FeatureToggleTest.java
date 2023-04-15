package cz.auderis.pennant.junit;

import cz.auderis.pennant.junit.fixture.FeatureToggleExample;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.Matchers.is;

@ExtendWith(PennantExtension.class)
public class FeatureToggleTest {

    @Test
    void shouldX() {
        // Given
        FeatureToggleExample example = new FeatureToggleExample();

        // When
        final String name = example.getName();

        // Then
        MatcherAssert.assertThat(name, is(FeatureToggleExample.ORIG_RESULT));
    }

    @Disabled
    @Test
    @EnableFeatureFlag(FeatureToggleExample.FEATURE_NAME)
    void shouldY() {
        // Given
        FeatureToggleExample example = new FeatureToggleExample();

        // When
        final String name = example.getName();

        // Then
        MatcherAssert.assertThat(name, is(FeatureToggleExample.NEW_RESULT));
    }

}
