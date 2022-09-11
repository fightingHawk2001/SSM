package com.fightinghawk.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 跳转控制器
 * @author fightingHawk Email: fightingHawk2001@outlook.com
 * @date 2022/9/10 16:25
 */
@Controller
public class ToController {

    // 访问首页时直接重定向到查询员工分页信息
    @GetMapping("/")
    public String index() {
        return "redirect:/emp/page/1";
    }
}
