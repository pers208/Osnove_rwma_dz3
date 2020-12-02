package matejpersic_dz1.ferit.osnove_rwma_dz3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ModularFragment extends Fragment {

    private static final String BUNDLE_MESSAGE="Hello world!";


    public static ModularFragment newInstance(String message) {
            ModularFragment fragment = new ModularFragment();
            Bundle args = new Bundle();
            args.putString(BUNDLE_MESSAGE, message);
            fragment.setArguments(args);
            return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private boolean setUpTextView() {
        if(getArguments()!=null) {
            String argMessage = getArguments().getString(BUNDLE_MESSAGE);
            if (argMessage != null && !argMessage.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(setUpTextView()){
                return inflater.inflate(R.layout.fragment_modular, container, false);
        }
        return inflater.inflate(R.layout.fragment_image, container, false);
    }
}