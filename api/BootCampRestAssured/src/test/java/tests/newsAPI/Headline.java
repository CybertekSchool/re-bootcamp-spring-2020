package tests.newsAPI;

import com.fasterxml.jackson.annotation.*;

import java.util.Map;

/**
 * @author : akbar
 * Created At : 7/2/20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline{

    String sourceID;
    String author;
    String title;

    public String getSourceID() {
        return sourceID;
    }

    @JsonProperty("source")
    public void setSourceID(Map<String, Object> source) {
        this.sourceID = String.valueOf( source.get("id") );
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

    @Override
    public String toString() {
        return "Headline{" +
                "sourceID='" + sourceID + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
