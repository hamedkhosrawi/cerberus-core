/* Cerberus Copyright (C) 2013 - 2017 cerberustesting
DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.

This file is part of Cerberus.

Cerberus is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Cerberus is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cerberus.crud.factory.impl;

import java.sql.Timestamp;
import org.cerberus.crud.entity.Scheduler;
import org.cerberus.crud.factory.IFactoryScheduler;

/**
 *
 * @author cdelage
 */

public class FactoryScheduler implements IFactoryScheduler {

    @Override
    public Scheduler create(Integer ID, String type, String name, String cronDefinition, String lastExecution, String active, String UsrCreated, String DateCreated, String UsrModif, String DateModif) {
        Scheduler scheduler = new Scheduler();
        scheduler.setID(ID);
        scheduler.setType(type);
        scheduler.setName(name);
        scheduler.setCronDefinition(cronDefinition);
        scheduler.setLastExecution(lastExecution);
        scheduler.setActive(active);
        scheduler.setUsrCreated(UsrCreated);
        scheduler.setDateCreated(DateCreated);
        scheduler.setUsrModif(UsrModif);
        scheduler.setDateModif(DateModif);

        return scheduler;
    }

}
