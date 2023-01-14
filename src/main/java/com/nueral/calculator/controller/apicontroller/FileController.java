package com.nueral.calculator.controller.apicontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/log")
    @ResponseBody
    public Logger main() {
        logger.trace("trace Log");
        logger.debug("debug Log");
        logger.info("info Log");
        logger.warn("warn Log");
        logger.error("error Log");

        return null;
    }
}