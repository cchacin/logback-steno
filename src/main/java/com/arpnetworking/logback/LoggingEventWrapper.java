/**
 * Copyright 2014 Groupon.com
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

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;
import ch.qos.logback.classic.spi.LoggingEvent;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

import java.util.Arrays;
import java.util.Map;

/**
 * Logback LoggingEvent wrapper for overriding the message and argumentArray.
 *
 * @author Gil Markham (gil at groupon dot com)
 * @since 1.0.0
 */
public class LoggingEventWrapper extends LoggingEvent {

    /**
     * Public constructor.
     *
     * @param event Instance of <code>ILoggingEvent</code>.
     * @param message The message.
     * @param argumentArray The array of arguments for the message.
     */
    public LoggingEventWrapper(final ILoggingEvent event, final String message, final Object[] argumentArray) {
        _wrappedEvent = event;
        _message = message;
        _argumentArray = argumentArray == null ? null : Arrays.copyOf(argumentArray, argumentArray.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getThreadName() {
        return _wrappedEvent.getThreadName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Level getLevel() {
        return _wrappedEvent.getLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return _message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] getArgumentArray() {
        return _argumentArray == null ? null : Arrays.copyOf(_argumentArray, _argumentArray.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLoggerName() {
        return _wrappedEvent.getLoggerName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LoggerContextVO getLoggerContextVO() {
        return _wrappedEvent.getLoggerContextVO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IThrowableProxy getThrowableProxy() {
        return _wrappedEvent.getThrowableProxy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StackTraceElement[] getCallerData() {
        return _wrappedEvent.getCallerData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasCallerData() {
        return _wrappedEvent.hasCallerData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Marker getMarker() {
        return _wrappedEvent.getMarker();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> getMDCPropertyMap() {
        return _wrappedEvent.getMDCPropertyMap();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("deprecation")
    public Map<String, String> getMdc() {
        return _wrappedEvent.getMdc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getTimeStamp() {
        return _wrappedEvent.getTimeStamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void prepareForDeferredProcessing() {
        _wrappedEvent.prepareForDeferredProcessing();
    }

    /**
     * Return the the message formatted with arguments. Implemented as suggested in:
     *
     * http://jira.qos.ch/browse/LBCLASSIC-47
     *
     * @return The formatted message.
     */
    public String getFormattedMessage() {
        if (_formattedMessage != null) {
            return _formattedMessage;
        }
        if (_argumentArray != null) {
            _formattedMessage = MessageFormatter.arrayFormat(_message, _argumentArray).getMessage();
        } else {
            _formattedMessage = _message;
        }

        return _formattedMessage;
    }

    private final ILoggingEvent _wrappedEvent;
    private final String _message;
    private final Object[] _argumentArray;
    private transient String _formattedMessage;
}
