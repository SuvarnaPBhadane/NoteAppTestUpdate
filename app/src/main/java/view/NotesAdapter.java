package view;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteappdemo.R;

import java.util.List;

import model.Note;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    public static final String TAG = NotesAdapter.class.getName();
    private Context context;
    private List<Note> notesList;

    public NotesAdapter(Context context, List<Note> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NotesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.MyViewHolder holder, int position) {
        Note note = notesList.get(position);
        holder.title.setText(note.getTitle());
        holder.note.setText(note.getNote());
        holder.priority.setText(note.getPriority());
        holder.dot.setText(Html.fromHtml("&#8226;"));
        Log.d(TAG,"class: "+note);

        switch (note.getPriority()){
        case "Low": holder.relativeLayout.setBackgroundColor(Color.parseColor("#70A833"));
                    break;
        case "Medium": holder.relativeLayout.setBackgroundColor(Color.parseColor("#EEAC2D"));
                       break;
        case "High": holder.relativeLayout.setBackgroundColor(Color.parseColor("#F35E43"));
                     break;
            default:holder.relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                        break;
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG,"data size: "+notesList.size());
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView note;
        public TextView priority;
        public TextView dot;
        RelativeLayout relativeLayout;
        public MyViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.title);
            note = view.findViewById(R.id.note);
            dot = view.findViewById(R.id.dot);
            priority = view.findViewById(R.id.priority);
            relativeLayout = view.findViewById(R.id.relativeLayout);
        }
    }
}
