package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*
    *  1./hello 요청이 들어오면 매핑
    *  2.GetMapping -> http Get 메소드
    * */
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello";
    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-templete.html";
    }

    //대신에 HTTP의 BODY에 문자 내용을 직접 반환(HTML BODY TAG를 말하는 것이 아님)
    @GetMapping("hello-string")
    @ResponseBody //@ResponseBody 를 사용하면 뷰 리졸버( viewResolver )를 사용하지 않음
    public String helloString(@RequestParam(name="name", required = false) String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody //@ResponseBody 를 사용하면 뷰 리졸버( viewResolver )를 사용하지 않음
    public Hello helloApi(@RequestParam(name="name", required = false) String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }
}
