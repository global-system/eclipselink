/*
 * Copyright (c) 2011, 2021 Oracle and/or its affiliates. All rights reserved.
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
// Denise Smith - 2.4
package org.eclipse.persistence.testing.jaxb.externalizedmetadata.xmlelements;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XMLElementsWithWrapperTestCases extends JAXBWithJSONTestCases{

    private static final String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/externalizedmetadata/xmlelements/foo-wrapper.xml";
    private static final String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/externalizedmetadata/xmlelements/foo-wrapper.json";

    public XMLElementsWithWrapperTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[] { Foo.class });
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
    }

    @Override
    public Map getProperties() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/externalizedmetadata/xmlelements/eclipselink-oxm-wrapper.xml");

        HashMap<String, Source> metadataSourceMap = new HashMap<String, Source>();
        metadataSourceMap.put("org.eclipse.persistence.testing.jaxb.externalizedmetadata.xmlelements",
                        new StreamSource(inputStream));
        Map<String, Map<String, Source>> properties = new HashMap<String, Map<String, Source>>();
        properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY,
                metadataSourceMap);

        return properties;
    }

    public void testSchemaGen() throws Exception {
        List controlSchemas = new ArrayList();
        InputStream is = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/externalizedmetadata/xmlelements/schema_wrapper.xsd");
        controlSchemas.add(is);
        super.testSchemaGen(controlSchemas);

    }

    public void testInstanceDocValidation() {
        InputStream schema = ClassLoader
                .getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/externalizedmetadata/xmlelements/schema_wrapper.xsd");
        StreamSource schemaSource = new StreamSource(schema);

        InputStream instanceDocStream = ClassLoader
                .getSystemResourceAsStream(XML_RESOURCE);
        String result = validateAgainstSchema(instanceDocStream, schemaSource);
        assertTrue("Instance doc validation (employee.xml) failed unxepectedly: "+ result, result == null);
    }

    @Override
    protected Object getControlObject() {
        // setup control objects
        Foo foo = new Foo();
        List theItems = new ArrayList();
        theItems.add(2.5f);
        theItems.add(1);
        foo.items = theItems;
        return foo;
    }

}
