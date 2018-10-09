package quyen.it.dut.send_listview;

import android.content.Intent;
import android.service.autofill.TextValueSanitizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class xu_li extends AppCompatActivity implements View.OnClickListener {
    TextView txt_a_nhan, txt_b_nhan, txt_result;
    Button btn_add, btn_sub, btn_mul, btn_div, btn_gui_lai;
    Intent intent;
    int a, b;
    String display = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xu_li);

        addControls();
        addEvents();

    }

    private void addControls() {
        txt_a_nhan = findViewById(R.id.txt_a_nhan);
        txt_b_nhan = findViewById(R.id.txt_b_nhan);
        txt_result = findViewById(R.id.txt_result);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_mul = findViewById(R.id.btn_mul);
        btn_div = findViewById(R.id.btn_div);
        btn_gui_lai = findViewById(R.id.btn_gui_lai);

        // lay du lieu tu intent
        intent = getIntent();

        a = intent.getIntExtra("a", -1);
        txt_a_nhan.setText(a + " ");
        b = intent.getIntExtra("b", -1);
        txt_b_nhan.setText(b + " ");

    }

    private void addEvents() {
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_gui_lai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Button p = (Button) v;
        switch(p.getText().toString()){
            case "+":
                display = a + " + " + b + " = " + (a + b) ;
                txt_result.setText(display);
                intent.putExtra("kq", display);

                break;
            case "-":
                display = a + " - " + b + " = " + (a - b) ;
                txt_result.setText(display);
                intent.putExtra("kq", display);

                break;
            case "*":
                display = a + " * " + b + " = " + (a * b) ;
                txt_result.setText(display);
                intent.putExtra("kq", display);

                break;
            case "/":
                if(b != 0){
                    display = a + " / " + b + " = " + (a/ b) ;
                    txt_result.setText(display);
                    intent.putExtra("kq", display);

                    break;
                }else {
                    txt_result.setText("Nhap b # 0");
                    break;
                }
             default:
                 // danh sau ket qua tra ve thong qua ma tra ve
                 if(display.length() > 0){
                     setResult(3, intent);
                     finish();
                 }else{
                     Toast.makeText(this, "Thuc hien phep toan", Toast.LENGTH_SHORT).show();
                 }

        }

    }
}
