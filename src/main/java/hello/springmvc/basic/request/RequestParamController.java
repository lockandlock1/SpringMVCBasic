package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // @RestController 와 동일한 효과
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {
        log.info("requestParamV2 username={}, age={}", memberName, memberAge);

        // @Controller 이기에 뷰를 찾게 된다
        // @RestController 를 사용해도 됨
        return "ok";
    }

    @ResponseBody // @RestController 와 동일한 효과
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("requestParamV3 username={}, age={}", username, age);

        // @Controller 이기에 뷰를 찾게 된다
        // @RestController 를 사용해도 됨
        return "ok";
    }

    @ResponseBody // @RestController 와 동일한 효과
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("requestParamV4 username={}, age={}", username, age);

        // @Controller 이기에 뷰를 찾게 된다
        // @RestController 를 사용해도 됨
        return "ok";
    }


    @ResponseBody // @RestController 와 동일한 효과
    @RequestMapping("/request-param-v5")
    public String requestParamV5(@RequestParam String username,
                                 @RequestParam int age){
        log.info("requestParamV5 username={}, age={}", username, age);

        // @Controller 이기에 뷰를 찾게 된다
        return "ok";
    }

    @ResponseBody // @RestController 와 동일한 효과
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = true, defaultValue = "-1") int age){
        log.info("default username={}, age={}", username, age);

        // @Controller 이기에 뷰를 찾게 된다
        return "ok";
    }

    @ResponseBody // @RestController 와 동일한 효과
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("map username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        // @Controller 이기에 뷰를 찾게 된다
        return "ok";
    }

//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//
//        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
//
//        return "ok";
//    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {

        log.info("model v2 username={}, age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }
}
