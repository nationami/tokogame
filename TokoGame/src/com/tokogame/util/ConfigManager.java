/*
 * File: com.ebio.util.ConfigManager.java
 *
 * Copyright (c) 2010 PT. XYBASE INDONESIA,
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information
 * of PT. XYBASE INDONESIA ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered
 * into with PT. XYBASE INDONESIA.
 *
 * Project:	eBiosekuriti
 * Created: Dec 14, 2010 2:18:45 PM
 */

package com.tokogame.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * <p>This class represent a ConfigManager</p>
 *
 * <p>Revision Information:<br/><i>
 * $Date: 2010-12-14 15:06:08 +0700 (Tue, 14 Dec 2010) $<br/>
 * $Revision: 410 $<br/>
 * $LastChangedBy: sabri $<br/>
 * </i></p>
 *
 * @author Sabri Rusda
 *
 */
public class ConfigManager {
	
private static PropertiesConfiguration config = null;
    
    static {
        try {
            config = new PropertiesConfiguration();
            config.setBasePath("config");
            config.setFileName("config/config.properties");
            config.load();
        } catch (ConfigurationException e) {
            throw new RuntimeException("Please configure config.properties properly", e);
        }
    }
    
    /**
     * prevent to instantiate.
     */
    private ConfigManager(){
    }
    
    public static Configuration getConfiguration(){
        return config;
    }
}
