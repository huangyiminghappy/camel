/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.camel.spring.boot.actuate.endpoint;

import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = {
        CamelAutoConfiguration.class,
        CamelHealthCheckEndpointAutoConfiguration.class
    },
    properties = {
        "endpoints.enabled = false"
    }
)
public class CamelEndpointsGloballyDisabledTest {
    @Autowired(required = false)
    private CamelHealthCheckEndpoint healthCheckEndpoint;

    @Autowired(required = false)
    private CamelRouteControllerEndpoint routeControllerEndpoint;

    @Autowired(required = false)
    private CamelRouteControllerMvcEndpoint routeControllerMvcEndpoint;

    @Autowired(required = false)
    private CamelRoutesEndpoint routesEndpoint;

    @Autowired(required = false)
    private CamelRoutesMvcEndpoint routesMvcEndpoint;

    @Test
    public void testHealthCheckEndpointNotPresent() throws Exception {
        Assert.assertNull(healthCheckEndpoint);
        Assert.assertNull(routeControllerEndpoint);
        Assert.assertNull(routeControllerMvcEndpoint);
        Assert.assertNull(routesEndpoint);
        Assert.assertNull(routesMvcEndpoint);
    }
}
