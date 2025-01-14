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
//     mmacivor - Initial implementation
package org.eclipse.persistence.testing.jaxb.annotations.cdata;

import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XmlCDATATestCases extends JAXBWithJSONTestCases {

    private static final String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlcdata/employee.xml";
    private static final String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/annotations/xmlcdata/employee.json";
    public XmlCDATATestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[] {Employee.class});
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
    }

    @Override
    public Object getControlObject() {
        Employee emp = new Employee();
        emp.name = "Jane Doe";
        emp.xmlData = "<root><child>A string wrapped in cdata</child></root>";
        emp.nestedCData = "<![CDATA[nested]]>";
        emp.anotherCData1 = "here ]> > ]] ] is no replacement";
        emp.anotherCData2 = "here ]]]>> is one replacement only";
        emp.anotherCData3 = "]]>]]>]]>";

        return emp;
    }

    @Override
    public void testObjectToContentHandler() {
        //CDATA sections don't work with content handlers
    }
}
