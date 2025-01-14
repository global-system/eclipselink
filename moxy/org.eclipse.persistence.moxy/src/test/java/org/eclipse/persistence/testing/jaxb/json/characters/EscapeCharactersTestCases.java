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
//     Denise Smith - 2.4
package org.eclipse.persistence.testing.jaxb.json.characters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.testing.jaxb.json.JSONMarshalUnmarshalTestCases;

public class EscapeCharactersTestCases extends JSONMarshalUnmarshalTestCases {
    private final static String JSON_RESOURCE = "org/eclipse/persistence/testing/jaxb/json/characters/escapeCharacters.json";

    public EscapeCharactersTestCases(String name) throws Exception {
        super(name);
        setClasses(new Class[]{EscapeCharacterHolder.class});
        setControlJSON(JSON_RESOURCE);
    }

    @Override
    protected Object getControlObject() {
        EscapeCharacterHolder holder = new EscapeCharacterHolder();

        holder.stringValue = "a\"a\\a/a\ba\fa\na\ra\t\b\u0003\u001Caaa\\TESThttp://this/is/my/test";

        List<Character> characters = new ArrayList<Character>();
        characters.add('a');
        characters.add('"');
        characters.add('a');
        characters.add('\\');
        characters.add('a');
        characters.add('/');
        characters.add('a');
        characters.add('\b');
        characters.add('a');
        characters.add('\f');
        characters.add('a');
        characters.add('\n');
        characters.add('a');
        characters.add('\r');
        characters.add('a');
        characters.add('\t');
        characters.add('\b');
        characters.add('\u0003');
        characters.add('\u001C');
        characters.add('a');
        characters.add('a');
        characters.add('a');
        characters.add('\\');
        holder.characters = characters;
        return holder;
    }

    @Override
    protected void compareStrings(String test, String testString, String expectedString, boolean removeWhitespace) {
        log(test);
        log("Expected (With All Whitespace Removed):");
        if(removeWhitespace){
           expectedString = expectedString.replaceAll("[ \b\t\n\r ]", "");
        }
        log(expectedString);

        log("\nActual (With All Whitespace Removed):");
        if(removeWhitespace){
            testString = testString.replaceAll("[ \b\t\n\r]", "");
        }
        log(testString);
        assertEquals(expectedString.toLowerCase(), testString.toLowerCase());
    }

}
