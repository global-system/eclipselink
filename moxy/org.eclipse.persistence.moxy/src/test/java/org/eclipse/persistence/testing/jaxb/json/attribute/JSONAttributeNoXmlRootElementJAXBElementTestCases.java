/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Denise Smith - 2.4 - April 2012
package org.eclipse.persistence.testing.jaxb.json.attribute;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class JSONAttributeNoXmlRootElementJAXBElementTestCases extends JAXBWithJSONTestCases {

    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/json/attribute/address_no_root.json";
    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/json/attribute/address_no_root.xml";

    public JSONAttributeNoXmlRootElementJAXBElementTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[]{AddressNoRoot.class});
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
    }

    @Override
    public Class getUnmarshalClass(){
        return AddressNoRoot.class;
    }

    @Override
    public Object getReadControlObject() {
        JAXBElement jbe = new JAXBElement<AddressNoRoot>(new QName("street"), AddressNoRoot.class, new AddressNoRoot());
        return jbe;
    }


    @Override
    protected Object getJSONReadControlObject() {
        JAXBElement jbe = new JAXBElement<AddressNoRoot>(new QName(""), AddressNoRoot.class, getAddress());
        return jbe;
    }

    @Override
    protected Object getControlObject() {
        JAXBElement jbe = new JAXBElement<AddressNoRoot>(new QName(""), AddressNoRoot.class, getAddress());
        return jbe;


    }

    private AddressNoRoot getAddress(){
        AddressNoRoot add = new AddressNoRoot();
        add.setId(10);
        add.setCity("Ottawa");
        add.setStreet("Main street");

        return add;
    }

      @Override
      public void testRoundTrip() throws Exception {}
      @Override
      public void testUnmarshallerHandler() throws Exception {}
}
