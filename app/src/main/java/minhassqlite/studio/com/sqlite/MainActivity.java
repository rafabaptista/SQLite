package minhassqlite.studio.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null); //mode_private = acessível somente ao app

            //tabela
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3)) ");

            //inserir dados na tabela
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Rafael', 28) ");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Ana', 20) ");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Wilma', 57) ");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Wesley', 24) ");
            //

            //bancoDados.execSQL("UPDATE pessoas SET idade = 29 WHERE nome = 'Wesley' ");

            //bancoDados.execSQL("DELETE FROM pessoas WHERE nome = 'Wesley' ");

            //bancoDados.execSQL("DROP TABLE pessoas ");

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3)) ");

            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Rafael', 28) ");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Écio', 32) ");

            //recuperar dados
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas", null);

            //indice da coluna
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaId = cursor.getColumnIndex("id");

            //voltar cursor para começo
            cursor.moveToFirst();

            while (cursor != null) {

                Log.i("RESULTADO - id: ", cursor.getString(indiceColunaId));
                Log.i("RESULTADO - nome: ", cursor.getString(indiceColunaNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceColunaIdade));

                //vai para próxima linha do cursor
                cursor.moveToNext();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
