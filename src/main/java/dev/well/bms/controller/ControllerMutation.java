package dev.well.bms.controller;

import dev.well.bms.service.IServiceMutation;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerMutation {
    IServiceMutation mutationService;
    public ControllerMutation(IServiceMutation mutationService) {
        this.mutationService = mutationService;
    }
}
