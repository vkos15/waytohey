package com.waytohey.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/prod.properties"})
public interface ProjectConfig extends Config {
    String login_correct();

    String password_correct();

    String remoteDriverUrl();


}
