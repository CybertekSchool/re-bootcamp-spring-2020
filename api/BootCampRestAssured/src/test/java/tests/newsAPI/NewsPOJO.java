package tests.newsAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author : akbar
 * Created At : 7/2/20
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsPOJO {


    private String author;
    private String title;

    public NewsPOJO(){}

    public NewsPOJO(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public String toString() {
        return "NewsPOJO{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
