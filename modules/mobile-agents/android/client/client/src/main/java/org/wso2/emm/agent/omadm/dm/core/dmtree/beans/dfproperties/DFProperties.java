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

package org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.accesstype.AccessType;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.casesense.CaseSense;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.dfformat.DFFormat;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.dftype.DFType;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.occurrence.Occurrence;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.scope.Scope;

/**
 * This class represents the 'DFProperties' element in a node
 */
@Order(elements = {
        "AccessType",
        "DefaultValue",
        "Description",
        "DFFormat",
        "Occurrence",
        "Scope",
        "DFTitle",
        "DFType",
        "CaseSense"
})
@Root(name = "DFProperties")
public class DFProperties {

    @Element(name = "AccessType", required = true)
    protected AccessType accessType;
    @Element(name = "DefaultValue", required = false)
    protected String defaultValue;
    @Element(name = "Description", required = false)
    protected String description;
    @Element(name = "DFFormat", required = true)
    protected DFFormat dfFormat;
    @Element(name = "Occurrence", required = false)
    protected Occurrence occurrence;
    @Element(name = "Scope", required = false)
    protected Scope scope;
    @Element(name = "DFTitle", required = false)
    protected String dfTitle;
    @Element(name = "DFType", required = false)
    protected DFType dfType;
    @Element(name = "CaseSense", required = false)
    protected CaseSense caseSense;

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DFFormat getDfFormat() {
        return dfFormat;
    }

    public void setDfFormat(DFFormat dfFormat) {
        this.dfFormat = dfFormat;
    }

    public Occurrence getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public String getDfTitle() {
        return dfTitle;
    }

    public void setDfTitle(String dfTitle) {
        this.dfTitle = dfTitle;
    }

    public DFType getDfType() {
        return dfType;
    }

    public void setDfType(DFType dfType) {
        this.dfType = dfType;
    }

    public CaseSense getCaseSense() {
        return caseSense;
    }

    public void setCaseSense(CaseSense caseSense) {
        this.caseSense = caseSense;
    }
}
