package com.mybringback.thebasics.trade.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mybringback.thebasics.trade.R;
import com.mybringback.thebasics.trade.premodel.DataService;
import com.mybringback.thebasics.trade.premodel.Main;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ALLO on 18.07.2016.
 */
public class ResourceFragment extends Fragment {

    Button button;
    TextView textView;

    public ResourceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        button=(Button) rootView.findViewById(R.id.button);
        final TextView textView=(TextView) rootView.findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.quandl.com/api/v3/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                DataService service = retrofit.create(DataService.class);
                final Call<Main> call =
                        service.rowsOrder("10","desc");

                call.enqueue(new Callback<Main>() {
                    @Override
                    public void onResponse(Call <Main> call, Response<Main> response) {
                        Log.e("onResponse", String.valueOf(response.raw()));
                        textView.setText(response.body().getDataset().toString());
                    }

                    @Override
                    public void onFailure(Call<Main> call, Throwable t) {
                        Log.e("onFail", t.getMessage());
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });
        return rootView;
    }
}
