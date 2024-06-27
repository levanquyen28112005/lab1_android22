package models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class TodoDatabaseHelper extends SQLiteOpenHelper {
    public TodoDatabaseHelper(Context context) {
        super(context, "name", null, 1);
    }

    //Tạo bảng sữ liệu
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table Model(\n" +
                "\tid integer primary key,\n" +
                "  \ttitle text,\n" +
                "  \tdes text\n" +
                ");";
        //Thực thi tạo bảng
        db.execSQL(CREATE_TABLE);
    }

    //upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Model");
    }
    public void addTodo(Todo td){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("title", td.getTitle());
        value.put("des", td.getDes());

        //Thực thi insert
        db.insert("Todo", null, value);

        //Đóng kết nối
        db.close();
    }
    public List<Todo> getAllTodos(){
        List<Todo> todoList = new ArrayList<>();
        String selectQuery = "SELECT * FROM Model";
        SQLiteDatabase db = this.getWritableDatabase();
        //Con trỏ đọc dữ liệu
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do{
                Todo model = new Todo();
                model.setTitle(cursor.getString(1));
                model.setDes(cursor.getString(2));
                todoList.add(model);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return todoList;
    }
}
