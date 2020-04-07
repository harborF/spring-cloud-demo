package com.likesea.bean;

import java.util.HashMap;
import java.util.Map;

import static com.likesea.bean.Constants.*;

public class RespEntity {

    private int code;
    private String msg;
    private Object data;

    private static Map<Integer, String> codeH = new HashMap();
    static {
        codeH.put(ERR_PARAM, "参数错误");
        codeH.put(ERR_TYPE, "类型错误");
        codeH.put(ERR_REQUEST, "非法请求");
        codeH.put(ERR_DUPLICATE, "数据重复错误");
        codeH.put(ERR_DB, "数据库错误");
    }

    public RespEntity(){
        this.code = RespCode.SUCCESS.code;
        this.msg = RespCode.SUCCESS.msg;
    }

    RespEntity(RespCode respCode) {
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

    public RespEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RespEntity(RespCode respCode, Object data) {
        this(respCode);
        this.data = data;
    }

    public static RespEntity success(){
        return new RespEntity(RespCode.SUCCESS, null);
    }

    public static RespEntity success(Object data){
        return new RespEntity(RespCode.SUCCESS, data);
    }

    public static RespEntity error(int code, String msg){
        return new RespEntity(code, msg);
    }

    public static RespEntity error(int code){
        if (codeH.containsKey(code)){
            return new RespEntity(code, codeH.get(code));
        }
        return new RespEntity(code, "未知错误");
    }

    public enum RespCode {

        SUCCESS(0, "请求成功"),
        WARN(-1, "网络异常，请稍后重试");

        private int code;
        private String msg;

        RespCode(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }
        public String getMsg() {
            return msg;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
