package com.example.tugasprak8localdata;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {
    ArrayList<Note> notes = new ArrayList<>();

    private TextView tv_title;
    private TextView tv_description;
    private TextView tv_date;

    @NonNull
    @Override
    public AdapterUser.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_card, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUser.ViewHolder holder, int position) {

        holder.setData(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(ArrayList<Note> dataNotes){
        notes.clear();
        if (dataNotes !=null){
            notes.addAll(dataNotes);
        }
        notifyDataSetChanged();
    }

    public void addItem(Note note) {
        this.notes.add(note);
        notifyItemInserted(this.notes.size() - 1);
    }

    public void updateNote(Note note, int position) {
        this.notes.set(position, note);
    }

    public void removeItem(Note note, int position) {
        this.notes.remove(position);
        notifyItemRemoved(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(Note note) {
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_content);
            tv_date = itemView.findViewById(R.id.tv_date);

            tv_title.setText(note.getTitle());
            tv_description.setText(note.getDescription());
            tv_date.setText(note.getDate());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), MainActivity2.class);
                    if (note !=null){
                        intent.putExtra(MainActivity2.EXTRA_NOTES, note);
                    }
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
