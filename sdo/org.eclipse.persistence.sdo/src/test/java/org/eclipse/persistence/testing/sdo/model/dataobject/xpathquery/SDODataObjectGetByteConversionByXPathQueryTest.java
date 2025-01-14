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
package org.eclipse.persistence.testing.sdo.model.dataobject.xpathquery;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.eclipse.persistence.sdo.SDOConstants;
import org.eclipse.persistence.sdo.SDODataObject;
import org.eclipse.persistence.sdo.SDOProperty;
import org.eclipse.persistence.sdo.SDOType;

public class SDODataObjectGetByteConversionByXPathQueryTest extends SDODataObjectGetByXPathQueryTestCases {
    public SDODataObjectGetByteConversionByXPathQueryTest(String name) {
        super(name);
    }

    public void testGetByteConversionWithPathFromDefinedBooleanPropertyEqualSignBracketInPathDotSet() {
        SDOProperty prop = dataObject_c0.getType().getProperty("test");
        prop.setType(SDOConstants.SDO_BYTE);

        byte bb = 12;

        //List b = new ArrayList();
        //dataObject_c.set(property_c, b);// c dataobject's a property has value boolean 'true'
        dataObject_a.setByte(propertyTest + "test", bb);

        assertEquals(bb, dataObject_a.getByte(propertyTest + "test"));
    }

    // purpose: opencontent properties
    public void testGetByteConversionFromDefinedPropertyWithPath() {
        SDOProperty property_c1_object = dataObject_c1.getInstanceProperty("PName-c1");
        property_c1_object.setType(SDOConstants.SDO_BYTE);

        //type_c0.addDeclaredProperty(property_c1_object);
        List objects = new ArrayList();
        byte by = 12;
        byte by1 = 1;
        Byte b = by;
        Byte bb = by1;
        objects.add(b);
        objects.add(bb);

        type_c0.setOpen(true);

        dataObject_c1.set(property_c1_object, objects);// add it to instance list

        assertEquals(bb.byteValue(), dataObject_a.getByte("PName-a0/PName-b0[number='1']/PName-c1.1"));
    }

    //2. purpose: getDataObject with property value is not dataobject
    public void testGetDataObjectConversionFromUndefinedProperty() {
        SDOType dataObjectType = (SDOType) typeHelper.getType(SDOConstants.SDO_URL, SDOConstants.DATAOBJECT);

        property_c = new SDOProperty(aHelperContext);
        property_c.setName(PROPERTY_NAME_C);
        property_c.setType(dataObjectType);
        type_c.addDeclaredProperty(property_c);
        dataObject_c._setType(type_c);

        SDODataObject C = new SDODataObject();

        dataObject_c.set(property_c, C);

        try {
            dataObject_a.getByte(property1);
        } catch (Exception e) {
            fail("No Exception expected, but caught " + e.getClass());
        }
    }

    //3. purpose: getDataObject with property set to boolean value
    public void testGetDataObjectConversionFromProperty() {
        //try {
        assertNull(dataObject_a.getDataObject("PName-a/notExistedTest"));

        //fail("IllegalArgumentException should be thrown.");
        //} catch (IllegalArgumentException e) {
        //}
    }

    //purpose: getDataObject with nul value
    public void testGetDataObjectConversionWithNullArgument() {
        String p = null;
        assertNull(dataObject_a.getDataObject(p));
    }

    public void testSetGetDataObjectWithQueryPath() {
        SDOProperty property_c1_object = new SDOProperty(aHelperContext);
        property_c1_object.setName("PName-c1");
        property_c1_object.setContainment(true);
        property_c1_object.setMany(true);
        property_c1_object.setType(SDOConstants.SDO_BYTE);

        type_c0.addDeclaredProperty(property_c1_object);

        byte by = 12;
        Byte b = by;

        dataObject_a.set("PName-a0/PName-b0[number='1']/PName-c1.0", b);

        assertEquals(b.byteValue(), dataObject_a.getByte("PName-a0/PName-b0[number='1']/PName-c1.0"));
    }
}
