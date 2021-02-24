public class ProblemSet10 {

    public static void main(String[] args) {

    }

    public String[] fizzBuzz(int start, int end) {
        if (start > end) {
            return null;
        }
        else {
            int arrayLength = end-start;
            String [] stringArray = new String[arrayLength];
            int current = start;
            for(int i = 0; i < arrayLength; i ++) {
                if (current % 3 == 0 && current % 5 == 0) {
                    stringArray[i] = "FizzBuzz";
                    current ++;
                }
                else if (current % 3 == 0) {
                    stringArray[i] = "Fizz";
                    current ++;
                }
                else if (current % 5 == 0) {
                    stringArray[i] = "Buzz";
                    current ++;
                }
                else {
                    stringArray[i] = (String.valueOf(current));
                    current ++;
                }
            }
            return stringArray;
        }
    }

    public int maxSpan(int[] numbers) {
        if(numbers == null) {
            return -1;
        }
        else {
            if (numbers.length == 0) {
                return 0;
            }
            else {
                int span = -1;
                for (int i = 0; i < numbers.length; i++) {
                    int currentValue = numbers[i];
                    for (int j = numbers.length - 1; j > i; j--) {
                        if (currentValue == numbers[j] && j - i > span) {
                            span = j - i + 1;
                        }
                    }
                }
                return span;
            }
        }
    }

    public int[] fix34(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        else {
            int threeCount = 0;
            int fourCount = 0;
            boolean threeAfterThree = false;
            boolean fourBeforeThree = false;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 3) {
                    threeCount ++;
                    if(numbers[i + 1] == 3) {
                        threeAfterThree = true;
                    }
                }
                else if (numbers[i] == 4) {
                    if (threeCount == 0) {
                        fourBeforeThree = true;
                    }
                    fourCount ++;
                }
            }

            if (threeCount != fourCount) {
                return null;
            }
            else if(threeAfterThree) {
                return null;
            }
            else if (fourBeforeThree) {
                return null;
            }
            else {
                int temp;
                int lastFour = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] == 3) {
                        int j = lastFour;
                        while (numbers[j] != 4) {
                            j++;
                        }
                        temp = numbers[i + 1];
                        numbers[i + 1] = numbers[j];
                        numbers[j] = temp;
                        lastFour = j;
                    }
                }
                return numbers;
            }
        }
    }

    public int[] fix45(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        else {
            int fourCount = 0;
            int fiveCount = 0;
            boolean fourAfterFour = false;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 4) {
                    fourCount ++;
                    if(numbers[i + 1] == 3) {
                        fourAfterFour = true;
                    }
                }
                else if (numbers[i] == 5) {
                    fiveCount ++;
                }
            }

            if (fourCount != fiveCount) {
                return null;
            }
            else if(fourAfterFour) {
                return null;
            }
            else {
                int temp;
                int lastFive = 0;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] == 4) {
                        int j = lastFive;
                        while (numbers[j] != 5) {
                            j++;
                        }
                        temp = numbers[i + 1];
                        numbers[i + 1] = numbers[j];
                        numbers[j] = temp;
                        lastFive = i + 2;
                    }
                }
                return numbers;
            }
        }
    }

    public boolean canBalance(int[] numbers) {
        if (numbers.length != 0) {
            int sumLeft = 0;
            int sumRight = 0;

            for (int number : numbers) {
                sumRight += number;
            }

            for (int number : numbers) {
                sumRight -= number;
                sumLeft += number;
                if (sumLeft == sumRight) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean linearIn(int[] outer, int[] inner) {
        if (outer == null || inner == null || outer.length == 0 || inner.length == 0) {
            return false;
        }
        else {
            int allIn = 0;
            for (int k : inner) {
                for (int i : outer) {
                    if (k == i) {
                        allIn++;
                    }
                }
            }
            return allIn >= inner.length;
        }
    }

    public int[] squareUp(int n) {
        if(n < 0) {
            return null;
        }
        else {
            int squaredLength = n * n;
            int [] squareUp = new int[squaredLength];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int i = n; i > 0 ; i--) {
                    if (i >= (j + 2)) {
                        squareUp[count] = 0;
                    }
                    else {
                        squareUp[count] = i;
                    }
                    count ++;
                }
            }
            return squareUp;
        }
    }

    public int[] seriesUp(int n) {
        if (n < 0) {
            return null;
        }
        else {
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += i + 1;
            }
            int [] numbers = new int[total];
            int counter = 0;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < i + 1; j++) {
                    numbers[counter] = j;
                    counter ++;
                }
            }
            return numbers;
        }
    }

    public int maxMirror(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        else {
            int count = 0;
            int start;
            int end;
            for (int i = 0; i < numbers.length; i++) {
                for (int j = numbers.length - 1; j > 0; j--) {
                    if (numbers[i] == numbers[j]) {
                        start = i;
                        end = j;
                        count = 1;
                        while(start > 0 && end < numbers.length && numbers[start] == numbers[end]) {
                            start --;
                            end ++;
                            count ++;
                        }
                    }
                }
            }
            return count;
        }
    }

    public int countClumps(int[] numbers) {
        if (numbers == null) {
            return -1;
        }
        else {
            int count = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == numbers[i + 1]) {
                    while(i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                        i++;
                    }
                    count ++;
                }
            }
            return count;
        }
    }
}
