package com.example.mockKolodyazhnyy.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data

public class ResponseDTO {
    private String rqUID;
    private String clientId;
    private String account;
    private String currency;
    private BigDecimal balance;
    private BigDecimal maxLimit;

    public ResponseDTO(RequestDTO requestDTO) {
        switch (requestDTO.getClientId().charAt(0)) {
            case '8': {
                this.maxLimit = new BigDecimal(2000.00);
                this.currency = "USD";
                break;
            }
            case '9': {
                this.maxLimit = new BigDecimal(1000.00);
                this.currency = "EUR";
                break;
            }
            default:
                this.maxLimit = new BigDecimal(10000.00);
                this.currency = "RUB";
        }
        this.rqUID = requestDTO.getRqUID();
        this.clientId = requestDTO.getClientId();
        this.account = requestDTO.getAccount();
        this.balance = maxLimit.multiply(BigDecimal.valueOf(Math.random())).setScale(2, RoundingMode.HALF_UP);
    }
}
