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
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.oxm.mappings.directtofield.typeattribute;

import org.eclipse.persistence.testing.oxm.mappings.XMLMappingTestCases;

public class TypeAttributeFloatTestCases extends XMLMappingTestCases {
    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/oxm/mappings/directtofield/typeattribute/TypeAttributeFloat.xml";
    private final static Float CONTROL_ID = 123.0f;
    private final static String CONTROL_FIRST_NAME = "Jane";
    private final static String CONTROL_LAST_NAME = "Doe";

    public TypeAttributeFloatTestCases(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setProject(new TypeAttributeProject());
    }

    @Override
    protected Object getControlObject() {
        Employee employee = new Employee();
        employee.setIdentifier(CONTROL_ID);
        employee.setFirstName(CONTROL_FIRST_NAME);
        employee.setLastName(CONTROL_LAST_NAME);
        return employee;
    }
}
