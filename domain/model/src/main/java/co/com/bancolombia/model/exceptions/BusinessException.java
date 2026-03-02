package co.com.bancolombia.model.exceptions;

import co.com.bancolombia.model.exceptions.message.BusinessErrorMessge;

public class BusinessException extends RuntimeException{

    private final BusinessErrorMessge businessErrorMessge;

    public BusinessException(BusinessErrorMessge businessErrorMessge) {
        super(businessErrorMessge.getMessage());
        this.businessErrorMessge = businessErrorMessge;
    }
}
