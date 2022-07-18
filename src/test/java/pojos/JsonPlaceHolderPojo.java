package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {

    /*
        1) Tum key ler icin private variable lar olusturuyoruz
        2) Tum parametrelerle ve parametresiz constructor larimizi olusturuyoruz
        3) Getters ve Setters larimizi olusturuyoruz
        4) toString() methodumuzu olusturuyoruz
     */

    // 1) Tum keyler icin private variable lar olusturuyoruz

    private Integer userId;
    private String title;
    public Boolean completed;

    // 2) Tum parametrelerle ve parametresiz constructor larimizi olusturuyoruz

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }

    // 3) Getters ve Setters larimizi olusturuyoruz

    public Integer getUserId() {
        return userId;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public String getTitle() {
        return title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // 4) toString() methodumuzu olusturuyoruz

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
    //Farklı key-value ikililerin uyuşmazlığını @JsonIgnoreProperties(ignoreUnknown = true)
    // anotation'ını Pojo Class'ımızın başına yazarak çözebiliriz.
}
