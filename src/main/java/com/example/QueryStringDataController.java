package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.lang.String.format;

/**
 * Created by chaturanu on 2/18/17.
 */

@RestController
public class QueryStringDataController {

    @GetMapping(value = "/individual-example")
    public String getIndividualParams(@RequestParam String filter) {
        return String.format("Filter is: %s", filter);
    }

    @GetMapping("/map-example")
    public String getMapParams(@RequestParam Map querystring) {
        return querystring.toString();
    }

    @GetMapping("/custom-object")
    public String getTasks(CustomObject customObject) {
        return String.format("sort-by is %s; owner is %s", customObject.getName(), customObject.getAge());
    }
}
