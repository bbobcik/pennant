/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package cz.auderis.pennant;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for methods that return the value of a feature toggle.
 * The annotated method must have no arguments and must return a
 * {@code boolean} value.
 * <p>
 * The return value of the annotated method should represent the desired
 * default state of the feature toggle.
 *
 * @author Boleslav Bobcik ({@code bbobcik@gmail.com})
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@PennantInstrumentation
public @interface FeatureToggle {

    /**
     * Name that identifies the feature toggle. The name must be unique.
     *
     * @return unique identifier
     */
    String name();

    /**
     * Description of the feature toggle, that should explain its purpose.
     * This value may be used for automatic generation of feature documentation.
     *
     * @return optional description
     */
    String description() default "";

    /**
     * Determines whether this feature flag can be changed via management interface
     * during runtime. This is useful for feature flags that are accessed
     * only once, typically during application startup (e.g. to select an appropriate
     * Spring bean).
     *
     * @return {@code true} if the flag can be changed during runtime (default); {@code false} otherwise
     */
    boolean allowRuntimeChange() default true;

}
