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

import java.math.BigDecimal;

import org.eclipse.persistence.sdo.SDOConstants;
import org.eclipse.persistence.sdo.SDOType;

import junit.textui.TestRunner;

public class SDOXMLHelperDatatypeDecimalTestCases extends SDOXMLHelperDatatypeTestCase {

    public SDOXMLHelperDatatypeDecimalTestCases(String name) {
        super(name);
    }

    public static void main(String[] args) {
        String[] arguments = { "-c", "org.eclipse.persistence.testing.sdo.helper.xmlhelper.datatype.SDOXMLHelperDatatypeDecimalTestCases" };
        TestRunner.main(arguments);
    }

    @Override
    protected Class getDatatypeJavaClass() {
        return BigDecimal.class;
    }

    @Override
    protected SDOType getValueType() {
        return SDOConstants.SDO_DECIMAL;
    }

    @Override
    protected String getControlFileName() {
        return ("./org/eclipse/persistence/testing/sdo/helper/xmlhelper/datatype/myDecimal-1.xml");
    }

    @Override
    protected String getControlRootURI() {
        return "myDecimal-NS";
    }

    @Override
    protected String getControlRootName() {
        return "myDecimal";
    }

    @Override
    protected String getSchemaNameForUserDefinedType() {
        return getSchemaLocation() + "myDecimal.xsd";
    }

    @Override
    protected String getSchemaNameForBuiltinType() {
        return getSchemaLocation() + "myDecimal-builtin.xsd";
    }

}
