package michaeltm98.com.motivationalquotesapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardView);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");




        quoteText.setText(quote);
        byAuthor.setText("-" + author);

        cardView.setBackgroundResource(getRandomColor());

        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {
        QuoteFragment fragment = new QuoteFragment();

        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);
        fragment.setArguments(bundle);

        return fragment;
    }

    int getRandomColor(){

        int colors[] = new int[] {R.color.md_blue_500, R.color.md_pink_900,
                R.color.md_green_400, R.color.md_deep_orange_400,
                R.color.md_blue_grey_900, R.color.md_pink_800};
        int color;
        int quotesArraylength  = colors.length;
        int randomNum = (int) Math.floor((Math.random() * quotesArraylength));

        color = colors[randomNum];

        return color;
    }



}
