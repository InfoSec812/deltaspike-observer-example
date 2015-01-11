/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zanclus.deltaspike.observer;

import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.cdise.api.ContextControl;

/**
 *
 * @author dphillips
 */
@Slf4j
public class Main {
    
    public static void main(String[] args) {
        LOG.info("Argument list is "+args.length+" items long");
        Configuration config = new Configuration();
        config.setArgs(args);
        
        CdiContainer container = CdiContainerLoader.getCdiContainer();
        container.boot();
        ContextControl ctxControl = container.getContextControl();
        ctxControl.startContexts();
        
        LOG.info("Sending event");
        container.getBeanManager().fireEvent(config);
        
        try {
            LOG.info("Sleeping for 50 seconds");
            Thread.sleep(50000);
        } catch (InterruptedException ex) {
            LOG.error("Thread sleep error.");
        }
    }
}
