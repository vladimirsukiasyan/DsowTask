package dsow.dsowtask;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

class TaskAdapter extends FirestoreAdapter<TaskAdapter.ViewHolder> {
    public interface OnTaskSelectedListener {
        void onTaskSelected(DocumentSnapshot task);
    }

    private OnTaskSelectedListener mListener;

    public TaskAdapter(Query query, OnTaskSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_task, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        
        TextView taskName;
        CheckBox taskIsDone;

        public ViewHolder(View itemView) {
            super(itemView);
            
        }

        public void bind(final DocumentSnapshot snapshot, final OnTaskSelectedListener listener) {

            Task task = snapshot.toObject(Task.class);
            taskName.setText(task.getName());
            taskIsDone.setChecked(task.isDone());

            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onTaskSelected(snapshot);
                    }
                }
            });
        }

    }
}
