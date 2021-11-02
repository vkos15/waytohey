package com.waytohey.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

    public static ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());


}
