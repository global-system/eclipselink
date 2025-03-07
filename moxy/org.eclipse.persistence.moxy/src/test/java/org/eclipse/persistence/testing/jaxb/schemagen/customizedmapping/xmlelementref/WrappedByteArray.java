/*
 * Copyright (c) 1998, 2024 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
// mmacivor - June 09/2009 - 1.0 - Initial implementation
package org.eclipse.persistence.testing.jaxb.schemagen.customizedmapping.xmlelementref;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inByteArray"
})
@XmlRootElement(name = "ByteWrapper")
public class WrappedByteArray {

    @XmlElementRef(name = "inByteArray", type = JAXBElement.class)
    protected JAXBElement<byte[]> inByteArray;

    /**
     * Gets the value of the inByteArray property.
     *
     * @return
     *     possible object is
     *     {@code JAXBElement<byte[]>}
     *
     */
    public JAXBElement<byte[]> getInByteArray() {
        return inByteArray;
    }

    /**
     * Sets the value of the inByteArray property.
     *
     * @param value
     *     allowed object is
     *     {@code JAXBElement<byte[]>}
     *
     */
    public void setInByteArray(JAXBElement<byte[]> value) {
        this.inByteArray = value;
    }

}

