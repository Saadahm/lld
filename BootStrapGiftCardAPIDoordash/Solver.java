package BootStrapGiftCardAPIDoordash;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solver {
    private Logger logger=Logger.getLogger(Solver.class.getName());
    private ConsumerService consumerService;
    private PaymentService paymentService;
    private AddressService addressService;
    private static final Logger log=Logger.getLogger(Solver.class.getName());
    public Solver(ConsumerService consumerService, PaymentService paymentService, AddressService addressService){
        this.consumerService=consumerService;
        this.addressService=addressService;
        this.paymentService=paymentService;
    }
    public Optional<UserProfile>getUserProfile(String userId){
        Consumer consumer;
        try{
            consumer=consumerService.getUserProfile(userId);
        }
        catch (ConsumerNotFoundException e)
        {
            return Optional.empty();
        }

        String paymentMethod="";
        Integer giftCardBalance=0;
        try{
            PaymentInfo paymentInfo=paymentService.getPaymentInfo(userId);
            if (paymentInfo != null) {
                if (paymentInfo.getDefaultPaymentMethod() != null)
                    paymentMethod = paymentInfo.getDefaultPaymentMethod();

                if (paymentInfo.getGiftCardBalance() != null)
                    giftCardBalance = paymentInfo.getGiftCardBalance();
            }
        }
        catch (PaymentNotFoundException p){
            logger.log(Level.WARNING,"Payment not found");
        }

        String address="";
        try{
            Address address1=addressService.getAddress(userId);
            if(address1!=null)
                address=address1.toString();
        }
        catch (AddressNotFoundException e)
        {
            logger.log(Level.WARNING, "Address not found");
        }
        return Optional.of(new UserProfile(consumer.getName(), consumer.getConsumerId(), paymentMethod,address, giftCardBalance));
    }
}
