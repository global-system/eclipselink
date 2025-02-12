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
//      tware - initial implementation
package org.eclipse.persistence.jpa.rs.eventlistener;

import org.eclipse.persistence.platform.database.events.DatabaseEventListener;
import org.eclipse.persistence.sessions.Session;

/**
 * Extends EclipseLink's database event listening capabilities by allowing a listener to subscribe to
 * to change notifications from the database
 *
 * This listener also expands the interface to support subscription on a descriptor basis rather than
 * the wholesale subscription provided by its superclass.
 *
 * @author tware
 *
 */
public interface DescriptorBasedDatabaseEventListener extends DatabaseEventListener {

    /**
     * Register for change notifications on a particular descriptor
     */
    public void register(Session session, String queryName);

    public void addChangeListener(ChangeListener listener);

    public void removeChangeListener(ChangeListener listener);
}
