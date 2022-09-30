package r09_annotations.t4_targetName;

import com.alvinalexander.simpletest.SimpleTest;
    
public class JTargetName {
    public static void main(String[] args) {
        // use the name 'plus1' in java code
        int i = TargetNameDemo.plus1(1);
        System.out.println(i);
        SimpleTest.Equals(i, 2);
    }
}

