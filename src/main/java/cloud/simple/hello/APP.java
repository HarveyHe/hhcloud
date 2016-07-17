/**
 * Created by harvey on 16/7/5.
 */
package cloud.simple.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class APP {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(APP.class, "--server.port=8080");
    }

}
