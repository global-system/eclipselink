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
package org.eclipse.persistence.testing.oxm.mappings.compositecollection.identifiedbyname.withgroupingelement;

import org.eclipse.persistence.testing.oxm.mappings.XMLWithJSONMappingTestCases;
import org.eclipse.persistence.testing.oxm.mappings.compositecollection.Employee;
import org.eclipse.persistence.testing.oxm.mappings.compositecollection.EmailAddress;
import org.eclipse.persistence.testing.oxm.mappings.compositecollection.MailingAddress;

public class CompositeCollectionSingleElementTestCases extends XMLWithJSONMappingTestCases {

  private final static String XML_RESOURCE = "org/eclipse/persistence/testing/oxm/mappings/compositecollection/identifiedbyname/withgroupingelement/CompositeCollectionSingleElement.xml";
  private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/oxm/mappings/compositecollection/identifiedbyname/withgroupingelement/CompositeCollectionSingleElement.json";
  private final static int CONTROL_EMPLOYEE_ID = 123;
  private final static String CONTROL_EMAIL_ADDRESS_1_USER_ID = "jane.doe";
  private final static String CONTROL_EMAIL_ADDRESS_1_DOMAIN = "example.com";
  private final static String CONTROL_EMAIL_ADDRESS_2_USER_ID = "jdoe";
  private final static String CONTROL_EMAIL_ADDRESS_2_DOMAIN = "test.com";
  private final static String CONTROL_MAILING_ADDRESS_1_STREET = "1 Any Street";
  private final static String CONTROL_MAILING_ADDRESS_1_CITY = "Ottawa";
  private final static String CONTROL_MAILING_ADDRESS_1_PROVINCE = "Ontario";
  private final static String CONTROL_MAILING_ADDRESS_1_POSTAL_CODE = "A1B 2C3";

  public CompositeCollectionSingleElementTestCases(String name) throws Exception {
    super(name);
    setControlDocument(XML_RESOURCE);
    setControlJSON(JSON_RESOURCE);
    //setSession(SESSION_NAME);
        setProject(new CompositeCollectionWithGroupingElementIdentifiedByNameProject());
  }

  @Override
  protected Object getControlObject() {
    Employee employee = new Employee();
    employee.setID(CONTROL_EMPLOYEE_ID);

    EmailAddress emailAddress1 = new EmailAddress();
    emailAddress1.setUserID(CONTROL_EMAIL_ADDRESS_1_USER_ID);
    emailAddress1.setDomain(CONTROL_EMAIL_ADDRESS_1_DOMAIN);
    employee.getEmailAddresses().add(emailAddress1);

    EmailAddress emailAddress2 = new EmailAddress();
    emailAddress2.setUserID(CONTROL_EMAIL_ADDRESS_2_USER_ID);
    emailAddress2.setDomain(CONTROL_EMAIL_ADDRESS_2_DOMAIN);
    employee.getEmailAddresses().add(emailAddress2);

    MailingAddress mailingAddress1 = new MailingAddress();
    mailingAddress1.setStreet(CONTROL_MAILING_ADDRESS_1_STREET);
    mailingAddress1.setCity(CONTROL_MAILING_ADDRESS_1_CITY);
    mailingAddress1.setProvince(CONTROL_MAILING_ADDRESS_1_PROVINCE);
    mailingAddress1.setPostalCode(CONTROL_MAILING_ADDRESS_1_POSTAL_CODE);
    employee.getMailingAddresses().add(mailingAddress1);

    return employee;
  }

}
