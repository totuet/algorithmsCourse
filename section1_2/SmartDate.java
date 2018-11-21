package section1_2;

/*
Develop an implementation SmartDate of our Date API that raises an exception
if the date is not legal.
 */

public class SmartDate {
    private int year;
    private int month;
    private int day;


    public SmartDate(int year, int month, int day) {
        if (!isValidDate(month, day)) throw new IllegalArgumentException("Invalid date");
        this.month = month;
        this.year = year;
        this.day = day;
    }

    public boolean isValidDate(int month, int day) {
        boolean valid = true;

        int[] numberOfDaysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

        if (    month < 1 ||
                month > 12 ||
                day < 1 ||
                day > numberOfDaysInMonths[month-1]
                ) {
            valid = false;
        }



        return valid;
    }


    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }
    /*
    The Key Value Method


Take the last 2 digits of the year. In our example, this is 82.

Divide by 4, and drop any remainder. 82 / 4 = 20, remainder 2, so we think "20."

Add the day of the month. In our example, 20 + 16 = 36.

Add the month's key value, from the following table.
Jan	Feb	Mar	Apr	May	June	July	Aug	Sept	Oct	Nov	Dec
1	4	4	0	2	5	      0	      3	  6	     1	4	6

The month for our example is December, with a key value of 6. 36 + 6 = 42.

If your date is in January or February of a leap year, subtract 1.
Add the century code from the following table. (These codes are for the Gregorian calendar. The rule's slightly simpler for Julian dates.)
1700s	1800s	1900s	2000s
  4	      2	      0	      6

Our example year is 2482, and the 2400s aren't in the table. Luckily, the Gregorian calendar repeats every four hundred years. All we have to do is add or subtract 400 until we have a date that is in the table. 2482 - 400 = 2082, so we look at the table for the 2000s, and get the code 6. Now we add this to our running total: 42 + 6 = 48.

Add the last two digits of the year. 48 + 82 = 130.

Divide by 7 and take the remainder. This time, 1 means Sunday, 2 means Monday, and so on. A remainder of 0 means Saturday. 130 / 7 = 18, remainder 4, so December 16, 2482 will be on the fourth day of the week-- Wednesday.
     */

    public String dayOfTheWeek() {
        String[] daysOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        int[] monthKeyValues = {1,4,4,0,2,5,0,3,6,1,4,6};
        int year = this.getYear();
        int lastTwoDigits = Integer.parseInt(Integer.toString(year).substring(2,4));
        int temp = (lastTwoDigits / 4) + this.getDay() + monthKeyValues[this.getMonth()-1] + this.getYear()>2000?6:0 + lastTwoDigits;
        return daysOfWeek[(temp%7)-1];




    }

    @Override
    public String toString() {
        return "SmartDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    public static void main(String[] args) {


                SmartDate date1 = new SmartDate(1991, 07, 31);
                SmartDate date2 = new SmartDate(1963, 10, 19);
                SmartDate date3 = new SmartDate(1994, 04, 22);
                SmartDate date4 = new SmartDate(2018, 11, 11);

                System.out.println(date1);
                System.out.println(date1.dayOfTheWeek());
                System.out.println(date2);
                System.out.println(date2.dayOfTheWeek());
                System.out.println(date3);
                System.out.println(date2.dayOfTheWeek());





    }
}


