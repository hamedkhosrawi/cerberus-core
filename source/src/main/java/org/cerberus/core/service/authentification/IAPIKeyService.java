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
package org.cerberus.core.service.authentification;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bcivel
 */
public interface IAPIKeyService {

    /**
     * Method that checks every Public API calls and generate an error message
     * in case the token does not match 1 of the API key value.
     *
     * @param request
     * @param response
     * @return
     */
    public boolean authenticate(HttpServletRequest request, HttpServletResponse response);

    /**
     *
     * @param principal
     * @param apiKey
     * @return
     */
    public boolean authenticate(Principal principal, String apiKey);

    /**
     *
     * @param principal
     * @param apiKey
     * @return null if not authenticated and login if authenticated.
     */
    public String authenticateLogin(Principal principal, String apiKey);
    
    /**
     *
     * @return
     */
    public String getServiceAccountAPIKey();

    /**
     *
     * @param apiKey
     * @return
     */
    public boolean authenticate(String apiKey);

}
