package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController //controller로 하면 뷰이름이 반환 되는데 restcontroller는 해당 스트링 값이 바로 반환된다.
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass()); @Slf4j를 사용하면 lombok이 자동으로 코드를 생성해줌

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log={}",name);
        log.debug("debug log={}",name); //디버그 단계
        log.info("info log={}",name); //중요한 정보
        log.warn("warn log={}",name); // 경고
        log.error("error log={}",name); //에러

        return "ok";

    }
}
