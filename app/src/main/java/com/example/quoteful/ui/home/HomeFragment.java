package com.example.quoteful.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.quoteful.Quoteful;
import com.example.quoteful.databinding.FragmentHomeBinding;
import com.example.quoteful.models.Quote;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private Quote activeQuote = new Quote("", "", "");

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final TextView quoteText = binding.textQuote;
        final TextView extraText = binding.textAuthorCategory;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
        homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);

        final Button saveBtn = binding.btnSaveQuote;
        saveBtn.setOnClickListener(x->{
            if(activeQuote.getQuote()!= ""){
                activeQuote.uid = activeQuote.generateRandomNumber();
                Quoteful.db.quoteTransactions().saveQuote(activeQuote);
                Toast.makeText(requireContext(), "Quote Saved!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(requireContext(), "Saving Unsuccessful, Try Again", Toast.LENGTH_SHORT).show();
            }
        });


        final CardView loveCard = binding.cardLove;
        loveCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("love");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView movieCard = binding.cardMovies;
        movieCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("movies");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView morningCard = binding.cardMorning;
        morningCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("morning");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView fitnessCard = binding.cardFitness;
        fitnessCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("fitness");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView familyCard = binding.cardFamily;
        familyCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("family");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView moneyCard = binding.cardMoney;
        moneyCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("money");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView leaderCard = binding.cardLeadership;
        leaderCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("leadership");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView learningCard = binding.cardLearning;
        learningCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("learning");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView medicalCard = binding.cardMedical;
        medicalCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("medical");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        final CardView legalCard = binding.cardLegal;
        legalCard.setOnClickListener(x->{
            activeQuote = homeViewModel.getCategorizedQuote("legal");
            homeViewModel.getQuote().observe(getViewLifecycleOwner(), quoteText::setText);
            homeViewModel.getExtra().observe(getViewLifecycleOwner(), extraText::setText);
            textView.setVisibility(View.GONE);
            quoteText.setVisibility(View.VISIBLE);
            extraText.setVisibility(View.VISIBLE);
            saveBtn.setVisibility(View.VISIBLE);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}