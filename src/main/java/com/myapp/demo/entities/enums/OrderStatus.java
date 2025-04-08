package com.myapp.demo.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERD(4),
    CANCELED(5);

    private int code;

    private OrderStatus (int code){
        this.code = code;
    }

    //retorna o codigo do enum
    public int getCode(){
        return code;
    }

    //retorna o enum correspondente ao codigo
    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values() ){
            if(value.getCode() == code){
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }



}
