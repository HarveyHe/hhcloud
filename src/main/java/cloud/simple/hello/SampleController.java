/**
 * Created by harvey on 16/7/5.
 */
package cloud.simple.hello;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller

public class SampleController  {

    @ResponseBody
    @RequestMapping(value = "/")
    String home() {
        return "Hello World!";
    }



}
