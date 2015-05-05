package com.Ingeneo.contactos.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.util.Log;

import com.Ingeneo.contactos.logica.Contacto;

public class XmlParser {

	public static ArrayList<Contacto> parseXML(Context applicationContext)
			throws XmlPullParserException, IOException {

		XmlPullParserFactory pullParserFactory;
		pullParserFactory = XmlPullParserFactory.newInstance();
		XmlPullParser parser = pullParserFactory.newPullParser();

		try {

			InputStream is = applicationContext.getAssets().open(
					"contactos.xml");
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(is, null);

		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<Contacto> contactos = null;
		int eventType = parser.getEventType();
		Contacto contactoActual = null;

		while (eventType != XmlPullParser.END_DOCUMENT) {
			String name = null;
			switch (eventType) {
			case XmlPullParser.START_DOCUMENT:
				contactos = new ArrayList<Contacto>();
				break;
			case XmlPullParser.START_TAG:
				name = parser.getName();
				if (name.equals("contacto")) {
					contactoActual = new Contacto();
				} else if (contactoActual != null) {
					if (name.equals("nombre")) {
						contactoActual.setNombre(parser.nextText());
//						Log.i("XML", contactoActual.getNombre());
					} else if (name.equals("telefono")) {
						contactoActual.setTelefono(parser.nextText());
//						Log.i("XML", contactoActual.getTelefono());
					} else if (name.equals("email")) {
						contactoActual.setEmail(parser.nextText());
//						Log.i("XML", contactoActual.getEmail());
					} else if (name.equals("direccion")) {
						contactoActual.setDireccion(parser.nextText());
//						Log.i("XML", contactoActual.getDireccion());
					}
				}
				break;
			case XmlPullParser.END_TAG:
				name = parser.getName();
				if (name.equalsIgnoreCase("contacto") && contactoActual != null) {
					contactos.add(contactoActual);
				}
			}
			eventType = parser.next();
		}

		return contactos;

	}

}
