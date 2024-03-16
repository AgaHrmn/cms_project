package fantastic.cms.services;

import fantastic.cms.repositories.NewsRepository;
import fantastic.cms.requests.NewsRequest;
import org.springframework.stereotype.Service;
import fantastic.cms.models.News;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News update(String id, NewsRequest newsRequest) {
        final News news = this.newsRepository.findOne(id);
        news.setTitle(newsRequest.getTitle());
        news.setContent(newsRequest.getContent());
        news.setTags(newsRequest.getTags());
        news.setCategories(newsRequest.getCategories());
        return this.newsRepository.save(news);
    }

    public News create(NewsRequest newsRequest) {
        News news = new News();
        news.setTitle(newsRequest.getTitle());
        news.setContent(newsRequest.getContent());
        news.setTags(newsRequest.getTags());
        news.setCategories(newsRequest.getCategories());
        return this.newsRepository.save(news);
    }

    public void delete(String id) {
        final News news = this.newsRepository.findOne(id);
        this.newsRepository.delete(news);
    }

    public List<News> findAll() {
        return this.newsRepository.findAll();
    }

    public News findOne(String id) {
        return this.newsRepository.findOne(id);
    }
}
