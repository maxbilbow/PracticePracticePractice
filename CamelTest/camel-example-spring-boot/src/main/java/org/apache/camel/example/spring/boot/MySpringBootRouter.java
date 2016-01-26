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
package org.apache.camel.example.spring.boot;

import org.apache.camel.Predicate;
import org.apache.camel.example.spring.boot.processor.FrameworkProcessor;
import org.apache.camel.example.spring.boot.processor.IsItABird;
import org.apache.camel.example.spring.boot.processor.SayItAintSo;
import org.apache.camel.example.spring.boot.processor.SayItIsABird;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

@SpringBootApplication
public class MySpringBootRouter extends FatJarRouter {

    @Resource
    IsItABird mIsItABird;

    @Resource
    SayItIsABird mSayItIsABird;

    @Resource
    private SayItAintSo mSayItAintSo;

    @Override
    public void configure() {

        from("timer:trigger")
                .transform().simple("ref:myBean")
                .to("log:out");

        from("timer:bird")
                .bean(mIsItABird)
                .choice()
                .when(resultIsPositive)
                .bean(mSayItIsABird)
                .otherwise()
                .bean(mSayItAintSo)
                .end();
    }

    @Bean
    String myBean() {
        return "I'm Spring bean!";
    }

    public final Predicate resultIsPositive= (exchange) ->
        exchange.getIn().getBody(FrameworkProcessor.class).isPositive();

    public final Predicate resultIsNegative= (exchange) ->
        !exchange.getIn().getBody(FrameworkProcessor.class).isPositive();

}
