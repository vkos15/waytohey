package com.waytohey.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/prod.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("valentina71551")
    String login_correct();

    @DefaultValue("r347b7")
    String password_correct();

    String remoteDriverUrl();

    @DefaultValue("dfg@ml.rootkid.ru")
    String exist_email();


}
