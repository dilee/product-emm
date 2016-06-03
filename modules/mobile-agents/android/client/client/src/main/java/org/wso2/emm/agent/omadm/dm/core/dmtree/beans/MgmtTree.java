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

package org.wso2.emm.agent.omadm.dm.core.dmtree.beans;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the OMA Device Management Tree
 */
@Order(elements = {
        "VerDTD",
        "Man",
        "Mod",
        "Node"
})
@Root(name = "MgmtTree")
public class MgmtTree {

    @Element(name = "VerDTD", required = true)
    private String verDTD;
    @Element(name = "Man", required = false)
    private String man;
    @Element(name = "Mod", required = false)
    private String mod;
    @ElementList(name = "Node", inline = true, required = false)
    private List<Node> nodes = new ArrayList<>();

    // Additional Properties
    @Transient
    private URL publicPath;
    @Transient
    private String fileName;
    @Transient
    private String type;
    @Transient
    private String name;

    public MgmtTree() {
    }

    public MgmtTree(String verDTD, String man, String mod, List<Node> nodes) {
        this.verDTD = verDTD;
        this.man = man;
        this.mod = mod;
        this.nodes = nodes;
    }

    public MgmtTree(String verDTD, String man, String mod) {
        this.verDTD = verDTD;
        this.man = man;
        this.mod = mod;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public String getVerDTD() {
        return verDTD;
    }

    public void setVerDTD(String verDTD) {
        this.verDTD = verDTD;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public URL getPublicPath() {
        return publicPath;
    }

    public void setPublicPath(URL publicPath) {
        this.publicPath = publicPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
