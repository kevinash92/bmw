package com.eshopping.bmw.framework.dao;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.eshopping.bmw.framework.config.TestConfig;

import jakarta.transaction.Transactional;

@Transactional
@ActiveProfiles("test")
@DataJpaTest(showSql = true)
@ContextConfiguration(classes = TestConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class AbstractBmwIntegrationTest {

}
