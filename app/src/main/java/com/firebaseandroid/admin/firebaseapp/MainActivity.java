package com.firebaseandroid.admin.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();

    private DatabaseReference usuarioReferencia = firebaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = firebaseReferencia.child("produtos");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        produtoReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString() );


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Usuario usuario = new Usuario();
        usuario.setNome("teste Nome");
        usuario.setSobrenome("Sobrenome Teste");
        usuario.setSexo("MASC");
        usuario.setIdade(18);

        usuarioReferencia.child("002").setValue( usuario );

        Produtos produto = new Produtos();
        produto.setItem("TESTE PRODUTO");
        produto.setCor("TESTE COR");
        produto.setValor(100);

        produtoReferencia.child("003").setValue( produto );


    }
}