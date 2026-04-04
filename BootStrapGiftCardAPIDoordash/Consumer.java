package BootStrapGiftCardAPIDoordash;

public class Consumer {
    private String name;
    private String consumerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Consumer(String name, String consumerId)
    {
        this.consumerId=consumerId;
        this.name=name;
    }
}

