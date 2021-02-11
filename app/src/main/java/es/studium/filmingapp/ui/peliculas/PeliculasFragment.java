package es.studium.filmingapp.ui.peliculas;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.Anime;
import es.studium.filmingapp.AnimeAdapter;
import es.studium.filmingapp.Caraturas;
import es.studium.filmingapp.Detalles;
import es.studium.filmingapp.ItemClickListener;
import es.studium.filmingapp.R;

public class PeliculasFragment extends Fragment {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    public static List<Anime> items;
    public static int posicion = -1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_peliculas, container, false);

        // Inicializar Animes
        items = new ArrayList();

        items.add(new Anime(R.drawable.iron_man, "Iron Man","","Jon Favreau"," Robert Downey Jr., Terrence Howard, Gwyneth Paltrow",R.drawable.cuatro_estrellas_y_media,"El multimillonario fabricante de armas Tony Stark (Robert Downey Jr.) debe enfrentarse a su turbio pasado después de sufrir un accidente con una de sus armas. Equipado con una armadura de última generación tecnológica, se convierte en \"El hombre de hierro\", un héroe que se dedica a combatir el mal en todo el mundo.", ""));
        items.add(new Anime(R.drawable.piratas_del_caribe, "Piratas del Caribe","La maldición de la Perla Negra","Gore Verbinski","Johnny Depp, Orlando Bloom, Keira Knightley, Geoffrey Rush, Jack Davenport, Kevin McNally, Jonathan Pryce, Mackenzie Crook, Lee Arenberg, Zoe Saldana, Giles New, Angus Barnett, Damian O'Hare, Michael Berry, Isaac C. Singleton, Treva Etienne, Lucinda Dryzek",R.drawable.cuatro_estrellas_y_media,"Mar Caribe, siglo XVIII. El aventurero capitán Jack Sparrow piratea en aguas caribeñas, pero su andanzas terminan cuando su enemigo, el Capitán Barbossa, después de robarle su barco, el Perla Negra, ataca la ciudad de Port Royal y secuestra a Elizabeth Swann, la hija del Gobernador. Will Turner, amigo de la infancia de Elizabeth, se une a Jack para rescatarla y recuperar el Perla Negra. Pero Barbossa y su tripulación son víctimas de un conjuro que los condena a vivir eternamente y a transformarse cada noche en esqueletos vivientes. El conjuro sólo puede romperse si devuelven una pieza de oro azteca y saldan una deuda de sangre. El rescate de la bella Elizabeth será una tarea difícil, pues la maldición es real y será difícil enfrentarse con quienes no pueden morir.", ""));
        items.add(new Anime(R.drawable.el_senor_de_los_anillos, "El Señor de los Anillos","La comunidad del anillo","Peter Jackson","Elijah Wood, Ian McKellen, Viggo Mortensen, Sean Astin, Sean Bean, John Rhys-Davies, Orlando Bloom, Dominic Monaghan, Billy Boyd, Cate Blanchett, Hugo Weaving, Liv Tyler, Ian Holm, Christopher Lee, Lawrence Makoare, Craig Parker, Andy Serkis, Marton Csokas",R.drawable.cuatro_estrellas_y_media,"En la Tierra Media, el Señor Oscuro Sauron ordenó a los Elfos que forjaran los Grandes Anillos de Poder. Tres para los reyes Elfos, siete para los Señores Enanos, y nueve para los Hombres Mortales. Pero Saurón también forjó, en secreto, el Anillo Único, que tiene el poder de esclavizar toda la Tierra Media. Con la ayuda de sus amigos y de valientes aliados, el joven hobbit Frodo emprende un peligroso viaje con la misión de destruir el Anillo Único. Pero el malvado Sauron ordena la persecución del grupo, compuesto por Frodo y sus leales amigos hobbits, un mago, un hombre, un elfo y un enano. La misión es casi suicida pero necesaria, pues si Sauron con su ejército de orcos lograra recuperar el Anillo, sería el final de la Tierra Media.", ""));
        items.add(new Anime(R.drawable.el_hobbit, "El Hobbit","Un viaje inesperado","Peter Jackson","Martin Freeman, Ian McKellen, Richard Armitage, Ken Stott, Graham McTavish, Aidan Turner, James Nesbitt, Dean O'Gorman, Peter Hambleton, Stephen Hunter, John Callen, Adam Brown, William Kircher, Jed Brophy, Mark Hadlow, Ian Holm, Sylvester McCoy, Andy Serkis, Hugo Weaving, Cate Blanchett, Christopher Lee, Elijah Wood, Barry Humphries, Manu Bennett, Bret McKenzie, Terry Notary",R.drawable.cuatro_estrellas_y_media,"Precuela de la trilogía \"El Señor de los Anillos\", obra de J.R.R. Tolkien. En compañía del mago Gandalf y de trece enanos, el hobbit Bilbo Bolsón emprende un viaje a través del país de los elfos y los bosques de los trolls, desde las mazmorras de los orcos hasta la Montaña Solitaria, donde el dragón Smaug esconde el tesoro de los Enanos. Finalmente, en las profundidades de la Tierra, encuentra el Anillo Único, hipnótico objeto que será posteriormente causa de tantas sangrientas batallas en la Tierra Media.", ""));
        items.add(new Anime(R.drawable.star_wars, "Star Wars","Episodio IV: Una nueva esperanza","George Lucas","Mark Hamill, Harrison Ford, Carrie Fisher, Alec Guinness, Peter Cushing, David Prowse, Peter Mayhew, Anthony Daniels, Kenny Baker, Phil Brown, Shelagh Fraser, Garrick Hagon, Denis Lawson, Alex McCrindle, Richard LeParmentier, Drewe Henley, Jack Purvis, Don Henderson, William Hootkins, Malcolm Tierney",R.drawable.cuatro_estrellas_y_media,"La princesa Leia, líder del movimiento rebelde que desea reinstaurar la República en la galaxia en los tiempos ominosos del Imperio, es capturada por las Fuerzas Imperiales, capitaneadas por el implacable Darth Vader, el sirviente más fiel del Emperador. El intrépido y joven Luke Skywalker, ayudado por Han Solo, capitán de la nave espacial \"El Halcón Milenario\", y los androides, R2D2 y C3PO, serán los encargados de luchar contra el enemigo e intentar rescatar a la princesa para volver a instaurar la justicia en el seno de la galaxia.", ""));
        items.add(new Anime(R.drawable.harry_potter, "Harry Potter y la piedra filosofal","","Chris Columbus","Daniel Radcliffe, Rupert Grint, Emma Watson, Robbie Coltrane, Richard Harris, Maggie Smith, Alan Rickman, Richard Griffiths, Tom Felton, Ian Hart, John Hurt, Harry Melling, John Cleese, Matthew Lewis, Warwick Davis, David Bradley, Fiona Shaw, Sean Biggerstaff, Devon Murray, Alfred Enoch, Zoe Wanamaker, James Phelps, Oliver Phelps, Julie Walters",R.drawable.cuatro_estrellas_y_media,"El día en que cumple once años, Harry Potter se entera de que es hijo de dos destacados hechiceros, de los que ha heredado poderes mágicos. En la escuela Hogwarts de Magia y Hechicería, donde se educa con otros niños que también tienen poderes especiales, aprenderá todo lo necesario para ser mago.", ""));

        // Obtener el Recycler
        recycler = root.findViewById(R.id.myRecyclerView);
        recycler.setHasFixedSize(true);


        //Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new AnimeAdapter(items, new ItemClickListener() {
            @Override
            public void onClick(View v, int position) {

                switch (v.getId()){
                    case R.id.imagen:
                        posicion = position;
                       Intent intent = new Intent(getActivity(), Caraturas.class);
                       //intent.putExtra("posicion", position+"");
                       startActivity(intent);

                        break;
                    case R.id.nombre:
                        posicion = position;
                        Intent intentS = new Intent(getActivity(), Detalles.class);
                        //intent.putExtra("posicion", position+"");
                        startActivity(intentS);
                        break;
                }
            }
        });


        recycler.setAdapter(adapter);



        return root;
    }




}




