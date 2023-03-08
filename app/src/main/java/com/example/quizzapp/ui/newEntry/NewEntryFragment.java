package com.example.quizzapp.ui.newEntry;

import static android.app.Activity.RESULT_OK;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quizzapp.R;
import com.example.quizzapp.model.Database;
import com.example.quizzapp.model.Item;
import com.example.quizzapp.model.ItemDao;
import com.example.quizzapp.model.ItemDatabase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class NewEntryFragment extends Fragment {

    private ImageView mImageView;
    private EditText mPhotoNameEditText;
    private static final int PICK_IMAGE = 1;
    private Button mSubmitButton;
    private Bitmap selectedImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_entry, container, false);
        mImageView = view.findViewById(R.id.image_view);
        mPhotoNameEditText = view.findViewById(R.id.photo_name_edit_text);
        mSubmitButton = view.findViewById(R.id.btn_submit);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String photoName = mPhotoNameEditText.getText().toString();
                if (photoName.isEmpty()) {
                    Toast.makeText(getContext(), "Enter a name for the photo", Toast.LENGTH_SHORT).show();
                } else {
                    // Add code to handle the photo and photo name submission
                    // Get instance of the database
                    ItemDatabase itemDatabase = ItemDatabase.getDatabase(getContext());

                    // Get instance of the DAO
                    ItemDao itemDao = itemDatabase.itemDao();

                    Item item1 = new Item(selectedImage, photoName);

                    itemDao.insert(item1);
                }
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                mImageView.setImageBitmap(bitmap);
                selectedImage = bitmap;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}
