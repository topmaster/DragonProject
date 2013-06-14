package by.goncharov.dragon.core;

import org.springframework.stereotype.Service;

/**
 * Description of HelloService class
 *
 * @author Mikita Hancharou
 * @created 17.05.13 11:23
 */
@Service
public class HelloService {
    public String sayHello() {
        return "Hello world!";
    }
}
