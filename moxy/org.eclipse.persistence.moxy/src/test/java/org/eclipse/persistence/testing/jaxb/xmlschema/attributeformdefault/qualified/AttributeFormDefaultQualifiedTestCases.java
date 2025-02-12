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
// Denise Smith - 2.3
package org.eclipse.persistence.testing.jaxb.xmlschema.attributeformdefault.qualified;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class AttributeFormDefaultQualifiedTestCases extends JAXBWithJSONTestCases{
    protected final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlschema/attributeformdefault/qualifiedaddress.xml";
    protected final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlschema/attributeformdefault/qualifiedaddress.json";

    public AttributeFormDefaultQualifiedTestCases(String name) throws Exception {
        super(name);
    }

    @Override
    public void setUp() throws Exception {
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);

        super.setUp();
        Type[] types = new Type[1];
        types[0] = Address.class;
        setTypes(types);

        Map namespaces = new HashMap<String, String>();
        namespaces.put("myns","ns0");
        jaxbMarshaller.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER, namespaces);
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_NAMESPACE_PREFIX_MAPPER, namespaces);
    }

    @Override
    protected Object getControlObject() {
        Address addr = new Address();
        addr.city = "Ottawa";
        addr.street ="Main Street";
        return addr;
    }

    public void testSchemaGen() throws Exception{
        InputStream controlInputStream = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/xmlschema/attributeformdefault/qualified.xsd");
        List<InputStream> controlSchemas = new ArrayList<InputStream>();
        controlSchemas.add(controlInputStream);
        this.testSchemaGen(controlSchemas);
    }

}
