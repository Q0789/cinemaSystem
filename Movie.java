public class Movie {
    //片名
    private String title;
    //导演
    private String director;
    //主演
    private String leadingActor;
    //类型
    private String genre;
    //剧情简介
    private String plot;
    //时长
    private int duration;

    //构造方法
    public Movie(){
        }

    public Movie(String title, String director, String leadingActor, String genre, String plot, int duration) {
        this.title = title;
        this.director = director;
        this.leadingActor = leadingActor;
        this.genre = genre;
        this.plot = plot;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLeadingActor() {
        return leadingActor;
    }

    public void setLeadingActor(String leadingActor) {
        this.leadingActor = leadingActor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
