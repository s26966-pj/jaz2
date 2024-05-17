package pl.pjatk.kamlit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@Component
public class FirstComponent {

    public FirstComponent(@Value("${my.custom.property:default value}") String myCustomProperty) {
        System.out.println(myCustomProperty);
    }

    public void printHello() {
        System.out.println("Hello from FirstComponent");
    }
}
