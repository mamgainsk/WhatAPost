package whatanews.org.com.whatapost.Networking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mobileprogramming on 05/02/18.
 */

public class ImageURLInfoBean {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;

    @Override
    public String toString() {
        return "ImageURLInfoBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", category='" + category + '\'' +
                ", souceLink='" + souceLink + '\'' +
                ", souceName='" + souceName + '\'' +
                '}';
    }

    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnailUrl;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("souce_link")
    @Expose
    private String souceLink;
    @SerializedName("souce_name")
    @Expose
    private String souceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSouceLink() {
        return souceLink;
    }

    public void setSouceLink(String souceLink) {
        this.souceLink = souceLink;
    }

    public String getSouceName() {
        return souceName;
    }

    public void setSouceName(String souceName) {
        this.souceName = souceName;
    }

}
