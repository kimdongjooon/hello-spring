// 템플릿 페이지 동작 법.

package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 웹에서 hello를 받으면 Controller에서 같은 문자 매칭. 그리고 아래 내용 실행.
    public String hello(Model model){
        model.addAttribute("data", "hello spring!!!");
        return "hello"; // viewResolver가 resources:template/hello.html로 보내줌,

    }

    @GetMapping("hello-mvc")  // 외부에서 파라미터 받기.
    // name이란 변수에 웹에서 값을 받도록 설정함.
    // 그리고 받은 name변수는 return한 hello-template.html로 입력받은 변수를 사용할 수 있도록 속성을 추가해줌.
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //HttpMessageConverter가 리턴 타입이 String인 경우 String형태로 바로 리턴.
    // 여기서 특징은 @ResponseBody가 있으면 컨트롤러에서 viewResolver를 실행안시킴. 즉 html 템플릿 처리를 안함.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // hello 입력한데이터
    }

    @GetMapping("hello-api")
    @ResponseBody // HttpMessageConverter가 리턴 타입이 객체인 경우 JSON형태로 리턴.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // { 'name' : '입력한 데이터'}
    }

    static class Hello{
        private  String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
