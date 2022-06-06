package com.ma.lap3;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class DetailsFragment extends Fragment {


    //
    private static final String [] TURTLE_DETAILS={
            "Leonardo, nicknamed Leo, is a fictional character appearing in Teenage Mutant Ninja Turtles comics and related media," +
                    " and created by American comic book artists, Kevin Eastman and Peter Laird. He is one of the four central characters" +
                    " of the franchise, along with his brothers, Donatello, Raphael and Michelangelo. Often depicted wearing a blue bandanna, " +
                    "his signature weapons are two katana. In most iterations, Leonardo is portrayed as the leader, as well as the most mature and" +
                    " disciplined of the Turtles. Like his brothers, he is named after an Italian Renaissance artist, in this case, Leonardo da" +
                    " Vinci. In the original comics, all four of the Turtles wear red masks, but for the creators to tell them apart, he was written" +
                    " and redrawn to have an ocean-blue mask.",

            "Michelangelo, nicknamed Mike or Mikey, is a fictional superhero and one of the four main characters of the Teenage Mutant Ninja" +
                    " Turtles comics and all related media.[2] Michaelangelo is the most naturally skilled of the four brothers but prefers to" +
                    " have a good time rather than train. The youngest of the group, he is shown to be rather immature; he is known for his wisecracks" +
                    ", love of skateboarding, witty optimism, and, like his brothers, love of pizza. He is usually depicted wearing an orange eye mask" +
                    ". His signature weapons are dual nunchaku, though he has also been portrayed using other weapons, such as a grappling hook, " +
                    "manriki-gusari, tonfa, and a three-section staff (in some action figures). Michelangelo was given a much bigger role in the " +
                    "1987 cartoon series and subsequent series and films, directed at a younger audience, than in the more serious Mirage comic " +
                    "books.[3] which were aimed at an older audience, expressing interest in poetry and romancing Horridus. He often coins most of " +
                    "their catchphrases, such as Cowabunga!. Like all of the brothers, he is named after an Italian Renaissance artist; in this case," +
                    " he is named after Michelangelo Buonarroti. His name was originally spelled Michaelangelo by the original creators, possibly" +
                    " misspelling his namesake's name wrong by confusion with Michael. In the Mirage comics, all four of the Turtles wear red masks," +
            " but to tell them apart, he was given an orange mask instead.",

            "Donatello, nicknamed Don or Donnie, is a fictional superhero and one of the four main characters of the Teenage Mutant Ninja Turtles " +
                    "comics and all related media.[2][3] He is co-creator Peter Laird's favorite Turtle. In the Mirage comics, all four of the Turtles" +
                    " wear red masks. In the animated cartoons, he dons a purple mask. The creators gave all four turtles different mask colors, in " +
                    "order to tell them apart. He is usually depicted wearing a purple eye mask. His primary signature weapon is his effective bō " +
                    "staff. In all media, he is the smartest of the four turtles. He is the third eldest/second youngest brother of the turtles, and " +
                    "second in command of the team. A common trait in the franchise is that he is the tallest ninja turtle, demonstrated in the " +
                    "original comics (however very slightly), the IDW comics, the DC crossover film, the 2014 reboot, and most notably, in the 2012 " +
                    "animated series. Donnie often speaks in technobabble with a natural aptitude for science and technology. His ninja skills are" +
                    " the lowest of the four turtles; as he relies on gadgets over combat skills. Like all of the brothers, he is named after a " +
                    "Renaissance artist; in this case, he is named after Italian sculptor Donatello.",

            "Raphael, nicknamed Raph, is a fictional superhero and one of the four main characters of the Teenage Mutant Ninja Turtles comics and " +
                    "all related media.[2] He is the second oldest/mid-middle-child of the turtle brothers, often at odds with his older brother, " +
                    "Leonardo.[2] He is usually depicted wearing a red eye mask; in this regard, he is the only turtle to retain this color since" +
                    " the original incarnation of the characters, as the remaining turtles received different colors at a later time. Raphael wields" +
                    " twin sai as his primary weapon. He is commonly portrayed in media as speaking with a Brooklyn accent. Raphael is known for his" +
                    " temperamental and cynical personality, being short-tempered, aggressive, sullen, maddened, sarcastic, and rebellious.[3] The " +
                    "origin of Raphael's anger is not always fully explored, but in some incarnations appears to stem partly from the realization " +
                    "that they are the only creatures of their kind and ultimately alone."
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Intent intent= getActivity().getIntent();
        int id = intent.getIntExtra("turtle_id",R.id.leo);
        setTurtleId(id);
    }

    public void setTurtleId(int id){
        int index;
        if (id == R.id.leo){
            index=0;
        }else if(id == R.id.mike){
            index=1;
        }else if(id == R.id.don){
            index=2;
        }else {
            index=3;
        }
        String text=TURTLE_DETAILS[index];
        TextView tv =(TextView) getActivity().findViewById(R.id.turtle_info);
        tv.setText(text);
    }

}