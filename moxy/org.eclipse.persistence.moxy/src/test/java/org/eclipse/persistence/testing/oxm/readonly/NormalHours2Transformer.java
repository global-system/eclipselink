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
package org.eclipse.persistence.testing.oxm.readonly;

import java.util.Calendar;
import org.eclipse.persistence.mappings.foundation.AbstractTransformationMapping;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.mappings.transformers.*;
import java.util.Vector;

import org.eclipse.persistence.sessions.Record;

public class NormalHours2Transformer implements FieldTransformer, AttributeTransformer
{
    @Override
    public void initialize(AbstractTransformationMapping mapping)
    {
    }
  @Override
  public Object buildFieldValue(Object instance, String fieldName, Session session)
  {
    if(fieldName.equals("normal-hours/start-time/text()"))
        {
            return ((Employee)instance).normalHours2.elementAt(0);
        }
        return ((Employee)instance).normalHours2.elementAt(1);
  }
  @Override
  public Object buildAttributeValue(Record record, Object instance, Session session)
  {
    Vector normalHours = new Vector(2);
    normalHours.addElement(record.get("normal-hours/start-time/text()"));
    normalHours.addElement(record.get("normal-hours/end-time/text()"));
    return normalHours;
  }
}

