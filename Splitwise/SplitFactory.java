package Splitwise;

public class SplitFactory {
    public static SplitStrategy getSplitStrategy(SplitType splitType)
    {
        if(splitType==SplitType.EXACT)
            return new ExactSplit();
        else return new EqualSplit();
    }
}
