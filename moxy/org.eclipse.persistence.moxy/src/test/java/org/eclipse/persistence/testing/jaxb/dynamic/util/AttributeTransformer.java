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
//     rbarkhouse - 2.2 - initial implementation
package org.eclipse.persistence.testing.jaxb.dynamic.util;

import org.eclipse.persistence.mappings.transformers.AttributeTransformerAdapter;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

public class AttributeTransformer extends AttributeTransformerAdapter {

    @Override
    public Object buildAttributeValue(Record record, Object instance, Session session) {
        String[] objectValue = new String[2];
        objectValue[0] = (String) record.get("transform/first-val/text()");
        objectValue[1] = (String) record.get("transform/second-val/text()");
        return objectValue;
    }

}
