package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PurchaseWorkflow {
    private final ConsoleService consoleService;
    private final Inventory inventory;

    public PurchaseWorkflow(ConsoleService consoleService, Inventory inventory) {
        this.consoleService = consoleService;
        this.inventory = inventory;
        System.out.println("in PurchaseWorkflow constructor");
    }
}
