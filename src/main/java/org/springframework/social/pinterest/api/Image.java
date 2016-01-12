package org.springframework.social.pinterest.api;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Image {

    private Original original;

    public static class Original {
        private String url;
        private Integer width;
        private Integer height;

        public String getUrl() {
            return url;
        }

        public Integer getWidth() {
            return width;
        }

        public Integer getHeight() {
            return height;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Original{");
            sb.append("height=").append(height);
            sb.append(", url='").append(url).append('\'');
            sb.append(", width=").append(width);
            sb.append('}');
            return sb.toString();
        }
    }

    public Original getOriginal() {
        return original;
    }

    public Original getProfile() {
        return original;
    }

    public Original getSmall() {
        return original;
    }

    @JsonSetter(value = "original")
    public void setOriginal(Original original) {
        this.original = original;
    }

    @JsonSetter(value = "60x60")
    public void setProfile(Original original) {
        this.original = original;
    }

    @JsonSetter(value = "small")
    public void setSmall(Original original) {
        this.original = original;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Image{");
        sb.append("original=").append(original);
        sb.append('}');
        return sb.toString();
    }
}
