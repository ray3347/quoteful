package com.example.quoteful.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quoteful.Quoteful;
import com.example.quoteful.databinding.FragmentDashboardBinding;
import com.example.quoteful.models.Quote;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    private Quote activeQuote = new Quote("", "", "");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textQuote;
        final TextView authorTextView = binding.textAuthor;
        dashboardViewModel.getQuote().observe(getViewLifecycleOwner(), textView::setText);
        dashboardViewModel.getAuthor().observe(getViewLifecycleOwner(), authorTextView::setText);

        if(activeQuote.getQuote().equals("")){
            activeQuote = dashboardViewModel.newQuote();
        }


        final Button newBtn = binding.btnNewQuote;
        final Button saveBtn = binding.btnSaveQuote;

        newBtn.setOnClickListener(x->{
            activeQuote = dashboardViewModel.newQuote();
            dashboardViewModel.getQuote().observe(getViewLifecycleOwner(), textView::setText);
            dashboardViewModel.getAuthor().observe(getViewLifecycleOwner(), authorTextView::setText);
        });

        saveBtn.setOnClickListener(x->{
            if(activeQuote.getQuote()!= ""){
                activeQuote.uid = activeQuote.generateRandomNumber();
                Quoteful.db.quoteTransactions().saveQuote(activeQuote);
                Toast.makeText(requireContext(), "Quote Saved!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(requireContext(), "Saving Unsuccessful, Try Again", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}