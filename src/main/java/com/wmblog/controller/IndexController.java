package com.wmblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangjunling on 2016/8/2.
 */
@Controller
public class IndexController
{
    @RequestMapping("/index")
    public String hello()
    {
        return "index";
    }
}
