/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

/**
 * Auderis Pennant is an advanced feature flag library for Java. Its primary
 * goals are:
 * <ul>
 * <li>offer an easy-to-use API that prevents introduction of a cluttered, unmaintainable code;</li>
 * <li>allow management of individual feature flags during runtime;</li>
 * <li>proactively guard against increase of a technical debt;</li>
 * <li>provide self-documenting tools;</li>
 * <li>simplify workload in a testing phase.</li>
 * </ul>
 *
 * <p>This package addresses the first goal, i.e. the API. It consists of
 * several Java annotations that are used to declare feature flag-related
 * methods in the production code. By themselves, these annotation do not
 * provide any functionality, they serve as markers. By including Pennant
 * runtime library and adding instrumentation steps to the build process,
 * the annotated methods will be replaced by a code that reflects the current
 * feature flag settings.
 *
 * <h2>Types of annotated methods</h2>
 *
 * <h3>Simple flag value</h3>
 * <p>A method annotated with {@link cz.auderis.pennant.FeatureToggle} is
 * the easiest way to access a feature flag value. Such a method must have
 * no parameters and return a boolean value. It may have any name, any access
 * modifier and can be static or non-static. During runtime, when instrumented,
 * it returns the current value of the feature flag, based on flag ID declared
 * in the annotation.
 *
 * <p>Example:
 * <pre>
 * {@code @}FeatureToggle(name="feature1")
 * private boolean isFeature1Enabled() {
 *   return false; // Conservative approach to keep the original code as default
 * }
 * </pre>
 *
 * <h3>Alternative method implementation</h3>
 * Extensive use of simple boolean toggle results in a proliferation of
 * {@code if-else} statements, which may be difficult to refactor when the
 * feature flag is removed. To avoid this, Pennant offers an alternative approach
 * where a whole method is cloned and all changes pertaining to the feature are
 * applied to the clone. Both methods are then annotated with
 * {@link cz.auderis.pennant.FeatureMethod} annotation, sharing the name property
 * and differing in the {@code flagValue} property.
 *
 * <p>Example:
 * <pre>
 * {@code @}FeatureMethod(name="feature1", flagValue=false)
 * Set&lt;String&gt; filterValidNames(Set&lt;String&gt; names) {
 *   // ... original implementation ...
 * }
 *
 * {@code @}FeatureMethod(name="feature1", flagValue=true)
 * Set&lt;String&gt; filterValidNamesNew(Set&lt;String&gt; names) {
 *   // ... new implementation ...
 * }
 *
 * </pre>
 *
 *
 * @author Boleslav Bobcik ({@code bbobcik@gmail.com})
 */
package cz.auderis.pennant;