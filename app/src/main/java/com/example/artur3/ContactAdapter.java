package com.example.artur3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog; // Додано імпорт для AlertDialog

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<String> {
    private ArrayList<String> nameList;
    private Context context;

    public ContactAdapter(Context context, int resource, ArrayList<String> nameList) {
        super(context, resource, nameList);
        this.context = context;
        this.nameList = nameList;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.name_item, parent, false);
        }

        TextView userNameTextView = itemView.findViewById(R.id.user_name);
        ImageView userImageView = itemView.findViewById(R.id.user_image);
        Button deleteButton = itemView.findViewById(R.id.delete_button);

        userNameTextView.setText(nameList.get(position));
        userImageView.setImageResource(R.drawable.tricutnuk);

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showTricutnukImage();
                return true;
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameList.remove(position);
                notifyDataSetChanged();
            }
        });

        return itemView;
    }

    private void showTricutnukImage() {
        // Відобразіть фотографію tricutnuk на екрані
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.tricutnuk);

        // Створіть та покажіть діалогове вікно зображення
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(imageView);
        builder.show();
    }
}
