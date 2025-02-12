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
//     Denise Smith  June 05, 2009 - Initial implementation
package org.eclipse.persistence.testing.jaxb.listofobjects;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.persistence.jaxb.json.JsonSchemaOutputResolver;

public class JAXBEmployeeArrayTestCases extends JAXBListOfObjectsTestCases{

    protected final static String XML_RESOURCE = "org/eclipse/persistence/testing/jaxb/listofobjects/employeeArray.xml";
    protected final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/listofobjects/employeeArray.json";
    protected final static String JSON_SCHEMA_RESOURCE = "org/eclipse/persistence/testing/jaxb/listofobjects/employeeArraySchema.json";
    private final static String XML_RESOURCE_NO_XSI_TYPE = "org/eclipse/persistence/testing/jaxb/listofobjects/employeeArrayNoXsiType.xml";
    protected final static String CONTROL_RESPONSIBILITY1 = "Fix Bugs";
    protected final static String CONTROL_RESPONSIBILITY2 = "Write JAXB2.0 Prototype";
    protected final static String CONTROL_RESPONSIBILITY3 = "Write Design Spec";
    protected final static String CONTROL_FIRST_NAME = "Bob";
    protected final static String CONTROL_LAST_NAME = "Smith";
    protected final static int CONTROL_ID = 10;

    public JAXBEmployeeArrayTestCases(String name) throws Exception {
        super(name);
        init();
    }

    public void init() throws Exception {
        setControlDocument(XML_RESOURCE);
        setControlJSON(JSON_RESOURCE);
        Class[] classes = new Class[1];
        classes[0] = Employee[].class;
        setClasses(classes);
        initXsiType();
    }

    @Override
    protected Map<String, String> getAdditationalNamespaces() {
        Map<String, String> namespaces = new HashMap<>();
        namespaces.put("rootNamespace", "ns0");
        namespaces.put("listOfObjectsNamespace", "x");
        return namespaces;
    }

    @Override
    public List< InputStream> getControlSchemaFiles(){
        InputStream instream = ClassLoader.getSystemResourceAsStream("org/eclipse/persistence/testing/jaxb/listofobjects/employeeArray.xsd");

        List<InputStream> controlSchema = new ArrayList<InputStream>();
        controlSchema.add(instream);
        return controlSchema;
    }

    @Override
    protected Object getControlObject() {
        ArrayList responsibilities = new ArrayList();
        responsibilities.add(CONTROL_RESPONSIBILITY1);
        responsibilities.add(CONTROL_RESPONSIBILITY2);
        responsibilities.add(CONTROL_RESPONSIBILITY3);

        Employee employee = new Employee();
        employee.firstName = CONTROL_FIRST_NAME;
        employee.lastName = CONTROL_LAST_NAME;

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2005, 04, 24, 16, 06, 53);

        employee.id = CONTROL_ID;

        employee.responsibilities = responsibilities;

        employee.setBlah("Some String");

        Employee employee2 = new Employee();
        employee2.firstName = CONTROL_FIRST_NAME + "2";
        employee2.lastName = CONTROL_LAST_NAME + "2";
        employee2.setBlah("Some Other String");
        employee2.id = 100;

        ArrayList responsibilities2 = new ArrayList();
        responsibilities2.add(CONTROL_RESPONSIBILITY1);
        employee2.responsibilities = responsibilities2;

        Employee[] emps = new Employee[2];
        emps[0] = employee;
        emps[1] = employee2;

        QName qname = new QName("rootNamespace", "root");
        JAXBElement jaxbElement = new JAXBElement(qname, Object.class, null);
        jaxbElement.setValue(emps);

        return jaxbElement;
    }

    @Override
    protected Type getTypeToUnmarshalTo() throws Exception {
        return Employee[].class;
    }

    @Override
    protected String getNoXsiTypeControlResourceName() {
        return XML_RESOURCE_NO_XSI_TYPE;
    }

     public void testJSONSchemaGen() throws Exception{
         InputStream controlSchema = classLoader.getResourceAsStream(JSON_SCHEMA_RESOURCE);
         super.generateJSONSchema(controlSchema);
     }


}
