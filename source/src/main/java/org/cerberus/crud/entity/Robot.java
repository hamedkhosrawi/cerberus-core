/**
 * Cerberus Copyright (C) 2013 - 2017 cerberustesting
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This file is part of Cerberus.
 *
 * Cerberus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cerberus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cerberus.crud.entity;

import org.cerberus.util.StringUtil;

import java.util.List;

/**
 *
 * @author bcivel
 */
public class Robot {

    private Integer robotID;
    private String robot;
    private String host;
    private String port;
    private String hostUser;
    private String hostPassword;
    private String platform;
    private String browser;
    private String version;
    private String active;
    private String description;
    private String userAgent;
    private String robotDecli;
    private String screenSize;
    
    /**
     * From here are data outside database model.
     */
    private List<RobotCapability> capabilities;
    private List<RobotCapability> capabilitiesDecoded;

    public List<RobotCapability> getCapabilitiesDecoded() {
        return capabilitiesDecoded;
    }

    public void setCapabilitiesDecoded(List<RobotCapability> capabilitiesDecoded) {
        this.capabilitiesDecoded = capabilitiesDecoded;
    }

    public String getRobotDecli() {
        return robotDecli;
    }

    public void setRobotDecli(String robotDecli) {
        this.robotDecli = robotDecli;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
    
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getRobotID() {
        return robotID;
    }

    public void setRobotID(Integer robotID) {
        this.robotID = robotID;
    }

    public String getRobot() {
        return robot;
    }

    public void setRobot(String robot) {
        this.robot = robot;
    }

    public String getHost() {
        return host;
    }

    public String getHostWithCredential() {
        String credential = "";
        if(!StringUtil.isNullOrEmpty(this.getHostUser()))
            credential = this.getHostUser() + ":" + this.getHostPassword() + "@";

        return credential + this.getHost();
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

	public List<RobotCapability> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(List<RobotCapability> capabilities) {
		this.capabilities = capabilities;
	}

    public String getHostUser() {
        return hostUser;
    }

    public void setHostUser(String hostUser) {
        this.hostUser = hostUser;
    }

    public String getHostPassword() {
        return hostPassword;
    }

    public void setHostPassword(String hostPassword) {
        this.hostPassword = hostPassword;
    }
}
