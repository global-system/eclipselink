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
// rbarkhouse - May 26 2008 - 1.0M8 - Initial implementation

package org.eclipse.persistence.testing.sdo.helper.xmlhelper.datatype;

import java.util.Date;

import org.eclipse.persistence.sdo.SDOConstants;
import org.eclipse.persistence.sdo.SDOType;

import junit.textui.TestRunner;

public class SDOXMLHelperDatatypeDateTestCases extends SDOXMLHelperDatatypeTestCase {

    public SDOXMLHelperDatatypeDateTestCases(String name) {
        super(name);
    }

    public static void main(String[] args) {
        String[] arguments = { "-c", "org.eclipse.persistence.testing.sdo.helper.xmlhelper.datatype.SDOXMLHelperDatatypeDateTestCases" };
        TestRunner.main(arguments);
    }

    @Override
    protected Class getDatatypeJavaClass() {
        return String.class;
    }

    @Override
    protected SDOType getValueType() {
        return SDOConstants.SDO_DATE;
    }

    @Override
    protected String getControlFileName() {
        return ("./org/eclipse/persistence/testing/sdo/helper/xmlhelper/datatype/myDate-1.xml");
    }

    @Override
    protected String getControlRootURI() {
        return "myDate-NS";
    }

    @Override
    protected String getControlRootName() {
        return "myDate";
    }

    @Override
    protected String getSchemaNameForUserDefinedType() {
        return getSchemaLocation() + "myDate.xsd";
    }

    @Override
    protected String getSchemaNameForBuiltinType() {
        return getSchemaLocation() + "myDate-builtin.xsd";
    }

}
