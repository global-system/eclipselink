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
 package org.eclipse.persistence.testing.tests.jpa.performance.writing;

import jakarta.persistence.*;

import org.eclipse.persistence.internal.helper.Helper;
import org.eclipse.persistence.testing.models.jpa.performance.*;
import org.eclipse.persistence.testing.framework.*;

/**
 * This test compares the performance of inserting Employee.
 */
public class JPAMassInsertEmployeePerformanceComparisonTest extends PerformanceRegressionTestCase {
    public JPAMassInsertEmployeePerformanceComparisonTest() {
        setDescription("This test compares the performance of insert Employee.");
    }

    /**
     * Delete all employees.
     */
    @Override
    public void reset() {
        EntityManager manager = createEntityManager();
        manager.getTransaction().begin();
        manager.createQuery("Delete from PhoneNumber where number = '9991111'").executeUpdate();
        manager.createQuery("Delete from Employee where firstName = 'NewGuy'").executeUpdate();
        manager.createQuery("Delete from Address where street = 'Hastings Perf'").executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Insert employee.
     */
    @Override
    public void test() throws Exception {
        EntityManager manager = createEntityManager();
        manager.getTransaction().begin();
        for (int index = 0; index < 50; index++) {
            Employee employee = new Employee();
            employee.setFirstName("NewGuy");
            employee.setLastName("Smith" + index);

            EmploymentPeriod employmentPeriod = new EmploymentPeriod();
            java.sql.Date startDate = Helper.dateFromString("1901-12-31");
            java.sql.Date endDate = Helper.dateFromString("1970-01-01");
            employmentPeriod.setEndDate(startDate);
            employmentPeriod.setStartDate(endDate);
            employee.setPeriod(employmentPeriod);

            Address address = new Address();
            address.setCity("Ottawa + index");
            address.setStreet("Hastings Perf");
            address.setProvince("ONT");
            employee.setAddress(address);

            PhoneNumber phone = new PhoneNumber();
            phone.setType("home" + index);
            phone.setAreaCode("613");
            phone.setNumber("9991111");
            employee.addPhoneNumber(phone);

            phone = new PhoneNumber();
            phone.setType("fax" + index);
            phone.setAreaCode("613");
            phone.setNumber("9991111");
            employee.addPhoneNumber(phone);

            manager.persist(employee);
        }
        manager.getTransaction().commit();
        manager.close();
    }
}
