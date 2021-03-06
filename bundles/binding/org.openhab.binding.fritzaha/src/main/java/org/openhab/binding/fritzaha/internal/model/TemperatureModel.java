/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.fritzaha.internal.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * See {@link DevicelistModel}.
 *
 * @author Robert Bausdorf
 * @since 1.6
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name = "temperature")
@XmlType(propOrder = { "celsius", "offset" })
public class TemperatureModel {
    private BigDecimal celsius;
    private BigDecimal offset;

    public BigDecimal getCelsius() {
        return celsius;
    }

    public void setCelsius(BigDecimal celsius) {
        this.celsius = celsius;
    }

    public BigDecimal getOffset() {
        return offset;
    }

    public void setOffset(BigDecimal offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("temperature");
        out.append("[celsius=").append(this.getCelsius()).append(',');
        out.append("offset=").append(this.getOffset()).append(']');
        return out.toString();
    }
}
