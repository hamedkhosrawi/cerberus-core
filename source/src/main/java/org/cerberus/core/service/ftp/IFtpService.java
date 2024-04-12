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
package org.cerberus.core.service.ftp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTPClient;
import org.cerberus.core.crud.entity.AppService;
import org.cerberus.core.util.answer.AnswerItem;

/**
 *
 * @author ryltar
 */
public interface IFtpService {

    /**
     * this method is used to interact with the ftp server
     *
     * @param chain
     * @param system
     * @param content
     * @param method
     * @param ftpPath
     * @param service
     * @param timeOutMs
     * @return AppService
     */
    public AnswerItem<AppService> callFTP(String chain, String system, String content, String method, String ftpPath, String service, int timeOutMs);

}
