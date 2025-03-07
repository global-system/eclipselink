/*
 * Copyright (c) 2020, 2024 Oracle and/or its affiliates. All rights reserved.
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
//     Oracle - initial API and implementation
package org.eclipse.persistence.testing.models.jpa.deadlock.diagnostic;

import org.eclipse.persistence.testing.models.jpa.deadlock.diagnostic.event.EventProducer;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import jakarta.persistence.*;

public class MainThread implements Runnable {

    public static final long ID = 1L;

    public static EntityManagerFactory emf = null;
    public static EntityManager em = null;

    TypedQuery<CacheDeadLockDetectionMaster> queryMaster;
    TypedQuery<CacheDeadLockDetectionDetail> queryDetail;

    SeContainer container;

    @Inject
    EventProducer eventProducer;

    public MainThread() {}

    public MainThread(SeContainer container, EntityManagerFactory emf, EntityManager em) {
        this.container = container;
        MainThread.emf = emf;
        MainThread.em = em;
        eventProducer = container.select(EventProducer.class).get();
        queryMaster = em.createNamedQuery("MasterEntity.findById", CacheDeadLockDetectionMaster.class);
        queryMaster.setParameter("id", ID);
        queryDetail = em.createNamedQuery("DetailEntity.findById", CacheDeadLockDetectionDetail.class);
        queryDetail.setParameter("id", ID);
    }

    @Override
    public void run() {
        CacheDeadLockDetectionMaster resultsMaster = queryMaster.getSingleResult();
        CacheDeadLockDetectionDetail resultsDetail = queryDetail.getSingleResult();
        eventProducer.fireAsyncEvent(getMasterEntityByQuery(em));
    }

    private CacheDeadLockDetectionMaster getMasterEntityByQuery(EntityManager em) {
        Query query = em.createQuery("SELECT e FROM CacheDeadLockDetectionMaster AS e WHERE e.id = :id", CacheDeadLockDetectionMaster.class);
        query.setParameter("id", ID);
        CacheDeadLockDetectionMaster cacheDeadLockDetectionMaster = (CacheDeadLockDetectionMaster)query.getSingleResult();
        return cacheDeadLockDetectionMaster;
    }
}
