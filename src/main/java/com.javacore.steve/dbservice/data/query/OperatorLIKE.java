package com.javacore.steve.dbservice.data.query;

import com.javacore.steve.dbservice.data.query.BooleanOperator;

public class OperatorLIKE implements BooleanOperator {
    @Override
    public boolean operate(Object... operands) {
        if (operands[0] instanceof String && operands[1] instanceof String) {
            String op1 = (String)(operands[0]);
            String op2 = (String)(operands[1]);
            return op1.contains(op2);
        }
        throw new RuntimeException("INVALID OPERANDS: " + operands);
    }
}
