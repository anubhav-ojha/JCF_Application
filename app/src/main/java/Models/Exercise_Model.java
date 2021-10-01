package Models;

public class Exercise_Model {
    String pic ;
    String text ;

    void MainModel()
    {

    }

    public Exercise_Model(String pic, String text) {
        this.pic = pic;
        this.text = text;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
