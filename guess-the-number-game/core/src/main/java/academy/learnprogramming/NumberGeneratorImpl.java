package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

    // == public methods ==
    @Override
    public int next() {
        // example: min=5 max=20 -> max - min=15 -> range 0-15 + min -> 5-20
        return random.nextInt(maxNumber - minNumber) + minNumber;
        //return (int) Math.floor(Math.random() *(maxNumber - minNumber + 1) + minNumber); //mine, above is Tim's
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
