package com.pirates.nbaonline;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowOnlineCourse extends AppCompatActivity {

    String doc;
    ListView listView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    DisplayListviewClass displayListviewClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_online_course);

        Intent intent = getIntent();
        doc = intent.getStringExtra("Email");

        displayListviewClass = new DisplayListviewClass();
        listView = (ListView) findViewById(R.id.list_view_layout);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Online_Course_ImageNames").child(doc);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.name_list,R.id.name,list);

        list.clear();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for( DataSnapshot ds:dataSnapshot.getChildren()){
                    displayListviewClass = ds.getValue(DisplayListviewClass.class);
                    list.add(""+displayListviewClass.getImagename());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listView.getItemAtPosition(position);
                Toast.makeText(ShowOnlineCourse.this, ""+item , Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),DisplayOnlineCourse.class);
                intent.putExtra("imagename",item);
                intent.putExtra("email",doc);
                startActivity(intent);
            }
        });
    }
}
