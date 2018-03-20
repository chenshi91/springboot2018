package com.girl.controal;

import com.girl.entity.Boy;
import com.girl.entity.Girl;
import com.girl.entity.User;
import com.girl.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping(value = "/user")
 public class UserControal {

    @Resource
    private Girl girl;
    private Map<Integer,User> userResponse=new ConcurrentHashMap<>();

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Result demo1(User user){
        return Result.success(userResponse.put(user.getId(),user));
    }

    @ResponseBody
    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Result demo2(Integer id) throws ParseException {
        return Result.success(userResponse.get(id));
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public Result demo3(User user){
        User updateUser = userResponse.get(user.getId());
        if (updateUser!=null) {
            userResponse.put(user.getId(),user);
            return Result.success(user);
        }
        return Result.error(updateUser);
    }

    @ResponseBody
    @DeleteMapping(value = "/delete")
    public Result   delete(Integer id){
        User user = userResponse.get(id);
        if (user==null) {
            return Result.error(user);
        }
        userResponse.remove(user);
        return Result.success(user);
    }

    @GetMapping(value = "list")
    @ResponseBody
    public Result list(){
        return Result.success(userResponse);
    }
}
