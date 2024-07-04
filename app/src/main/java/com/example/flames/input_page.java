package com.example.flames;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;

public class input_page extends AppCompatActivity {
    TextInputEditText your_name;
    TextInputEditText their_name;
    List<Character> list_1=new ArrayList<>();
    List<Character> list_2=new ArrayList<>();
    List<Character> list_3=new ArrayList<>();
    public static String String_Relation="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_page);
        your_name = findViewById(R.id.your_name);
        their_name =findViewById(R.id.their_name);
    }

    public void onClickOfFindButton(View v){
        findRelationship();
        Intent i=new Intent(this,output_page.class);
        startActivity(i);

    }
    public void findRelationship() {
        String input1 = String.valueOf(your_name.getText()).toLowerCase();
        String input2 = String.valueOf(their_name.getText()).toLowerCase();
        System.out.println("input_1 : " + input1);
        System.out.println("input_2 : " + input2);
        List<Character> dup_list1 = new ArrayList<>();
        for (char c : input1.toCharArray()) {
            if(c!=' '){
                dup_list1.add(c);
            }
        }
        List<Character> dup_list2 = new ArrayList<>();
        for (char c : input2.toCharArray()) {
            if(c!=' ') {
                dup_list2.add(c);
            }
        }
        list_1 = dup_list1;
        list_2 = dup_list2;
        removeElement(dup_list1, dup_list2);
        System.out.println("output_list1 : " + list_1);
        System.out.println("output_list2 : " + list_2);
        int countOfRestLetters = list_1.size() + list_2.size();
        if(countOfRestLetters!=0){
        String str = "FLAMES";
        for (char c : str.toCharArray()) {
            list_3.add(c);
        }
        System.out.println("111111" + list_3);
        System.out.println("22222" + countOfRestLetters);
        findLetter(list_3, countOfRestLetters);
        System.out.println("@@@@@@@@@@" + list_3);
            letterToRelation(list_3.get(0));
    }else{
            letterToRelation('U');
        }
        System.out.println("RELATIONSHIP ::::: "+String_Relation);
    }
        public void removeElement(List<Character> list1, List<Character> list2){
                for(int i=0;i<list1.size();i++){
                    for(int k=0;k<list2.size();k++){
                        if(list1.get(i).equals(list2.get(k))){
                            list_1=list1;
                            list_1.remove(list1.get(i));
                            list_2=list2;
                            list_2.remove(list2.get(k));
                            removeElement(list_1,list_2);
                            break;
                        }
                    }
                }
        }

        public void findLetter(List<Character> list,int i){
        if(list.size()==1){
            list_3=list;
            return;
        }
         List<Character> list_temp;
            list_temp = list;
            int j;
            if(list_temp.size()<i){
                j=i%list_temp.size();
            }else {
                j=i;
            }
            if(j==0){
                j=list_temp.size()-1;
            }else{
                j=j-1;
            }
            System.out.println("4444444444"+j);
            int y=0;
         for(int k=0;k<list.size();k++){
             if(k==j){
                 list_temp.remove(k);
                 y=k;
             }
         }
         List<Character> changed_list;
         System.out.println("***** "+list_temp+" +++ "+y);
         changed_list=changeOrder(list_temp,y);
            findLetter(changed_list,i);
        }

        public List<Character> changeOrder(List<Character> list ,int p){
        int k=p;
        List<Character> changed_list=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(k<list.size()){
                changed_list.add(list.get(k));
            }else{
                k=0;
                changed_list.add(list.get(k));
            }
            k++;
        }
        System.out.println("%%%%%%%%%%%%"+changed_list);
        return changed_list;
        }

        public void letterToRelation(char c){
        switch (c){
            case 'F':
                String_Relation="      FRIENDS";
                list_3.clear();
                break;
            case 'L':
                String_Relation="      LOVERS";
                list_3.clear();
                break;
            case 'A':
                String_Relation="   AFFECTION";
                list_3.clear();
                break;
            case 'M':
                String_Relation="   MARRIAGE";
                list_3.clear();
                break;
            case 'E':
                String_Relation="     ENEMIES";
                list_3.clear();
                break;
            case 'S':
                String_Relation="       SISTER";
                list_3.clear();
                break;
            case 'U':
                String_Relation="   CAN'T FIND";
                list_3.clear();
                break;
        }
        }

    }