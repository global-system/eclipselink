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
package org.eclipse.persistence.testing.sdo.helper.datahelper;

import commonj.sdo.Type;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import junit.framework.TestCase;
import org.eclipse.persistence.sdo.SDOConstants;
import org.eclipse.persistence.sdo.SDOType;
import org.eclipse.persistence.testing.sdo.SDOTestCase;

public class DataHelperConvertFromStringTest extends DataHelperTestCases {
    public DataHelperConvertFromStringTest(String name) {
        super(name);
    }

    public void testConverFromString() {
        String b = "10";
        Integer B = Integer.valueOf(b);
        assertEquals(B, dataHelper.convertFromStringValue(b, Integer.class, null));
    }

    public void testConverFromString_Date() {
        String b = "2000";
        Date aDate = dataHelper.toDate(b);

        assertEquals(aDate, dataHelper.convertFromStringValue(b, Date.class, null));
    }

    public void testConverFromString_Calendar() {
        String b = "2000";
        Calendar controlCalendar = Calendar.getInstance();
        controlCalendar.clear();
        controlCalendar.set(Calendar.YEAR, 2000);
        controlCalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar aCalendar = (Calendar)dataHelper.convertFromStringValue(b, Calendar.class, null);
        assertTrue("Expected YEAR: " + controlCalendar.get(Calendar.YEAR) + ", but was: " + aCalendar.get(Calendar.YEAR), controlCalendar.get(Calendar.YEAR) == aCalendar.get(Calendar.YEAR));
        assertTrue("Expected TimeZone: " + controlCalendar.getTimeZone() + ", but was: " + aCalendar.getTimeZone(), controlCalendar.getTimeZone().equals(aCalendar.getTimeZone()));
        assertTrue("Expected same time in millis", controlCalendar.getTimeInMillis() == aCalendar.getTimeInMillis());
    }

    public void testConverFromString_NoQname() {
        String b = "10";
        Integer B = Integer.valueOf(b);
        assertEquals(B, dataHelper.convertFromStringValue(b, Integer.class));
    }

    public void testConverFromString_Date_NoQName() {
        String b = "2000";
        Date aDate = dataHelper.toDate(b);
        assertEquals(aDate, dataHelper.convertFromStringValue(b, Date.class));
    }

    public void testConverFromString_Calendar_NoQname() {
        String b = "2000";
        Calendar controlCalendar = Calendar.getInstance();
        controlCalendar.clear();
        controlCalendar.set(Calendar.YEAR, 2000);
        controlCalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar aCalendar = (Calendar)dataHelper.convertFromStringValue(b, Calendar.class, null);
        assertTrue("Expected YEAR: " + controlCalendar.get(Calendar.YEAR) + ", but was: " + aCalendar.get(Calendar.YEAR), controlCalendar.get(Calendar.YEAR) == aCalendar.get(Calendar.YEAR));
        assertTrue("Expected TimeZone: " + controlCalendar.getTimeZone() + ", but was: " + aCalendar.getTimeZone(), controlCalendar.getTimeZone().equals(aCalendar.getTimeZone()));
        assertTrue("Expected same time in millis", controlCalendar.getTimeInMillis() == aCalendar.getTimeInMillis());
    }

    public void testConverFromString_Type() {
        String b = "10";
        Integer B = Integer.valueOf(b);
        assertEquals(B, dataHelper.convertFromStringValue(b, Integer.class));
    }

    public void testConverFromString_DateWithType() {
        String b = "2000";
        Date aDate = dataHelper.toDate(b);
        SDOType d = SDOConstants.SDO_DATE;
        assertEquals(aDate, dataHelper.convertFromStringValue(b, d));
    }

    public void testConverFromString_DateWithTypeNullQName() {
        String b = "2000";
        Date aDate = dataHelper.toDate(b);
        SDOType d = SDOConstants.SDO_DATE;
        assertEquals(aDate, dataHelper.convertFromStringValue(b, d, null));
    }

    public void testConverFromString_DateWithTypeQName() {
        String b = "2000";
        Date aDate = dataHelper.toDate(b);
        SDOType d = SDOConstants.SDO_DATE;
        assertEquals(aDate, dataHelper.convertFromStringValue(b, d, SDOConstants.GYEARMONTH_QNAME));
    }

    public void testConverFromString_DateWithNullTypeNullQName() {
        String b = "2000";
        Date aDate = dataHelper.toDate(b);
        SDOType d = new SDOType(aHelperContext);
        assertEquals(b, (String)dataHelper.convertFromStringValue(b, d, null));
    }

    public void testConverFromObject_DateWithNullTypeNullQName() {
        String b = "2000";
        Date aDate = dataHelper.toDate(b);

        assertEquals("2000-01-01T00:00:00Z", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_DATETIME));
        assertEquals("2000", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_YEAR));
        assertEquals("2000-01", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_YEARMONTH));
        assertEquals("2000-01-01T00:00:00Z", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_DATE));
        assertEquals("00:00:00Z", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_TIME));
        assertEquals("---01", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_DAY));
        assertEquals("P2000Y1M1DT0H0M0.0S", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_DURATION));
        assertEquals("--01", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_MONTH));
        assertEquals("--01-01", dataHelper.convertToStringValue(aDate, SDOConstants.SDO_MONTHDAY));
    }

    public void testConverFromObject_Date_GMTDefault() {
        // Original date string, will be interpreted as GMT by default
        String origDateString = "1999-05-31T15:55:00.000";

        // String converted to date -- this will be converted to VM's time zone
        Date aDate = dataHelper.toDate(origDateString);

        // Format the date back to GMT and make sure it equals the original
        // date string
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS");
        f.setTimeZone(TimeZone.getTimeZone("GMT"));
        String dateString = f.format(aDate);

        assertEquals(origDateString, dateString);
    }
}
