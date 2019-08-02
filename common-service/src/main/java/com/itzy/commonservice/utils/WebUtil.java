package com.itzy.commonservice.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @Author: ZY
 * @Date: 2019/8/2 15:49
 * @Version 1.0
 */
public class WebUtil {
    /**
     * @return 获得当前请求
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * @return 获取客户端IP
     */
    public static String getClientIP() {
        HttpServletRequest req = getRequest();
        String ip = Optional
                .ofNullable(req.getHeader("X-Real-IP"))
                .orElse(req.getHeader("X-Forwarded-For"));
        return Optional
                .ofNullable(ip)
                .orElse(req.getRemoteAddr()).split(",")[0];
    }

    private static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }
}
