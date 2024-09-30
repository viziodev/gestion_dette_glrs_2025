package com.ism.core.factory.yaml.impl;

import com.ism.core.services.YamlService;
import com.ism.core.services.impl.YamlSnakeServiceImp;

public class YamlmplFactory {

    private YamlmplFactory() {

    }

    private static YamlService yamlService;

    public static YamlService createInstance() {
        if (yamlService == null) {
            yamlService = new YamlSnakeServiceImp();
        }
        return yamlService;
    }

}
