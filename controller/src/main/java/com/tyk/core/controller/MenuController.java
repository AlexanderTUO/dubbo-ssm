package com.tyk.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp/")
public class MenuController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("chart_columnar")
    public String chart_columnar() {
        return "chart_columnar";
    }

    @RequestMapping("chart_line")
    public String chart_line() {
        return "chart_line";
    }

    @RequestMapping("chart_pie")
    public String chart_pie() {
        return "chart_pie";
    }
    @RequestMapping("form_basic")
    public String form_basic() {
        return "form_basic";
    }

    @RequestMapping("form_validate")
    public String form_validate() {
        return "form_validate";
    }

    @RequestMapping("table_basic")
    public String table_basic() {
        return "table_basic";
    }
    @RequestMapping("table_complete")
    public String table_complete() {
        return "table_complete";
    }
    @RequestMapping("typography")
    public String typography() {
        return "typography";
    }
}
