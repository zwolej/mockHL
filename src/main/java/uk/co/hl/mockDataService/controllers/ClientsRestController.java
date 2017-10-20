package uk.co.hl.mockDataService.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("clients")
public class ClientsRestController {

    private static final Map<String, String> PORTFOLIOS = new HashMap<>();

    static {
        PORTFOLIOS.put("clineCode1", "one");
        PORTFOLIOS.put("clineCode2", "two");
    }

    private static final Map<String, String> PORTFOLIOS_PRODUCTS = new HashMap<>();

    static {
        PORTFOLIOS_PRODUCTS.put("clineCode1", "second product");
        PORTFOLIOS_PRODUCTS.put("clineCode2", "two rpoduct");
    }

    private static final Map<String, String> ALERTS = new HashMap<>();

    static {
        ALERTS.put("clineCode1", "second alert");
        ALERTS.put("clineCode2", "two alert");
    }

    @GetMapping("{clientNo}/portoflio")
    public String getPortoflio(@PathVariable String clientNo) {
        return ClientsRestController.PORTFOLIOS.get(clientNo);
    }

    @GetMapping("{clientNo}/portoflio/{product_no}")
    public String getPortoflioProducts(@PathVariable String clientNo, @PathVariable String productNo) {
        return ClientsRestController.PORTFOLIOS_PRODUCTS.get(clientNo);
    }

    @GetMapping("{clientNo}/alerts")
    public String getAlerts(@PathVariable String clientNo) {
        return ClientsRestController.PORTFOLIOS_PRODUCTS.get(clientNo);
    }

}
