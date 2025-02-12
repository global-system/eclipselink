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
//     Denise Smith - October 18, 2012
package org.eclipse.persistence.testing.jaxb.annotations.xmltransient;

import java.util.ArrayList;

import jakarta.xml.bind.MarshalException;

import org.eclipse.persistence.exceptions.XMLMarshalException;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class ObjectWithTransientListTestCases extends JAXBWithJSONTestCases{

    public ObjectWithTransientListTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[] { ObjectWithTransient.class });
        expectsMarshalException = true;
    }

    @Override
    protected Object getControlObject() {
        ObjectWithTransient obj = new ObjectWithTransient();
        obj.testString = "theTest";
        TransientClass transientThing = new TransientClass();
        obj.transientThings = new ArrayList<TransientClass>();
        obj.transientThings.add(transientThing);

        return obj;
    }

    @Override
    public boolean isUnmarshalTest(){
        return false;
    }

    @Override
    public void assertMarshalException(Exception exception) throws Exception {
        Throwable linkedException = exception.getCause();
        assertTrue(linkedException instanceof XMLMarshalException);
        assertEquals("Wrong XMLMarshalExcpetion was thrown",XMLMarshalException.DESCRIPTOR_NOT_FOUND_IN_PROJECT ,((XMLMarshalException)linkedException).getErrorCode());
    }


}
