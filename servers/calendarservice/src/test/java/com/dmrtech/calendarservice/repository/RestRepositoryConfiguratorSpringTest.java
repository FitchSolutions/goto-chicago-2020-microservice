package com.dmrtech.calendarservice.repository;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


/**
 * Parasoft Jtest UTA: Test class for RestRepositoryConfigurator
 *
 * @author dferguson
 * @see RestRepositoryConfigurator
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class RestRepositoryConfiguratorSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    RestRepositoryConfigurator component;

    /**
     * Parasoft Jtest UTA: Test for configureRepositoryRestConfiguration(RepositoryRestConfiguration)
     *
     * @author dferguson
     * @see RestRepositoryConfigurator#configureRepositoryRestConfiguration(RepositoryRestConfiguration)
     */
    @Test(timeout = 1000)
    public void testConfigureRepositoryRestConfiguration() throws Throwable {
        // When
        RepositoryRestConfiguration config = mockRepositoryRestConfiguration4();
        component.configureRepositoryRestConfiguration(config);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RepositoryRestConfiguration
     */
    private static RepositoryRestConfiguration mockRepositoryRestConfiguration() throws Throwable {
        RepositoryRestConfiguration exposeIdsForResult3 = mock(RepositoryRestConfiguration.class);
        RepositoryRestConfiguration exposeIdsForResult4 = mock(RepositoryRestConfiguration.class);
        when(exposeIdsForResult3.exposeIdsFor((Class[]) any())).thenReturn(exposeIdsForResult4);
        return exposeIdsForResult3;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RepositoryRestConfiguration
     */
    private static RepositoryRestConfiguration mockRepositoryRestConfiguration2() throws Throwable {
        RepositoryRestConfiguration exposeIdsForResult2 = mock(RepositoryRestConfiguration.class);
        RepositoryRestConfiguration exposeIdsForResult3 = mockRepositoryRestConfiguration();
        when(exposeIdsForResult2.exposeIdsFor((Class[]) any())).thenReturn(exposeIdsForResult3);
        return exposeIdsForResult2;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RepositoryRestConfiguration
     */
    private static RepositoryRestConfiguration mockRepositoryRestConfiguration3() throws Throwable {
        RepositoryRestConfiguration exposeIdsForResult = mock(RepositoryRestConfiguration.class);
        RepositoryRestConfiguration exposeIdsForResult2 = mockRepositoryRestConfiguration2();
        when(exposeIdsForResult.exposeIdsFor((Class[]) any())).thenReturn(exposeIdsForResult2);
        return exposeIdsForResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of RepositoryRestConfiguration
     */
    private static RepositoryRestConfiguration mockRepositoryRestConfiguration4() throws Throwable {
        RepositoryRestConfiguration config = mock(RepositoryRestConfiguration.class);
        RepositoryRestConfiguration exposeIdsForResult = mockRepositoryRestConfiguration3();
        when(config.exposeIdsFor((Class[]) any())).thenReturn(exposeIdsForResult);
        return config;
    }
}