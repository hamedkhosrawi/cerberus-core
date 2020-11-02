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
package org.cerberus.service.consolelog.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.cerberus.crud.entity.Invariant;
import org.cerberus.crud.entity.TestCaseExecutionHttpStat;
import org.cerberus.crud.service.IInvariantService;
import org.cerberus.crud.service.IParameterService;
import org.cerberus.exception.CerberusException;
import org.cerberus.service.consolelog.IConsolelogService;
import org.cerberus.service.har.entity.HarStat;
import org.cerberus.util.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bcivel
 */
@Service
public class ConsolelogService implements IConsolelogService {

    @Autowired
    private IParameterService parameterService;
    @Autowired
    private IInvariantService invariantService;

    private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(ConsolelogService.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.S'Z'";
    private static final String PROVIDER_INTERNAL = "internal";
    private static final String PROVIDER_UNKNOWN = "unknown";
    private static final String PROVIDER_THIRDPARTY = "thirdparty";
    private static final String PROVIDER_IGNORE = "ignore";

    @Override
    public JSONObject enrichWithStats(JSONArray logs) {
        LOG.debug("Build Stats from Logs.");
        JSONObject result = new JSONObject();
        try {
            HashMap<String, Integer> perLevel = new HashMap<>();

            for (int i = 0; i < logs.length(); i++) {
                String level = logs.getJSONObject(i).getString("level");
                if (perLevel.containsKey(level)) {
                    perLevel.put(level, perLevel.get(level) + 1);
                } else {
                    perLevel.put(level, 1);
                }
            }

            for (Map.Entry<String, Integer> entry : perLevel.entrySet()) {
                String key = entry.getKey();
                Integer val = entry.getValue();
                result.put(key, val);
            }

        } catch (JSONException ex) {
            LOG.error("Exception when trying to enrich console logs : " + ex.toString());
        } catch (Exception ex) {
            LOG.error("Exception when trying to enrich console logs.", ex);
        }
        return result;
    }

}
