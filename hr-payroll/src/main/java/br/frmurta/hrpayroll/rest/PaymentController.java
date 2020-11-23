package br.frmurta.hrpayroll.rest;

import br.frmurta.hrpayroll.entities.Payment;
import br.frmurta.hrpayroll.services.PaymentService;
import br.frmurta.hrpayroll.services.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/{workerId}/days/{days}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Payment> getPayment(@PathVariable(value = "workerId") Long workerId,
                                              @PathVariable(value = "days") Integer days) {
        return ResponseEntity.ok(this.paymentService.getPayment(workerId, days));
    }
}
