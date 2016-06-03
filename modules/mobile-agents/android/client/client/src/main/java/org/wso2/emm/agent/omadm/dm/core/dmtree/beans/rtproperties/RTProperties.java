/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.emm.agent.omadm.dm.core.dmtree.beans.rtproperties;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.rtproperties.rtformat.Format;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.rtproperties.rttype.Type;

import javax.xml.bind.annotation.*;

/**
 * This class represents the 'RTProperties' element in a node
 */
@Order(elements = {
        "ACL",
        "Format",
        "Name",
        "Size",
        "Title",
        "TStamp",
        "Type",
        "VerNo"
})
@Root(name = "RTProperties")
public class RTProperties {

    @Element(name = "ACL", required = false)
    protected String acl;
    @Element(name = "Format", required = false)
    protected Format format;
    @Element(name = "Name", required = false)
    protected String name;
    @Element(name = "Size", required = false)
    protected String size;
    @Element(name = "Title", required = false)
    protected String title;
    @Element(name = "TStamp", required = false)
    protected String tStamp;
    @Element(name = "Type", required = true)
    protected Type type;
    @Element(name = "VerNo", required = false)
    protected String verNo;

    public String getAcl() {
        return acl;
    }

    public void setAcl(String acl) {
        this.acl = acl;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String gettStamp() {
        return tStamp;
    }

    public void settStamp(String tStamp) {
        this.tStamp = tStamp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getVerNo() {
        return verNo;
    }

    public void setVerNo(String verNo) {
        this.verNo = verNo;
    }
}
