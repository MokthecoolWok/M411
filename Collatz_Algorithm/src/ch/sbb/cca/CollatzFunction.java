package ch.sbb.cca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollatzFunction {
    private List<List<Integer>> listOfSequences = new ArrayList<List<Integer>>();

    public void findLongestSequence(){
        for(int i = 1; i < 100000; i++){
            int number = i;
            List<Integer> sequenceList = new ArrayList<Integer>();
            while(number != 1){
                if(number % 2 == 0){
                    number /= 2;
                } else {
                    number = (number * 3) + 1;
                }
                sequenceList.add(number);
            }
            listOfSequences.add(sequenceList);
        }

        int indexLongestSequence = 0;
        for(int i = 0; i < listOfSequences.size(); i++){
            if(listOfSequences.get(indexLongestSequence).size() < listOfSequences.get(i).size()){
                indexLongestSequence = i;
            }
        }

        System.out.println(indexLongestSequence + 1 + ": " + listOfSequences.get(indexLongestSequence).size());
    }
}
