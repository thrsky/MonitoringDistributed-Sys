package com.zjut.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by thRShy on 2017/5/14.
 */

@Controller
@RequestMapping("/")
public class index {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }
}
