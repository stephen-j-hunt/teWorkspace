package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class MainWorkflow {

    private ConsoleService consoleService;
    private Inventory inventory;
    private final Logger logger;
    private PurchaseWorkflow purchaseWorkflow;

    public MainWorkflow(PurchaseWorkflow purchaseWorkflow,
                        ConsoleService consoleService,
                        Inventory inventory,
                        Logger logger) {
        this.purchaseWorkflow = purchaseWorkflow;
        this.consoleService = consoleService;
        this.inventory = inventory;
        this.logger = logger;
        System.out.println("In MainWorflow constructor");
        //        this.consoleService = new ConsoleService();
        //        this.inventory = new Inventory();
    }

    public void run() {
        this.logger.log("starting vending machine");
    }

}
