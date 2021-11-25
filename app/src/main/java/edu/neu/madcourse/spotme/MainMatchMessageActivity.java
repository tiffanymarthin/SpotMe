package edu.neu.madcourse.spotme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

import edu.neu.madcourse.spotme.database.models.Match;

public class MainMatchMessageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<MessageMatchModel> matchList;
    MatchesRViewAdapter adapter;
    FirebaseFirestore firebaseFirestore;
    Query query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_matches);

//       initialDate();
       initialRView();
    }

    private void initialRView() {
        recyclerView = findViewById(R.id.matchedRView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        firebaseFirestore = FirebaseFirestore.getInstance();
        query = firebaseFirestore.collection("matches");
        FirestoreRecyclerOptions<Match> options = new FirestoreRecyclerOptions.Builder<Match>()
                .setQuery(query, Match.class)
                .build();
        adapter = new MatchesRViewAdapter(options);
        recyclerView.setAdapter(adapter);
       // adapter.notifyDataSetChanged();
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stopping of the activity
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private void initialDate() {

        matchList = new ArrayList<>();

        matchList.add(new MessageMatchModel("Adam Smith", "10-10-1000",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_one_24));

        matchList.add(new MessageMatchModel("Human Being", "20-20-2000",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_one_24));

        matchList.add(new MessageMatchModel("Another Being", "11-11-1111",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_two_24));

        matchList.add(new MessageMatchModel("Yup Human", "90-09-1590",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_3_24));

        matchList.add(new MessageMatchModel("Adam Smith", "10-10-1000",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_one_24));

        matchList.add(new MessageMatchModel("Human Being", "20-20-2000",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_one_24));

        matchList.add(new MessageMatchModel("Another Being", "11-11-1111",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_two_24));

        matchList.add(new MessageMatchModel("Yup Human", "90-09-1590",
                R.drawable.ic_baseline_message_24, R.drawable.ic_baseline_looks_3_24));

    }

}