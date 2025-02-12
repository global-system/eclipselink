/*
 * Copyright (c) 2019, 2021 Oracle and/or its affiliates. All rights reserved.
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
//     Radek Felcman - 2.7.5 - initial implementation
package org.eclipse.persistence.testing.jaxb.json.array;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import org.eclipse.persistence.testing.jaxb.json.JSONTestCases;

/**
 * Tests marshall/unmarshal of 3d array (int[]).
 *
 * @author Radek Felcman
 *
 */
public class Nested3dArrayTestCases extends JSONTestCases {

    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/json/array/nested_3d_array.json";

    public Nested3dArrayTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[]{Root3DArray.class});
        setControlJSON(JSON_RESOURCE);
    }

    @Override
    public void setUp() throws Exception{
        super.setUp();
        jsonMarshaller.setProperty(MarshallerProperties.JSON_DISABLE_NESTED_ARRAY_NAME, true);
        jsonUnmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, false);
    }

    @Override
    protected Object getControlObject() {
        Root3DArray root3DArray = new Root3DArray();
        Integer[][][] int3DArray = {{{1, 2}, {3, 4}, {5, 6}}, {{7, 8}, {9, 10}, {11,12}}};
        root3DArray.setArray3d(int3DArray);
        return root3DArray;
    }

}
