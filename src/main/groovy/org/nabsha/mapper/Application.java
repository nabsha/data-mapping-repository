
package org.nabsha.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.nabsha.mapper.repositories.DomainModelRepository;
import org.nabsha.mapper.repositories.MappingRuleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.io.File;
import java.util.List;

@SpringBootApplication(scanBasePackages = "org.nabsha.mapper")
@EnableNeo4jRepositories("org.nabsha.mapper.repositories")
public class Application {

	private final static Logger log = LoggerFactory.getLogger(Application.class);


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
