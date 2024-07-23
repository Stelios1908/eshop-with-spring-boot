package com.example.eshop.exceptions.item.item_allready_exist;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class ItemAllreadyExistAttribute extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = new HashMap<>(super.getErrorAttributes(webRequest, options));
        errorAttributes.put("timestamp", LocalDateTime.now());
        errorAttributes.put("path", webRequest.getDescription(false)); // Χρήση getDescription για την απόκτηση του path
        return errorAttributes;
    }
}
