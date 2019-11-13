package edu.android20191113.moviemgr;

public class Movie {
    private String mTitle;
    private String mContent;
    private int mImage; // 리소스 id

    public Movie(String mTitle, String mContent, int mImage) {
        this.mTitle = mTitle;
        this.mContent = mContent;
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mTitle='" + mTitle + '\'' +
                ", mContent='" + mContent + '\'' +
                ", mImage=" + mImage +
                '}';
    }
}
