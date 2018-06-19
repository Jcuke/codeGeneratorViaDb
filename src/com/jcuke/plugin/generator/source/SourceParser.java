package com.jcuke.plugin.generator.source;

import com.jcuke.plugin.entity.Table;
import com.jcuke.plugin.generator.config.GeneratorConfig;

/**
 * 源码解析器
 */
public interface SourceParser {

  String parse(GeneratorConfig config, Table table);
}
