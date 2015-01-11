/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanclus.deltaspike.observer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author dphillips
 */
@ApplicationScoped
@Slf4j
public class DependencyProducer {
    
    private Configuration config;

    public void observe(@Observes Configuration config) {
        LOG.info("Observed an event with Configuration object");
        this.config = config;
    }
}
