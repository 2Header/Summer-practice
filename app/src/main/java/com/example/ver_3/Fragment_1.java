package com.example.ver_3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;



/**
 * A simple {@link Fragment} subclass.
 */
/*public class Fragment_1 extends Fragment {

    RecyclerView recyclerView;

    private DatabaseReference myRef;

    private ArrayList<Calendar> messagesList;
    private RecyclerAdapter recyclerAdapter;
    private Context mContext;

    public Fragment_1() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_1);

        recyclerView = recyclerView.findViewById(recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        myRef = FirebaseDatabase.getInstance().getReference();

        messagesList = new ArrayList<>();

        ClearAll();

        GetDataFromFirebase();
    }

    private void GetDataFromFirebase() {

        Query query = myRef.child("message");
        query.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ClearAll();

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Calendar messages = new Calendar();

                    messages.setImageUrl(snapshot.child("image").getValue().toString());
                    messages.setName(snapshot.child("name").getValue().toString());

                    messagesList.add(messages);

                }
                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), messagesList);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void ClearAll(){

        if (messagesList != null){
            messagesList.clear();

            if (recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        messagesList = new ArrayList<>();
    }
}
   /*FirebaseDatabase database;
   DatabaseReference calendar;

   RecyclerView recycler_menu;
   RecyclerView.LayoutManager layoutManager;*/

    /*LinearLayoutManager mLinearLayoutManager;
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    FirebaseRecyclerAdapter<Calendar, ViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Calendar> option;*/

    /*DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Calendar> list;
    MyAdapterV3 adapterV3;*/





    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       database = FirebaseDatabase.getInstance();
        calendar = database.getReference("Calendar");

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setReverseLayout(true);
        mLinearLayoutManager.setStackFromEnd(true);





        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);

        list = new ArrayList<Calendar>();
        reference = FirebaseDatabase.getInstance().getReference().child("Calendar");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Calendar p = dataSnapshot1.getValue(Calendar.class);
                    list.add(p);
                }

                adapterV3 = new MyAdapterV3(Fragment_1.this,list);
                recyclerView.setAdapter(adapterV3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {




            }
        });

        /*RecyclerView recycler_menu = (RecyclerView) view.findViewById(R.id.recycler_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);
        loadMenu();*/
        /*RecyclerView mRecyclerView = (RecyclerView) mview.findViewbyId(R.id.recycleView);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Data");

        showData();

        return view;
    }

    /*private void showData(){
        option = new FirebaseRecyclerOptions.Builder<Calendar>().setQuery(mDatabaseReference, Calendar.class).build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Calendar, ViewHolder>(option){
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Calendar calendar){

                holder.setDetails(getApplicationContext(), calendar.getImage(), calendar.getName());

            }
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i){

                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
                ViewHolder viewHolder = new ViewHolder(itemView);
                viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Toast.makeText(Fragment_1.this, "hi", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Toast.makeText(Fragment_1.this, "hi", Toast.LENGTH_SHORT).show();

                    }
                });
                return viewHolder;
            }
        };
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        firebaseRecyclerAdapter.startListening();
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    protected void onStart(){
        super.onStart();
        if (firebaseRecyclerAdapter != null){

            firebaseRecyclerAdapter.startListening();
        }
    }*/
//}
    /*private void loadMenu(){

        FirebaseRecyclerAdapter<Calendar, Fr1ViewHolder> adapter = new FirebaseRecyclerAdapter<Calendar, Fr1ViewHolder>(Calendar,R.layout.menu_item, Fr1ViewHolder.class,calendar) {
            @Override
            protected void populateViewHolder(Fr1ViewHolder viewHolder, Calendar model, int position){


        }



        /*ArrayList<String> presence = new ArrayList<String>();
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("student_users/Alisha Tapiwala/classes/CS3354_003");
        ValueEventListener listener = new ValueEventListener() {
            @Override
            onDataChange(DataSnapshot dataSnapshot){
                for( DataSnapshot children : dataSnapshot.getChildren(){
                    presence.add(children.child(" ").getValue(String.class));*/





