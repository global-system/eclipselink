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
//  - rbarkhouse - 27 January 2012 - 2.3.3 - Initial implementation
package org.eclipse.persistence.testing.jaxb.collections;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class CollectionHolderWrappersInitializedELTestCases extends JAXBWithJSONTestCases {

    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/collections/emptycollectionholderwrappersinitialized.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/collections/emptycollectionholderwrappersinitializedEL.json";

    public CollectionHolderWrappersInitializedELTestCases(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);

        Class[] classes = new Class[1];
        classes[0] = CollectionHolderWrappersInitialized.class;
        setClasses(classes);
        jaxbMarshaller.setProperty(MarshallerProperties.JSON_MARSHAL_EMPTY_COLLECTIONS, Boolean.TRUE);
    }

    @Override
    protected Object getControlObject() {
        return new CollectionHolderWrappersInitialized();
    }

    @Override
    public boolean shouldRemoveWhitespaceFromControlDocJSON(){
        return false;
    }
}
