package org.eol.globi.server;

import org.neo4j.kernel.EmbeddedGraphDatabase;
import org.neo4j.kernel.EmbeddedReadOnlyGraphDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class Config {

    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreResourceNotFound(true);
        ppc.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
        return ppc;
    }

    @Bean(destroyMethod = "shutdown")
    public static EmbeddedGraphDatabase graphDb(@Value("${storeDir:target/graph.db.test}") final String storeDir) {
        return new EmbeddedGraphDatabase(storeDir, new HashMap<String, String>() {
            {
                put("read_only", "false");
            }
        });
    }


}
