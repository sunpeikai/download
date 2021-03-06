package com.sandman.download.controller;

import com.sandman.download.entity.common.BaseDto;
import com.sandman.download.entity.user.ValidateCode;
import com.sandman.download.service.user.ValidateCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sunpeikai on 2018/5/4.
 */
@RestController
@RequestMapping("/api/sandman/v1/validateCode")
public class ValidateCodeController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private ValidateCodeService validateCodeService;
    /**
     * POST:发送验证码
     */
    @PostMapping("/sendValidateCode")
    public BaseDto sendValidateCode(@RequestBody ValidateCode validateCode){
        log.info("send a code to {}",validateCode.getContact());
        if(validateCode.getContact()==null || "".equals(validateCode.getContact())){
            return new BaseDto(413,"请先填写联系方式");
        }
        return validateCodeService.sendValidateCode(validateCode);
    }
    @GetMapping("/getAllCodeInfo")
    public BaseDto getAllCodeInfo(){
        return validateCodeService.getAllCodeInfo();
    }
}
