package fantastic.cms.services;

import fantastic.cms.models.Review;
import fantastic.cms.repositories.NewsRepository;
import fantastic.cms.requests.NewsRequest;
import org.springframework.stereotype.Service;
import fantastic.cms.models.News;
import org.springframework.web.cors.reactive.PreFlightRequestWebFilter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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


    public Review addReview(String newsId, String userId, Review review) {
        News news = newsRepository.findOne(newsId);
        if (news == null) {
            // Handle case where news article is not found
            return null;
        }

        // Add review to the news article
        news.addReview(review.getUserId(), review.getStatus());
        newsRepository.save(news);
        return review;
    }

    public Set<Review> getReviews(String newsId) {
        News news = newsRepository.findOne(newsId);
        if (news == null) {
            // Handle case where news article is not found
            return null;
        }

        return news.getReviews();
    }

    public void deleteReview(String newsId, String reviewId) {
        News news = newsRepository.findOne(newsId);
        if (news == null) {
            // Handle case where news article is not found
            return;
        }

        news.deleteReview(reviewId);
        newsRepository.save(news);
    }
}
