/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.system;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import java.io.IOException;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author just1689
 * @param <T>
 */
public class SmartServlet<T> extends HttpServlet {

    public final ObjectMapper OBJECT_MAPPER;

    public SmartServlet() {

        if (!Startup.STARTED.get()) {
            Startup.startup();
        }

        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        OBJECT_MAPPER.setPropertyNamingStrategy(new MyPropertyNamingStrategy());
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);

    }

    public String getPostBodyAsString(HttpServletRequest request) throws IOException {
        return request.getReader().lines().collect(Collectors.joining());

    }

    public T convertPostToObject(HttpServletRequest request, Class clazz) throws IOException {
        String body = getPostBodyAsString(request);
        return (T) OBJECT_MAPPER.readValue(body, clazz);

    }

    public String convertObjectToString(Object o) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(o);

    }

    private static class MyPropertyNamingStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {

        @Override
        public String translate(String string) {
            return string.toLowerCase();
        }
    }

}
