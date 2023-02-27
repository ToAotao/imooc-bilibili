package com.imooc.bilibili.api;

import com.imooc.bilibil.service.UserService;
import com.imooc.bilibil.service.util.RSAUtil;
import com.imooc.bilibili.domain.JsonResponse;
import com.imooc.bilibili.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    @Autowired
    private UserService userService;
    @GetMapping("/rsa-pks")
    public JsonResponse<String> getRsaPublicKey(){
        return new JsonResponse<>(RSAUtil.getPublicKeyStr());
    }
    @PostMapping("/users")
    public JsonResponse<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return JsonResponse.success();
    }

}
