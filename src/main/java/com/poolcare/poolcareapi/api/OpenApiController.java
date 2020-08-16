package com.poolcare.poolcareapi.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: Unsure how to best configure
@RestController
public class OpenApiController {

    @Value("classpath:/openapi.yaml")
    private Resource resource;

    @RequestMapping(value = "/getApiSpec", produces = { "application/yaml" }, method = RequestMethod.GET)
    public @ResponseBody String getOpenApiSpec() {
        try (final Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}