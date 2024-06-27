package lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab1_android22.R;

import java.util.List;

import models.Todo;
import models.TodoAdapter;
import models.TodoDatabaseHelper;


public class lab1 extends AppCompatActivity {
    private List<Todo> dsModel;
    private EditText edt_1, edt_2;
    private Button btn_Them;
    private ListView list_home;
    private TodoDatabaseHelper dbHelper;
    private List<Todo> todoList;
    private TodoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
            init();

            dbHelper = new TodoDatabaseHelper(this);
            todoList = dbHelper.getAllTodos();

            adapter = new TodoAdapter(this, todoList);
            list_home.setAdapter(adapter);

            btn_Them.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = edt_1.getText().toString();
                    String des = edt_2.getText().toString();

                    if (!title.isEmpty() && !des.isEmpty()){
                        Todo newTodo = new Todo(title, des);
                        dbHelper.addTodo(newTodo);
                        todoList.add(newTodo);
                        adapter.notifyDataSetChanged();
                        edt_1.setText("");
                        edt_2.setText("");
                    }
                }
            });
    }



    public void init(){
        list_home = findViewById(R.id.list_home);
        edt_1 = findViewById(R.id.edt_1);
        edt_2 = findViewById(R.id.edt_2);
        btn_Them = findViewById(R.id.btn_Them);
    }
}