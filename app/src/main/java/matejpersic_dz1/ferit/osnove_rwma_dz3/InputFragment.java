package matejpersic_dz1.ferit.osnove_rwma_dz3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment implements TextWatcher {

    private static final String BUNDLE_MESSAGE = "Hello World!";
    private EditText mEditText;
    private Button mSubmitButton;

    private ButtonClickListener mButtonClicklistener;

    public static InputFragment newInstance(String message){
        InputFragment fragment=new InputFragment();
        Bundle args=new Bundle();
        args.putString(BUNDLE_MESSAGE,message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditText=view.findViewById(R.id.edMessage);
        mSubmitButton=(Button) view.findViewById(R.id.btSubmit);
        setUpListeners();
    }

    private void setUpListeners() {
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonClicklistener.onButtonClicked(mEditText.getText().toString().trim());
                mEditText.setText("");
            }
        });
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ButtonClickListener)
        {
            mButtonClicklistener= (ButtonClickListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mButtonClicklistener=null;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        String mMessageString = s.toString();
    }

}