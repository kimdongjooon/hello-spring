// 템플릿 페이지 동작 법.

package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") // 웹에서 hello를 받으면 및 함수를 실행.
    public String hello(Model model){
        model.addAttribute("data", "hello spring!!!");
        return "hello"; // resources:template/hello.html에 처리.

    }

    @GetMapping("hello-mvc")  // 외부에서 파라미터 받기.
    // name이란 변수에 웹에서 값을 받도록 설정함.
    // 그리고 받은 name변수는 return한 hello-template.html로 입력받은 변수를 사용할 수 있도로 속성을 추가해줌.
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
}
