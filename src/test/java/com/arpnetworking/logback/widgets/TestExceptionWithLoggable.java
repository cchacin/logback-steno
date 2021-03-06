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
package com.arpnetworking.logback.widgets;

import com.arpnetworking.logback.annotations.Loggable;

/**
 * Class to test exception serialization.
 *
 * @author Ville Koskela (ville dot koskela at inscopemetrics dot com)
 */
@Loggable
public class TestExceptionWithLoggable extends Exception {

    /**
     * Public constructor.
     *
     * @param value The value.
     */
    public TestExceptionWithLoggable(final String value) {
        super("TestExceptionWithLoggable");
        _value = value;
    }

    public String getValue() {
        return _value;
    }

    private final String _value;

    private static final long serialVersionUID = -4481322241812676130L;
}
