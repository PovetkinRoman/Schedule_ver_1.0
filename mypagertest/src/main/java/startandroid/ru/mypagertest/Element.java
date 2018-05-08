package startandroid.ru.mypagertest;

/**
 * Created by Romjke on 22.04.2018.
 */

public class Element {
    private String itemTitle;
    private String typeOfItem;
    private String lectureHall;
    private String teacherName;

    public Element(String itemTitle, String typeOfItem, String lectureHall, String teacherName) {
        this.itemTitle = itemTitle;
        this.typeOfItem = typeOfItem;
        this.lectureHall = lectureHall;
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getLectureHall() {
        return lectureHall;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public String getItemTitle() {
        return itemTitle;
    }
}
