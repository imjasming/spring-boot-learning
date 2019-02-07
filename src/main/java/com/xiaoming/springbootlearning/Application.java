package com.xiaoming.springbootlearning;

import com.xiaoming.springbootlearning.config.StorageProperties;
import com.xiaoming.springbootlearning.domain.Quote;
import com.xiaoming.springbootlearning.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application /*implements CommandLineRunner*/{
    public static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // #START consume rest web service
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            LOGGER.info(quote.toString());
        };
    }
    // #END consume rest web service

    // #START Accessing Relational Data using JDBC with Spring

    /*@Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("Creating tables");

        //maybe we should use H2 which is an in-memory relational database engine
        jdbcTemplate.execute("DROP TABLE customer IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE  customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Long").stream()
                .map(name->name.split(" "))
                .collect(Collectors.toList());

        //use a java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> LOGGER.info(String.format("inserting customer record for %s %s", name[0], name[1])));

        //use jdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

        LOGGER.info("Querying for customer records where first_name='Josh':");
        jdbcTemplate.query("SELECT id,first_name,last_name FROM customers WHERE first_name=?", new Object[]{"Josh"},
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
    .forEach(customer -> LOGGER.info(customer.toString()));
    }*/
    // #END Accessing Relational Data using JDBC with Spring

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            storageService.init();
        };
    }
}

