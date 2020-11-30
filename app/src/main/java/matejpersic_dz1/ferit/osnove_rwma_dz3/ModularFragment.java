package matejpersic_dz1.ferit.osnove_rwma_dz3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ModularFragment extends Fragment {

    private static final String BUNDLE_MESSAGE="Hello world!";

    private TextView mTextView;

    public static ModularFragment newInstance(String message) {
            ModularFragment fragment = new ModularFragment();
            Bundle args = new Bundle();
            args.putString(BUNDLE_MESSAGE, "Hello world!");
            fragment.setArguments(args);
            return fragment;
    }
    public static ImageFragment newInstanceImage(String message) {
            ImageFragment fragment=new ImageFragment();
            return fragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView=view.findViewById(R.id.tvModular);
        setUpTextView();
    }

    private void setUpTextView() {
        String message=getString(R.string.hello_world);
        if(getArguments()!=null){
            String argMessage=getArguments().getString(BUNDLE_MESSAGE);
            if(argMessage!=null&&!argMessage.isEmpty()){
                message=argMessage;
            }
        }
        mTextView.setText(message);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_modular, container, false);
    }

}