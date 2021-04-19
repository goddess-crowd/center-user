package com.goddess.center.user.interfaces.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * swagger页面
 * @author 失败女神
 * @email: 18733123202@163.com
 * @date 2021/4/7 下午12:02
 * @Copyright © 女神帮
 */
@Controller
@ApiIgnore
class HomeController {
    @RequestMapping(value = {"/", "/swagger"})
    public String index() {
        return "redirect:/swagger-ui/";
    }
}