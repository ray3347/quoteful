package com.example.quoteful.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoteful.Quoteful;
import com.example.quoteful.databinding.FragmentNotificationsBinding;
import com.example.quoteful.models.Quote;
import com.example.quoteful.ui.notifications.RecycleView.QuoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private List<Quote> savedQuotes= Quoteful.db.quoteTransactions().getAllSavedQuotes();
    private QuoteAdapter quoteAdapter = new QuoteAdapter(savedQuotes);
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setAdapter(quoteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        quoteAdapter.setOnItemClickListener(new QuoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle button click for the item at position
                Quote selectedQuote = savedQuotes.get(position);
                // Do something with the clicked item
                Quoteful.db.quoteTransactions().deleteQuote(selectedQuote);
                Toast.makeText(requireContext(), "Quote Deleted", Toast.LENGTH_SHORT).show();
                //refresh();
                quoteAdapter.deleteItem(position);
            }
        });

//        notificationsViewModel.getItemList().observe(getViewLifecycleOwner(), new Observer<List<Quote>>() {
//            @Override
//            public void onChanged(List<Quote> yourItems) {
//                quoteAdapter.setItemList(yourItems);
//            }
//
//
//        });


        return root;
    }

//    public void refresh(){
//        savedQuotes = Quoteful.db.quoteTransactions().getAllSavedQuotes();
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}