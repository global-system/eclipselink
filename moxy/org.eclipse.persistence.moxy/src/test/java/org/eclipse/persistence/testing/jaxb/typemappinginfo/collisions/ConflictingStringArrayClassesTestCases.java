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
//     Denise Smith -  January, 2010 - 2.0.1
package org.eclipse.persistence.testing.jaxb.typemappinginfo.collisions;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.eclipse.persistence.jaxb.TypeMappingInfo;
import org.eclipse.persistence.jaxb.TypeMappingInfo.ElementScope;
import org.eclipse.persistence.testing.jaxb.typemappinginfo.TypeMappingInfoTestCases;
import org.eclipse.persistence.testing.jaxb.typemappinginfo.TypeMappingInfoWithJSONTestCases;

public class ConflictingStringArrayClassesTestCases extends TypeMappingInfoWithJSONTestCases{
    protected final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/typemappinginfo/collisions/conflictingStringArrayClasses.xml";
    protected final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/typemappinginfo/collisions/conflictingStringArrayClasses.json";

    public String[] testField;

    public ConflictingStringArrayClassesTestCases(String name) throws Exception {
        super(name);
        init();
    }

    public void init() throws Exception {
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        setTypeMappingInfos(getTypeMappingInfos());
    }

    protected TypeMappingInfo[] getTypeMappingInfos()throws Exception {
        if(typeMappingInfos == null) {
            typeMappingInfos = new TypeMappingInfo[3];

            TypeMappingInfo tmi = new TypeMappingInfo();
            tmi.setXmlTagName(new QName("http://jaxb.dev.java.net/array","testTagName1"));
            tmi.setElementScope(ElementScope.Global);
            tmi.setType(String[].class);
            typeMappingInfos[0] = tmi;

            TypeMappingInfo tmi2 = new TypeMappingInfo();
            tmi2.setXmlTagName(new QName("http://jaxb.dev.java.net/array","testTagName2"));
            tmi2.setElementScope(ElementScope.Global);
            tmi2.setType(String[].class);
            typeMappingInfos[1] = tmi2;

            TypeMappingInfo tmi3 = new TypeMappingInfo();
            tmi3.setXmlTagName(new QName("http://jaxb.dev.java.net/array","testTagName3"));
            tmi3.setElementScope(ElementScope.Global);
            tmi3.setType(getClass().getField("testField").getGenericType());
            typeMappingInfos[2] = tmi3;
        }
        return typeMappingInfos;
    }


    @Override
    protected Object getControlObject() {

        String[] testStrings = new String[]{"theString", "theString2", "theString3"};

        QName qname = new QName("http://jaxb.dev.java.net/array", "testTagName");
        JAXBElement jaxbElement = new JAXBElement(qname, String[].class, null);

        jaxbElement.setValue(testStrings);

        return jaxbElement;
    }

    @Override
    public Map<String, InputStream> getControlSchemaFiles(){
        InputStream instream = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/typemappinginfo/collisions/conflictingStringArrayClasses.xsd");

        Map<String, InputStream> controlSchema = new HashMap<String, InputStream>();
        controlSchema.put("http://jaxb.dev.java.net/array", instream);
        return controlSchema;
    }

    protected String getNoXsiTypeControlResourceName() {
        return XML_RESOURCE;
    }

    public void testDescriptorsSize(){
        List descriptors = ((org.eclipse.persistence.jaxb.JAXBContext)jaxbContext).getXMLContext().getSession(0).getProject().getOrderedDescriptors();
        assertEquals(1, descriptors.size());
    }
}
