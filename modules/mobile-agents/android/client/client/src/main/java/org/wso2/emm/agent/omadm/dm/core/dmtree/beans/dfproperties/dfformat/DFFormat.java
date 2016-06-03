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

package org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.dfformat;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.format.*;
import org.wso2.emm.agent.omadm.dm.core.dmtree.beans.format.Float;

import javax.xml.bind.annotation.*;

/**
 * The 'DFFormat' property of the 'DFProperties' property
 */
@Root(name = "DFFormat")
public class DFFormat {

    @ElementUnion({
            @Element(name = "b64", required = true, type = B64.class),
            @Element(name = "bin", required = true, type = Bin.class),
            @Element(name = "bool", required = true, type = Bool.class),
            @Element(name = "chr", required = true, type = Chr.class),
            @Element(name = "int", required = true, type = Int.class),
            @Element(name = "null", required = true, type = Null.class),
            @Element(name = "xml", required = true, type = Xml.class),
            @Element(name = "date", required = true, type = Date.class),
            @Element(name = "time", required = true, type = Time.class),
            @Element(name = "node", required = true, type = Node.class),
            @Element(name = "float", required = true, type = Float.class)
    })

    private AbstractFormatProperty format;

    public AbstractFormatProperty getFormat() {
        return format;
    }

    public void setFormat(AbstractFormatProperty format) {
        this.format = format;
    }
}
