package model;

public class Note {

    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_PRIORITY = "priority";

    private int id;
    private String title;
    private String note;
    private String priority;

    //Create table SQL Query

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
        + COLUMN_TITLE + " TEXT,"
        + COLUMN_NOTE + " TEXT,"
        + COLUMN_PRIORITY + " TEXT"
        + ")";



    public Note(int id, String title, String note, String priority) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.priority = priority;
    }

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
