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
 package org.eclipse.persistence.testing.tests.jpa.performance.reading;

import jakarta.persistence.*;

import org.eclipse.persistence.testing.models.jpa.performance.*;
import org.eclipse.persistence.testing.framework.*;

/**
 * This test compares the performance of read object Employee.
 */
public class JPAReadObjectEmployeePerformanceComparisonTest extends PerformanceRegressionTestCase {
    protected long employeeId;

    public JPAReadObjectEmployeePerformanceComparisonTest() {
        setDescription("This test compares the performance of read object Employee.");
    }

    /**
     * Get an employee id.
     */
    @Override
    public void setup() {
        EntityManager manager = createEntityManager();
        employeeId = ((Employee)manager.createQuery("Select e from Employee e").getResultList().get(0)).getId();
        manager.close();
    }

    /**
     * Read object employee.
     */
    @Override
    public void test() throws Exception {
        EntityManager manager = createEntityManager();
        manager.getTransaction().begin();
        Employee employee = manager.getReference(Employee.class, this.employeeId);
        employee.toString();
        manager.getTransaction().commit();
        manager.close();
    }
}
