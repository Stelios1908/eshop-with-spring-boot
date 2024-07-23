package com.example.eshop.exceptions.item.item_not_found;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class ItemNotFoundAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = new HashMap<>(super.getErrorAttributes(webRequest, options));
        errorAttributes.put("timestamp", LocalDateTime.now());
        errorAttributes.put("path", webRequest.getContextPath());
        return errorAttributes;
    }
}
