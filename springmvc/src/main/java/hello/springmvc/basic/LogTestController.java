package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Cotroller사용하면return값이 뷰 네임 @RestController이면 리턴하는 String 그냥 반환됨 http message body에 스트링값 넣어버림
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        log.trace("trace my log={}"+name);//결과는 나오지만 이렇게 사용하면 안됨...연산이 일어나서 의미없는 리소스를 사용하게되므로

        log.trace("trace log={}",name);
        log.debug("debug log={}",name);//개발서버에는 이정도로 해주고  운영서버는 info 부터 나오게...
        log.info("info log={}",name);//properties설정 안하면 여기부터 error까지 콘솔에 나옴
        log.warn("warn log={}",name);
        log.error("error log={}",name);
        //로그르 찍을때 로그의 레벨을 정할 수 있음
        //어떤 상태의 레벨인지
        return "ok";
    }
}
