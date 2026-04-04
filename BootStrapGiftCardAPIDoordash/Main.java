package BootStrapGiftCardAPIDoordash;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Map<String,Consumer>m=new HashMap<>();
        m.put("user123", new Consumer("Saad", "S"));
        ConsumerService consumerService=new ConsumerService(m);

        Map<String,Address>m1=new HashMap<>();
        m1.put("user1123", new Address("123 Main St", "Anytown", "12345"));
        AddressService addressService=new AddressService(m1);

        Map<String,PaymentInfo>m2=new HashMap<>();
        m2.put("user1123", new PaymentInfo("Credit Card", 100));
        PaymentService paymentService=new PaymentService(m2);

        Solver solver= new Solver(consumerService, paymentService, addressService);
        Optional<UserProfile>op=solver.getUserProfile("user123");
        if (op.isPresent()) {
            UserProfile p = op.get();
            System.out.println(p.name + "@" + p.address + "*" + p.paymentMethod);
        } else {
            System.out.println("User not found");
        }
    }
}
