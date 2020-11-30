package matejpersic_dz1.ferit.osnove_rwma_dz3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment {

    private static final String BUNDLE_MESSAGE = "Hello World!";

   private TextView mTextView;

    public static MessageFragment newInstance(String message){
        MessageFragment fragment=new MessageFragment();
        Bundle args=new Bundle();
        args.putString(BUNDLE_MESSAGE,message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView=view.findViewById(R.id.tvfragmentmessage);
    }

    public void displayMessage(String message){
        mTextView.setText(!message.trim().isEmpty()?message:"Hello world!");
    }
}