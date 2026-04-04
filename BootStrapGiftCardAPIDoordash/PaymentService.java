package BootStrapGiftCardAPIDoordash;

import java.util.Map;

public class PaymentService {
    private Map<String,PaymentInfo>byUserId;
    public PaymentService(Map<String,PaymentInfo>byUserId)
    {
        this.byUserId=byUserId;
    }
    public PaymentInfo getPaymentInfo(String id)
    {
        if(byUserId.get(id)!=null)
            return byUserId.get(id);
        throw new PaymentNotFoundException("payment not found");
    }
}
