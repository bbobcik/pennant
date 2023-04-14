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
 * Annotates methods that, based on {@code flagValue}, implement either
 * legacy function or a new feature. For each feature name, there must be
 * exactly two methods with identical signature, the one with legacy code
 * annotated with {@code flagValue=false} and its counterpart that implements
 * the new version annotated with {@code flagValue=true}.
 * <p>
 * It is a programming error if one of the methods calls the other one, as
 * an infinite loop will result. If a common code block is needed, it should
 * be extracted into a separate method and called from both methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@PennantInstrumentation
public @interface FeatureMethod {

    /**
     * Name that identifies the feature toggle. A name must appear exactly
     * twice in the codebase, once with {@code flagValue=false} and once
     * with {@code flagValue=true}.
     *
     * @return feature identifier
     */
    String name();

    /**
     * Determines whether the annotated method implements the legacy code
     * ({@code false}) or the new feature ({@code true}).
     *
     * @return {@code true} for new feature, {@code false} for legacy code
     */
    boolean flagValue();

    /**
     * Description of the feature toggle, that should explain its purpose.
     * <p>
     * If the description is defined only in a single method annotation
     * (preferably the one with {@code flagValue=true}), it will be used as-is.
     * This value may be used for automatic generation of feature documentation.
     * <p>
     * If both methods' annotation contain a description, the description is
     * unified into a common text with two paragraphs, one for the legacy code
     * ({@code flagValue=false}) and one for the new feature, in this order.
     *
     * @return optional description
     */
    String description() default "";

}