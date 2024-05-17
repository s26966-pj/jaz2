package pl.pjatk.kamlit;

import org.springframework.stereotype.Component;

@Component
public class SecondComponent {
    public SecondComponent(FirstComponent firstComponent ) {
        /*System.out.println("SecondComponent");
        firstComponent.printHello();*/
    }

    public void printHello() {
        System.out.println("Hello from SecondComponent");
    }
}
