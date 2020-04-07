package com.likesea.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CommUtils {
    static private final Logger logger = LoggerFactory.getLogger(CommUtils.class);

    public static boolean isBlank(Object ob){
        if (ob == null)
            return true;
        if (ob instanceof String)
            return "".equals(ob);
        if (ob instanceof Integer)
            return 0 == (Integer)ob;
        if (ob instanceof Long)
            return 0 == (Long)ob;
        return false;
    }

    public static String null2String(Object str){
        if (str == null)
            return "";
        return str.toString();
    }

    public static boolean isEmpty(Object str){
        if (str == null)
            return true;
        if (str instanceof String)
            return "".equals(str);
        return false;
    }

    public static int null2Int(Integer n){
        if (n == null)
            return 0;
        return n;
    }

    public static int null2Int(String str){
        if (str == null)
            return 0;
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            logger.error("value:" + str);
        }
        return 0;
    }

    public static short null2Short(Short n){
        if (n == null)
            return 0;
        return n;
    }

    public static long null2Long(Long n){
        if (n == null)
            return 0;
        return n;
    }

    public static long null2Long(String str){
        if (str == null)
            return 0;
        try {
            return Long.parseLong(str);
        }catch (Exception e){
            logger.error("value:" + str);
        }
        return 0;
    }

    public static int param2Int(Map params, String skey){
        if (params == null || skey == null)
            return 0;
        try {
            if (params.containsKey(skey)){
                Object obj = params.get(skey);
                if (obj instanceof String){
                    params.remove(skey);
                    return Integer.parseInt((String) obj);
                }else if (obj instanceof Integer){
                    params.remove(skey);
                    return (Integer)obj;
                }else if (obj instanceof Long){
                    params.remove(skey);
                    return (Integer)obj;
                }
            }
        }catch (Exception e){
            logger.error("query key:" + skey);
        }
        return 0;
    }
}
