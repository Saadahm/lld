package BootStrapGiftCardAPIDoordash;

public class ConsumerNotFoundException extends RuntimeException{
    ConsumerNotFoundException(String msg)
    {
        super(msg);
    }
}
