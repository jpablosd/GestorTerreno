package cl.geosolve.gestor;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Acces extends Activity {
	
	EditText nombre,clave;
	Button entrar;
	
    private ProgressDialog pDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acces);

		nombre = (EditText) findViewById(R.id.nombre_usuario);
		clave = (EditText) findViewById(R.id.clave);
		entrar = (Button) findViewById(R.id.entrar);
		
		entrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String usuario = nombre.getText().toString();
				String pass = clave.getText().toString();
				//
        		if(checklogindata(usuario, pass) == true){        			
        			if(usuario.equals("juanpablo.soto") && pass.equals("85575884")){
        				Toast toast1 = Toast.makeText(getApplicationContext(),"Login exitoso.", Toast.LENGTH_SHORT);
        		 	    toast1.show(); 
	        		 	
        		 	    Intent i=new Intent(Acces.this, Muestra.class);
	                	i.putExtra("usuario",usuario);
	                	startActivity(i); 
        			}
        			else{
        				Toast toast1 = Toast.makeText(getApplicationContext(),"Error: Nombre de Usuario o Contrase�a Incorrecto.", Toast.LENGTH_SHORT);
        		 	    toast1.show();    	
        			}
        		}else{
        			err_login();
        		}
			}
		});
	}//onCreate
	
    //_______________________________________________________
    //validamos si no hay ningun campo en blanco
    public boolean checklogindata(String username ,String password ){
    if 	(username.equals("") || password.equals("")){
    	Log.e("Login ui", "checklogindata user or pass error");
    return false;
    }else{
    	return true;
    	}
    } 
	//_______________________________________________________
    //vibra y muestra un Toast
    public void err_login(){
    	Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    vibrator.vibrate(200);
	    Toast toast1 = Toast.makeText(getApplicationContext(),"Error: Nombre de Usuario o Contrase�a Incorrecto.", Toast.LENGTH_SHORT);
 	    toast1.show();    	
    }
    //_______________________________________________________

    @Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.acces, menu);
		return true;
	}
	@Override
    public boolean onOptionsItemSelected(MenuItem item) 
	{
        switch (item.getItemId()) 
        {
            case R.id.salir:
            	super.onDestroy();
            	finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
		return false;
    }

	//--------- menu ----------------------------
	//Definimos que para cuando se presione la tecla BACK no volvamos para atras  	 
	 @Override
	 public boolean onKeyDown(int keyCode, KeyEvent event)  {
	     if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
	         // no hacemos nada.
	         return true;
	     }

	     return super.onKeyDown(keyCode, event);
	 }

}
