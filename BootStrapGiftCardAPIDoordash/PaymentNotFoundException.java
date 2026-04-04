package BootStrapGiftCardAPIDoordash;

public class PaymentNotFoundException extends RuntimeException{
    PaymentNotFoundException(String msg)
    {
        super(msg);
    }
}

