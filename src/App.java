
void main() {
    int val = 0;
    // int[][] seats = { {01, 2, 3, 4},
    //                   {5, 6, 7, 8},
    //                   {9, 10, 11, 12},
    //                   {13, 14, 15, 16},
    //                   {17, 18, 19, 20} };
    // int[] seats = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    String[] seats = {"01", "02", "030000", "04", "05", "06", "07", "080000", "09", "10", "11", "120000", "13", "14", "15", "16", "17", "18", "19", "20"};
    
    while (val != 4) {
        val = 0;
        IO.println("\n1: Lägg till bokning\n2: Visa innehåll\n3: Beräkna vinst\n4: Avsluta");
        try {
            val = Integer.parseInt(IO.readln("Välj: "));
        } catch (Exception e) {
        }
        switch (val) {
            case 1 -> {

                int seat = chooseSeat(seats);
                String ID = enterIdentification(seats);
                seats[seat] = ID;

            }
            case 2 -> {

                printSeats(seats);

            }
            case 3 -> {

                IO.println(calculateEarnings(seats));

            }
            case 4 -> {break;}
            default -> {
                IO.println("Ogiltigt val, försök igen");
            }
        }
        
    }
    
    printSeats(seats);
    
}

double calculateEarnings(String[] seats) {
    double profit = 0;
    int people = 0;
    for (int i = 0; i < seats.length; i++) {
        boolean occupied = false;
        try {
            int foo = Integer.parseInt(seats[i]);
            if (foo > 20) {
                occupied = true;
            }
        } catch (Exception e) {
            occupied = true;
        }
        if (occupied) {
            people++;
        }
    }
    profit = people * 299.90;
    profit = (double) Math.round(profit * 100) / 100;
    return profit;
}

String enterIdentification(String[] seats) {
    int tmp = 0;
    String s_date = "";

    while (true) {
        s_date = IO.readln("Enter your birth date (YYMMDD): ");
        try {
            tmp = Integer.parseInt(s_date);
            if (tmp > 999999 || tmp < 000101) {
                IO.println("Incorrect input, try again");
            }
            else break;
        } catch (Exception e) {
            IO.println("Incorrect input, try again");
        }
    }
    return s_date;
}

int chooseSeat(String[] seats) {

    int foo = 0;
    String s_foo = "";

    while (true) {
        printAvailableSeats(seats);
        s_foo = IO.readln("\nPlease select a seat: ");
        try {
            foo = Integer.parseInt(s_foo);
            break;
        } catch (Exception e) {
            IO.println("Incorrect input, try again");
        }
    }
    return foo - 1;
}

void printSeats(String[] seats) {
    for (int i = 0; i < seats.length; i++) {
        if (i % 2 == 0 && i % 4 != 0) {
            IO.print("  |");
        }
        if (i % 4 == 0) {
            IO.print("\n|" + seats[i] + "|");
        } else {
            IO.print(seats[i] + "|");
        }
    }
    // for (int row = 0; row < seats.length; row++) {
        //     for (int col = 0; col < seats[row].length; col++) {
            //         IO.print("|");
            //         if (seats[row][col] > 20) {
                //             IO.print(" X");
                //         }
    //         else {
    //             if (seats[row][col] < 10) {
        //                 IO.print(" ");
        //             }
        //             IO.print(seats[row][col]);
    //         }
    //         if ((col+1) == (seats[col].length/2)) {
        //             IO.print("|  ");
    //         }
    //     }
    //     IO.print("|\n");
    // }
}

void printAvailableSeats(String[] seats) {
    for (int i = 0; i < seats.length; i++) {
        boolean occupied = false;
        try {
            int foo = Integer.parseInt(seats[i]);
            if (foo > 20) {
                occupied = true;
            }
        } catch (Exception e) {
            occupied = true;
        }
        if (i % 2 == 0 && i % 4 != 0) {
            IO.print("  |");
        }
        if (i % 4 == 0) {
            if (occupied) {
                IO.print("\n| x|");
            } else {IO.print("\n|" + seats[i] + "|");}
        } else {
            if (occupied) {
                IO.print(" x|");
            } else {IO.print(seats[i] + "|");}
        }
    }
}
//    1  2      3  4
// A |1 |2 |   |3 |4 |
// B |5 |6 |   |7 |8 |
// C |9 |10|   |11|12|
// D |13|14|   |15|16|
// E |17|18|   |19|20|