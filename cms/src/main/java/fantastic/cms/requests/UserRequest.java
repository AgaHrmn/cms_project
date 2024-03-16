package fantastic.cms.requests;
import lombok.Data;
import fantastic.cms.models.Role;

@Data
public class UserRequest {
    String identity;
    String name;
    Role role;
}
