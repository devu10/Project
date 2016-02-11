package test.com.smarttravelcompanion;

/**
 * Created by devu on 2/9/2016.
 */
public class todoProvider {

    private String title;
    private String des;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public todoProvider(String title, String des){
        this.title=title;
        this.des=des;
    }
}
