package com.Ingeneo.contactos.modelo;

import java.util.ArrayList;
import java.util.List;

import com.Ingeneo.contactos.logica.Contacto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// Versión de la base de datos
	private static final int DATABASE_VERSION = 1;

	// Nombre de la base de datos
	private static final String DATABASE_NAME = "agenda_contactos";

	// Nombre de la tabla contactos
	private static final String TABLE_CONTACTOS = "contactos";

	// Nombre de las columnas de la tabla contactos
	private static final String KEY_ID = "id";
	private static final String KEY_NOMBRE = "nombre";
	private static final String KEY_TELEFONO = "telefono";
	private static final String KEY_EMAIL = "email";
	private static final String KEY_DIRECCION = "direccion";
	private static final String KEY_FAVORITO = "favorito";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Crea la tabla contactos
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTOS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NOMBRE + " TEXT,"
				+ KEY_TELEFONO + " TEXT," + KEY_EMAIL + " TEXT,"
				+ KEY_DIRECCION + " TEXT," + KEY_FAVORITO + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Actualiza la base de datos
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Elimina la antigua tabla
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTOS);

		// Crea las tablas de nuevo
		onCreate(db);
	}

	public void agregarContacto(Contacto contacto) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NOMBRE, contacto.getNombre());
		values.put(KEY_TELEFONO, contacto.getTelefono());
		values.put(KEY_EMAIL, contacto.getEmail());
		values.put(KEY_DIRECCION, contacto.getDireccion());
		values.put(KEY_FAVORITO, contacto.getFavorito());

		db.insert(TABLE_CONTACTOS, null, values);
		db.close(); // Closing database connection
	}

	public Contacto buscarContacto(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_CONTACTOS, new String[] { KEY_NOMBRE,
				KEY_TELEFONO, KEY_EMAIL, KEY_DIRECCION, KEY_FAVORITO }, KEY_ID
				+ "=?", new String[] { String.valueOf(id) }, null, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();

		Contacto contacto = new Contacto(cursor.getString(0),
				cursor.getString(1), cursor.getString(2), cursor.getString(3),
				Boolean.parseBoolean(cursor.getString(4)));
		return contacto;
	}

	public int actualizarContacto(Contacto contacto) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NOMBRE, contacto.getNombre());
		values.put(KEY_TELEFONO, contacto.getTelefono());
		values.put(KEY_EMAIL, contacto.getEmail());
		values.put(KEY_DIRECCION, contacto.getDireccion());
		values.put(KEY_FAVORITO, contacto.getFavorito());

		// updating row
		return db.update(TABLE_CONTACTOS, values, KEY_ID + " = ?",
				new String[] { String.valueOf(contacto.getId()) });
	}

	public void deleteContact(Contacto contacto) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTOS, KEY_ID + " = ?",
				new String[] { String.valueOf(contacto.getId()) });
		db.close();
	}
}