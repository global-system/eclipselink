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
//     12/12/2008-1.1 Guy Pelletier
//       - 249860: Implement table per class inheritance support.
package org.eclipse.persistence.testing.models.jpa.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="TPC_BOMB")
public class Bomb extends IndirectWeapon {
    public enum BOMBTYPE { NUCLEAR, DIRTY, RADIOACTIVE }

    @Column(name="B_TYPE")
    private BOMBTYPE bombType;

    public Bomb() {}

    public BOMBTYPE getBombType() {
        return bombType;
    }

    @Override
    public boolean isBomb() {
        return true;
    }

    public void setBombType(BOMBTYPE bombType) {
        this.bombType = bombType;
    }
}
