package ru.startandroid.timetableofclasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Irishka on 12.11.2017.
 */

public class Adapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<AdminListItem> objects;

    Adapter(Context context, ArrayList<AdminListItem> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        AdminListItem p = getProduct(position);

        // заполняем View в пункте списка данными
        ((TextView) view.findViewById(R.id.tvDescr)).setText(p.name);
        ((TextView) view.findViewById(R.id.tvPrice)).setText(p.request + "");

        RadioButton cbBuy = (RadioButton) view.findViewById(R.id.radioButton);
        // присваиваем чекбоксу обработчик
        cbBuy.setOnCheckedChangeListener(myCheckChangeList);
        // пишем позицию
        cbBuy.setTag(position);

        return view;
    }

    // товар по позиции
    AdminListItem getProduct(int position) {
        return ((AdminListItem) getItem(position));
    }

    // содержимое корзины
    ArrayList<AdminListItem> getBox() {
        ArrayList<AdminListItem> box = new ArrayList<AdminListItem>();
        for (AdminListItem p : objects) {
                box.add(p);
        }
        return box;
    }

    // обработчик для чекбоксов
    CompoundButton.OnCheckedChangeListener myCheckChangeList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // меняем данные (в корзине или нет)
            getProduct((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}