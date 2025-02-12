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
// dmccann - December 30/2010 - 2.3 - Initial implementation
package org.eclipse.persistence.testing.jaxb.xmladapter.list;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;


public class XmlAdapterListSingleBarTestCases extends JAXBWithJSONTestCases {
    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmladapter/list/singlebar.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/xmladapter/list/singlebar.json";

    public XmlAdapterListSingleBarTestCases(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        Class[] classes = new Class[2];
        classes[0] = FooWithBar.class;
        classes[1] = Bar.class;
        setClasses(classes);
    }

    @Override
    public Object getControlObject() {
        FooWithBar fooWithBar = new FooWithBar();
        List<String> itemlist = new ArrayList<String>();
        itemlist = new ArrayList<String>();
        itemlist.add(MyAdapter.VAL0);
        itemlist.add(MyAdapter.VAL1);
        itemlist.add(MyAdapter.VAL2);
        fooWithBar.items = itemlist;
        return fooWithBar;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.main(new String[] { "-c", "org.eclipse.persistence.testing.jaxb.xmladapter.list.XmlAdapterListSingleBarTestCases" });
    }
}
