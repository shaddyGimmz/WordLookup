package com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carol.wordlookup.R;

import java.util.List;

public class TranslationAdapter extends RecyclerView.Adapter<TranslationAdapter.ViewHolder>
{
    private Context context;
    private List<String> wordlist;

    public TranslationAdapter(Context context, List<String> wordlist)
    {
        this.context = context;
        this.wordlist = wordlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.word_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        viewHolder.words.setText(wordlist.get(i));

    }

    @Override
    public int getItemCount() {
        return wordlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView words;

        public ViewHolder(@NonNull View item)
        {
            super(item);

            words = item.findViewById(R.id.words);
        }
    }

    public void addList(List<String> wordlist)
    {
        this.wordlist = wordlist;
        notifyDataSetChanged();
    }
}
