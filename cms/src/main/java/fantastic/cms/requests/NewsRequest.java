package fantastic.cms.requests;

import java.util.Set;
import lombok.Data;

import fantastic.cms.models.Category;
import fantastic.cms.models.Tag;

@Data
public class NewsRequest {
    String title;
    String content;


    Set<Category> categories;
    Set<Tag> tags;
}