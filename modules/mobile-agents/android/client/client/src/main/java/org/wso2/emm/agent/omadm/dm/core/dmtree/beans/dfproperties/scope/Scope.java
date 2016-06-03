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

package org.wso2.emm.agent.omadm.dm.core.dmtree.beans.dfproperties.scope;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;

/**
 * The 'Scope' property of the 'DFProperties' property
 */
@Root(name = "Scope")
public class Scope {

    @ElementUnion({
            @Element(name = "Permanent", required = true, type = Permanent.class),
            @Element(name = "Dynamic", required = true, type = Dynamic.class)
    })

    private AbstractScopeProperty scope;

    public AbstractScopeProperty getScope() {
        return scope;
    }

    public void setScope(AbstractScopeProperty scope) {
        this.scope = scope;
    }
}
