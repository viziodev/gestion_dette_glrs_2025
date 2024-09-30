package com.ism.core.services;

import java.util.*;

public interface YamlService {
    Map<String, Object> yamlToMap();

    Map<String, Object> yamlToMap(String path);

   
}
