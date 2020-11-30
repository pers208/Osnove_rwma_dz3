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

public class ImageFragment extends Fragment {

    private static final String BUNDLE_MESSAGE="3";

    private ImageView imageView;

    public static ImageFragment newInstance(String message) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView=view.findViewById(R.id.iwModular);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image, container, false);
    }

}