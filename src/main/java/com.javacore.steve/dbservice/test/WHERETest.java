package com.javacore.steve.dbservice.test;

import com.javacore.steve.dbservice.data.query.WHEREParser;

public class WHERETest {
    public  static final String VALID_STRING_1 = "WHERE id = 5";
    public static final String VALID_STRING_2 = " WHERE  id = 1  AND name= Tony  ";
    public static final String INVALID_STRING_2 = " WHERE ID = 1 AND";
    public static final String INVALID_STRING_1 = "BAD WHERE";

    static WHEREParser parser = new WHEREParser();

    @Test(enabled = true)
    public static void testValidString(){
        assert parser.validate(VALID_STRING_1): VALID_STRING_1;
    }

    @Test(enabled = true)
    public static void testInvalidString(){
        assert parser.validate(INVALID_STRING_1): INVALID_STRING_1;

    }

    @Test
    public static void testBeautyValid(){
        assert parser.beautify(VALID_STRING_2).equals("WHERE id = 1 AND name= Tony");
    }

    @Test
    public static void testExtractClause(){
        assert parser.extractClause(VALID_STRING_1).equals(" id = 5");
        assert parser.extractClause(VALID_STRING_2).equals("  id = 1  AND name= Tony  ");
    }
}
