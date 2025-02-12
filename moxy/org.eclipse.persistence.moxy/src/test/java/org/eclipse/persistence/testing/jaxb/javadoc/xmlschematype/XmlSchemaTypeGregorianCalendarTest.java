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
//     Praba Vijayaratnam - 2.3 - initial implementation
package org.eclipse.persistence.testing.jaxb.javadoc.xmlschematype;

//Example 1: Customize mapping of XMLGregorianCalendar at field level

import java.util.Calendar;
import org.eclipse.persistence.testing.jaxb.JAXBWithJSONTestCases;

public class XmlSchemaTypeGregorianCalendarTest extends JAXBWithJSONTestCases {

    private final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/javadoc/xmlschematype/xmlschematypecalendar.xml";
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/javadoc/xmlschematype/xmlschematypecalendar.json";

    public XmlSchemaTypeGregorianCalendarTest(String name) throws Exception {
        super(name);
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        Class[] classes = new Class[1];
        classes[0] = USPrice.class;
        setClasses(classes);
    }

    @Override
    protected Object getControlObject() {
        USPrice p = new USPrice();
/*        try{
        XMLGregorianCalendar cal = XMLGregorianCalendar.class.newInstance();
        cal.clear();
        cal.setYear(2011);
        cal.setMonth(02);
        cal.setDay(22);

        p.date = cal;
        }
        catch(Exception e){
            ;
        }*/

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2011,2,22);
        p.date = cal;

        return p;
    }
}
