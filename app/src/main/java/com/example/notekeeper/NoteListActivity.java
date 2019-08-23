package com.example.notekeeper;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import java.util.List;

public class NoteListActivity extends AppCompatActivity{
    private NoteRecyclerAdapter mNoteRecyclerAdapter;

//    private ArrayAdapter<NoteInfo> notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoteListActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });
        
        InitializeDisplayContent();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        notesAdapter.notifyDataSetChanged();
        mNoteRecyclerAdapter.notifyDataSetChanged();
    }

    private void InitializeDisplayContent() {
//        final ListView listNotes = findViewById(R.id.note_lists);
//
//        List<NoteInfo> notes = DataManager.getInstance().getNotes();
//        notesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,notes);
//
//        listNotes.setAdapter(notesAdapter);
//
//        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                NoteInfo note = (NoteInfo) listNotes.getItemAtPosition(i);
//                Intent intent = new Intent(NoteListActivity.this,NoteActivity.class);
//                intent.putExtra(NoteActivity.NOTE_POSITION, i);
//                startActivity(intent);
//
//            }
//        });
        final RecyclerView recyclerView = findViewById(R.id.list_notes);
        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(notesLayoutManager);

        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        mNoteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
        recyclerView.setAdapter(mNoteRecyclerAdapter);
    }

}
