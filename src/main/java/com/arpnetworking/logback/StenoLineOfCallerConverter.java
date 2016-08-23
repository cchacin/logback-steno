/**
 * Copyright 2016 Ville Koskela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arpnetworking.logback;

import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Steno specific caller line converter.
 *
 * @author Ville Koskela (ville dot koskela at inscopemetrics dot com)
 * @since 1.14.0
 */
public class StenoLineOfCallerConverter extends AbstractStenoCallerConverter {

    /**
     * {@inheritDoc}
     */
    @Override
    public String convert(final ILoggingEvent loggingEvent) {
        final StackTraceElement callerData = getCallerData(loggingEvent);
        if (callerData != null) {
            return Integer.toString(callerData.getLineNumber());
        }
        return CallerData.NA;
    }
}