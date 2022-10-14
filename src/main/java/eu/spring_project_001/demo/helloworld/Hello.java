package eu.spring_project_001.demo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping("/world/{id}")
    public String sayHello(@PathVariable double id)
    {
        return "hello world " + id;
    }

    @GetMapping("/java")
    public String sayJava()
    {
        return "hello fucking Java";
    }
}
