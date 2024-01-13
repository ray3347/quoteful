package com.example.quoteful.ui.notifications.RecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoteful.R;
import com.example.quoteful.models.Quote;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.ViewHolder> {
    private List<Quote> itemList;
    private OnItemClickListener onItemClickListener;

    public QuoteAdapter(List<Quote> itemList) {
        this.itemList = itemList;
    }

    public void setItemList(List<Quote> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Quote item = itemList.get(position);
        holder.quoteText.setText(item.getQuote());
        holder.authorText.setText(item.getAuthor());
        // Set other views as needed
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void deleteItem(int position) {
        itemList.remove(position);
        notifyItemRemoved(position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView quoteText;
        TextView authorText;
        Button deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(R.id.quoteText);
            authorText = itemView.findViewById(R.id.authorText);
            deleteButton = itemView.findViewById(R.id.btn_delete);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
            // Initialize other views as needed
        }
    }
}
