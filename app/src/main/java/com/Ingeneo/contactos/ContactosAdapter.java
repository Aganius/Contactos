package com.Ingeneo.contactos;

import java.util.ArrayList;

import com.Ingeneo.contactos.logica.Contacto;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ContactosAdapter extends BaseAdapter {

    ArrayList<Contacto> contactos = new ArrayList<Contacto>();
    LayoutInflater inflater;
    Context context;


    public ContactosAdapter(Context context, ArrayList<Contacto> contactos) {
        this.contactos = contactos;
        this.context = context;
        inflater = LayoutInflater.from(this.context);        // only context can also be used
    }

    @Override
    public int getCount() {
        return contactos.size();
    }

    @Override
    public Contacto getItem(int position) {
        return contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.contacto_item, null);
            mViewHolder = new MyViewHolder();
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }



        mViewHolder.ivFavorito = detail(convertView, R.id.favorito, contactos.get(position).getFavorito());
        mViewHolder.tvNombre = detail(convertView, R.id.nombre, contactos.get(position).getNombre());
        mViewHolder.tvTelefono = detail(convertView, R.id.telefono, contactos.get(position).getTelefono());
        mViewHolder.tvEmail = detail(convertView, R.id.email, contactos.get(position).getEmail());

        return convertView;
    }

    // or you can try better way
    private TextView detail(View v, int resId, String text) {
        TextView tv = (TextView) v.findViewById(resId);
        tv.setText(text);
        return tv;
    }

    private ImageView detail(View v, int resId, Boolean icon) {
        ImageView iv = (ImageView) v.findViewById(resId);
        iv.setImageResource(R.drawable.ic_action_star); //

        return iv;
    }

    private class MyViewHolder {
        ImageView ivFavorito;
        TextView tvNombre;
        TextView tvTelefono;
        TextView tvEmail;


    }

}
