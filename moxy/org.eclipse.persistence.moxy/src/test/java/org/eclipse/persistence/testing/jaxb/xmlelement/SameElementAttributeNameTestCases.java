/*
 * Copyright (c) 2018, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Radek Felcman - 2.7.2 - initial implementation
package org.eclipse.persistence.testing.jaxb.xmlelement;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

import java.util.ArrayList;

public class SameElementAttributeNameTestCases extends JAXBWithJSONTestCases {

    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlelement/same_element_attribute_name_nonamespace.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmlelement/same_element_attribute_name_nonamespace.json";


    public SameElementAttributeNameTestCases(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        Class[] classes = new Class<?>[]{EmployeeSameElementAttributeName.class};
        setClasses(classes);
        jaxbMarshaller.setProperty(MarshallerProperties.JSON_ATTRIBUTE_PREFIX, "@");
        jaxbUnmarshaller.setProperty(UnmarshallerProperties.JSON_ATTRIBUTE_PREFIX, "@");
    }

    @Override
    protected Object getControlObject() {

        EmployeeSameElementAttributeName.EmployeeName employeeName = new EmployeeSameElementAttributeName.EmployeeName();
        employeeName.firstName = "John";
        employeeName.lastName = "Smith";

        ArrayList<EmployeeSameElementAttributeName.EmployeeName> employeeNames = new ArrayList<>();
        employeeNames.add(employeeName);

        EmployeeSameElementAttributeName employee = new EmployeeSameElementAttributeName();
        employee.name = "john.smith";
        employee.names = employeeNames;

        return employee;
    }

}
