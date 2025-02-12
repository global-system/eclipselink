/*
 * Copyright (c) 2013, 2021 Oracle and/or its affiliates. All rights reserved.
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
//      gonural - initial
package org.eclipse.persistence.jpa.rs.util.list;

import org.eclipse.persistence.internal.jpa.rs.metadata.model.LinkV2;
import org.eclipse.persistence.jpa.rs.ReservedWords;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to wrap collection of records returned
 * by a JPA read all query and includes paging links.
 *
 * @author gonural
 */
@XmlRootElement(name = ReservedWords.NO_ROUTE_JAXB_ELEMENT_LABEL)
@XmlType(propOrder = { "items", "hasMore", "limit", "offset", "count", "links" })
public class ReadAllQueryResultCollection implements PageableCollection<Object> {
    private List<Object> items = new ArrayList<>();
    private Boolean hasMore = null;
    private Integer limit = null;
    private Integer offset = null;
    private Integer count = null;
    private List<LinkV2> links;

    @Override
    public List<Object> getItems() {
        return items;
    }

    @Override
    public void setItems(List<Object> items) {
        this.items = items;
    }

    @Override
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    @Override
    public Boolean getHasMore() {
        return hasMore;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public Integer getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public Integer getOffset() {
        return this.offset;
    }

    @Override
    public List<LinkV2> getLinks() {
        return this.links;
    }

    @Override
    public void setLinks(List<LinkV2> links) {
        this.links = links;
    }

    @Override
    public void addLink(LinkV2 link) {
        if (this.links == null) {
            this.links = new ArrayList<>();
        }

        this.links.add(link);
    }

    /**
     * Adds the item.
     *
     * @param item the item
     */
    public void addItem(Object item) {
        this.items.add(item);
    }
}
