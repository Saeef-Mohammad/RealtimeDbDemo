package android.saeefmd.realtimedbdemo;

import android.saeefmd.realtimedbdemo.Data.Student;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditorActivity extends AppCompatActivity {

    private EditText nameEt;
    private EditText mobileEt;
    private EditText addressEt;
    private Button submitBt;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        nameEt = findViewById(R.id.name_et);
        mobileEt = findViewById(R.id.mobile_et);
        addressEt = findViewById(R.id.address_et);
        submitBt = findViewById(R.id.submit_bt);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("students");

        submitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameEt.getText().toString();
                String mobile = mobileEt.getText().toString();
                String address = addressEt.getText().toString();

                inputStudent(name, mobile, address);
            }
        });
    }

    private void inputStudent(String name, String mobile, String address) {

        String key = mFirebaseDatabase.push().getKey();

        Student student = new Student(name, mobile, address);
        mFirebaseDatabase.child(key).setValue(student);
        finish();
    }
}
