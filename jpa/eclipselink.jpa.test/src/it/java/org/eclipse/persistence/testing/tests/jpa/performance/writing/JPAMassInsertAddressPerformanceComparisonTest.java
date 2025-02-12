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

import org.eclipse.persistence.testing.models.jpa.performance.*;
import org.eclipse.persistence.testing.framework.*;

/**
 * This test compares the performance of inserting many Address.
 */
public class JPAMassInsertAddressPerformanceComparisonTest extends PerformanceRegressionTestCase {
    public JPAMassInsertAddressPerformanceComparisonTest() {
        setDescription("This test compares the performance of insert many Address.");
    }

    /**
     * Delete all addresses.
     */
    @Override
    public void reset() {
        EntityManager manager = createEntityManager();
        manager.getTransaction().begin();
        manager.createQuery("Delete from Address where street = 'Hastings Perf'").executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }

    /**
     * Insert address .
     */
    @Override
    public void test() throws Exception {
        EntityManager manager = createEntityManager();
        manager.getTransaction().begin();
        for (int index = 0; index < 50; index++) {
            Address address = new Address();
            address.setCity("Ottawa" + index);
            address.setStreet("Hastings Perf");
            address.setProvince("ONT");
            manager.persist(address);
        }
        manager.getTransaction().commit();
        manager.close();

        manager = createEntityManager();
        manager.getTransaction().begin();
        //manager.createNativeQuery("Delete from ADDRESS where street = 'Hastings Perf'").executeUpdate();
        manager.getTransaction().commit();
        manager.close();
    }
}
