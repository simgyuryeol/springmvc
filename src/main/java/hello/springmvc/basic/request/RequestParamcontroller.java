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
public class RequestParamcontroller {

    @RequestMapping("/request-param-v1")
    public void requesstParamV1(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={} age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody //restcontroller와 같은 효과, 리턴 값을 http 응답메시지에 박혀서 바로 전송함
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={} age={}",memberName,memberAge);

        return "ok";
    }


    @ResponseBody //restcontroller와 같은 효과, 리턴 값을 http 응답메시지에 박혀서 바로 전송함
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, //파라미터 이름과 같으면 생략 가능
            @RequestParam int age
    ){
        log.info("username={} age={}",username,age);

        return "ok";
    }

    @ResponseBody //restcontroller와 같은 효과, 리턴 값을 http 응답메시지에 박혀서 바로 전송함
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,int age){//요청 파라미터 이름과 같으면 생략 가능
        log.info("username={} age={}",username,age);

        return "ok";
    }


    @ResponseBody //restcontroller와 같은 효과, 리턴 값을 http 응답메시지에 박혀서 바로 전송함
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = false) String username,
            @RequestParam (required = true) int age){//required true면 질의문에 꼭 있어야됨 없으면 오류남
        log.info("username={} age={}",username,age);

        return "ok";
    }

    @ResponseBody //restcontroller와 같은 효과, 리턴 값을 http 응답메시지에 박혀서 바로 전송함
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = false,defaultValue = "sim") String username,
            @RequestParam (required = true,defaultValue = "30") int age){//값이 없으면 디폴트 값으로 대체
        log.info("username={} age={}",username,age);

        return "ok";
    }


    @ResponseBody //restcontroller와 같은 효과, 리턴 값을 http 응답메시지에 박혀서 바로 전송함
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Integer> paramMap){//값이 없으면 디폴트 값으로 대체
        log.info("username={} age={}",paramMap.get("username"),paramMap.get("age"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){


        log.info("username={} age={}",helloData.getUsername(),helloData.getAge());
        log.info("hellodata={}",helloData);

        return "ok";

    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){ //생략 가능


        log.info("username={} age={}",helloData.getUsername(),helloData.getAge());
        log.info("hellodata={}",helloData);

        return "ok";

    }
}
