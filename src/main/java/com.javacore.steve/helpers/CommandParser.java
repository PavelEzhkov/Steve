package com.javacore.steve.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum CommandParser {
    INSTANCE;

    private static final String OP_GROUP = "^(SELECT|DELETE)";
    private static final String FLD_GROUP = "([*a-zA-Z, ]+)";
    private static final String SPACE = "([\\s]+)";
    private static final String FROM_GROUP = "(FROM)";
    private static final String TBL_GROUP = "([a-zA-Z]+)";
    private static final String WHERE_GROUP = "(WHERE)";
    private static final String WHERE_VALUE_GROUP = "([=a-zA-Z0-9 ]+)$";




    public static List<String> pars(String query){
        List<String> result = new ArrayList<>();

        Pattern p = Pattern.compile(OP_GROUP + SPACE + FLD_GROUP + SPACE + FROM_GROUP + SPACE + TBL_GROUP);
        Matcher matcher = p.matcher(query);
        if (matcher.find()){
            for (int i = 1, len=  matcher.groupCount(); i<=len ; i++) {
                String s = matcher.group(i).trim();
                if (!s.equals(""))
                    result.add(s);
            }
        }
        Pattern p2 = Pattern.compile(OP_GROUP + SPACE + FLD_GROUP + SPACE + FROM_GROUP + SPACE + TBL_GROUP+SPACE+WHERE_GROUP+SPACE+WHERE_VALUE_GROUP);
        Matcher matcher2 = p2.matcher(query);
        if (matcher2.find()){
            result.clear();
            for (int i = 1, len=  matcher2.groupCount(); i<=len ; i++) {
                String s = matcher2.group(i).trim();
                if (!s.equals(""))
                    result.add(s);
            }
        }

        return result;
    }
}

