package quyen.it.dut.send_listview;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edt_a, edt_b;
    Button btn_send;
    ListView lv_Result;
    ArrayList<String> arrResult;
    ArrayAdapter<String> adapter_Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        btn_send = findViewById(R.id.btn_send);
        lv_Result = findViewById(R.id.lv_Result);
        arrResult = new ArrayList<>();
        adapter_Result = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrResult);
        lv_Result.setAdapter(adapter_Result);
    }

    private void addEvents() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handle();
            }
        });

    }

    private void handle() {
        // khai bao mot intent de truyen du lieu
        Intent intent = new Intent(MainActivity.this, xu_li.class);

        // gan du lieu vao intent
        int tmpa = 0, tmpb = 0;
        if (edt_a.getText().length() > 0 && edt_b.getText().length() > 0) {
            tmpa = Integer.parseInt(edt_a.getText().toString());
            intent.putExtra("a", tmpa);
            tmpb = Integer.parseInt(edt_b.getText().toString());
            intent.putExtra("b", tmpb);
            startActivityForResult(intent, 21);
        } else {
            Toast.makeText(MainActivity.this, "Nhap lai day du", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 21 && resultCode == 3){
            String ketquanhan = data.getStringExtra("kq");
            arrResult.add(0,ketquanhan);
            adapter_Result.notifyDataSetChanged();
        }
    }
}
