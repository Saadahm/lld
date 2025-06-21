package LinkedinSystemDesign;

import java.util.UUID;

public class Skill {
    private String id;
    private String description;

    public Skill(String description) {
        this.id= UUID.randomUUID().toString();
        this.description = description;
    }
}
