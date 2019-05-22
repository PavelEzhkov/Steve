package com.javacore.steve.dbservice.data.query;

public class OperatorEQ {
    public static boolean operate(Object operand1, Object operand2){
        return operand1.equals(operand2);
    }
}

public class OperatorAND{
    public static boolean operate(Boolean operand1, Boolean operand2){
        return operand1 && operand2;
    }
}
